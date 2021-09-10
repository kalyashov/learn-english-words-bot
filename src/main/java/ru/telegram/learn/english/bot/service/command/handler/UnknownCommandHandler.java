package ru.telegram.learn.english.bot.service.command.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.business.action.SendMessageAction;
import ru.telegram.learn.english.bot.business.action.SendStickerAction;
import ru.telegram.learn.english.bot.business.bot.StickerId;
import ru.telegram.learn.english.bot.config.BotConfig;

import java.util.Arrays;

@Component
public class UnknownCommandHandler implements CommandHandler<SendMessage> {

    private final BotConfig botConfig;

    public UnknownCommandHandler(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public CommandActions handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String stickerId = botConfig.getStickers().get(StickerId.HMM);

        SendSticker ss = new SendSticker(chatId, new InputFile(stickerId));
        SendStickerAction ssa = new SendStickerAction(ss);

        SendMessage sm = new SendMessage(chatId, botConfig.getMessages().getUnknownCommand());
        SendMessageAction sma = new SendMessageAction(sm);

        return new CommandActions(Arrays.asList(sma, ssa));
    }
}
