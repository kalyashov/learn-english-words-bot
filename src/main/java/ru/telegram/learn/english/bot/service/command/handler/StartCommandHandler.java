package ru.telegram.learn.english.bot.service.command.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.business.action.SendMessageAction;
import ru.telegram.learn.english.bot.business.action.SendStickerAction;
import ru.telegram.learn.english.bot.business.bot.StickerId;
import ru.telegram.learn.english.bot.config.BotConfig;
import ru.telegram.learn.english.bot.entity.UserEntity;
import ru.telegram.learn.english.bot.entity.UserLearningStatus;
import ru.telegram.learn.english.bot.service.command.builder.SendWordsMessageActionBuilder;
import ru.telegram.learn.english.bot.service.user.UserService;


@Component
public class StartCommandHandler implements CommandHandler<SendMessage> {

    private final UserService userService;
    private final BotConfig botConfig;
    private final SendWordsMessageActionBuilder sendWordsMessageActionBuilder;

    public StartCommandHandler(UserService userService, BotConfig botConfig,
                               SendWordsMessageActionBuilder sendWordsMessageActionBuilder) {
        this.userService = userService;
        this.botConfig = botConfig;
        this.sendWordsMessageActionBuilder = sendWordsMessageActionBuilder;
    }

    @Override
    public CommandActions handle(Update update) {
        Message message = update.getMessage();
        String chatId = message.getChatId().toString();
        Long userId = message.getFrom().getId();

        SendMessage startLearnMsg = new SendMessage(chatId, botConfig.getMessages().getStartLearning());
        UserEntity userEntity = userService.getById(userId);
        CommandActions actions = new CommandActions();

        if (userEntity == null) {
            userService.startLearnProcess(message.getFrom(), chatId);
        } else if (userEntity.getLearningProcess().getLearningStatus() == UserLearningStatus.PAUSED) {
            userService.continueLearnProcess(userEntity);
            startLearnMsg = new SendMessage(chatId, botConfig.getMessages().getResumeLearning());
        } else {
            startLearnMsg = new SendMessage(chatId, botConfig.getMessages().getLearningAlreadyStarted());
            actions.add(new SendMessageAction(startLearnMsg));
            return actions;
        }

        String stickerId = botConfig.getStickers().get(StickerId.THUMBS_UP);
        SendSticker ss = new SendSticker(chatId, new InputFile(stickerId));

        actions.add(new SendStickerAction(ss));
        actions.add(new SendMessageAction(startLearnMsg));

        actions.addAll(sendWordsMessageActionBuilder.build(chatId, userId).getActions());

        return actions;
    }
}
