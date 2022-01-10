package ru.telegram.learn.english.bot.service.command.builder;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendInvoice;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.payments.LabeledPrice;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.telegram.learn.english.bot.business.action.*;
import ru.telegram.learn.english.bot.business.bot.CallbackType;
import ru.telegram.learn.english.bot.config.BotConfig;
import ru.telegram.learn.english.bot.entity.*;
import ru.telegram.learn.english.bot.service.user.UserService;
import ru.telegram.learn.english.bot.service.word.WordService;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SendWordsMessageActionBuilder {

    private final UserService userService;
    private final WordService wordService;
    private final BotConfig botConfig;

    public SendWordsMessageActionBuilder(UserService userService, WordService wordService, BotConfig botConfig) {
        this.userService = userService;
        this.wordService = wordService;
        this.botConfig = botConfig;
    }

    public CommandActions build(String chatId, Long userId) {
        CommandActions commandActions = new CommandActions();
        UserEntity userEntity = userService.getById(userId);
        UserSettings userSettings = userEntity.getUserSettings();

        if (userEntity.getLearningProcess().getLearningStatus() == UserLearningStatus.FINISHED) {
            userService.restartLearnProcess(userEntity);
        }

        List<Word> words = wordService.getWords(userEntity, botConfig.getSettings().getWordsPageSize());

        if (!words.isEmpty()) {
            StringBuilder wordsText = new StringBuilder();
            List<BotAction<?>> audioActions = new ArrayList<>();
            int index = 1;
            for(Word word: words) {
                wordsText.append(index)
                        .append(". `")
                        .append(word.getWord())
                        .append("` - ")
                        .append(word.getTranslation())
                        .append(" ")
                        .append( (word.getEmoji() != null) ? word.getEmoji() : "")
                        .append("\n");
                audioActions.add(buildAudioAction(chatId, word));
                index++;
            }

            List<String> wordIds = words.stream().map(Word::getId).collect(Collectors.toList());
            String callbackData = String.join(",", wordIds);


           // if (userSettings.getWordsViewType() != WordsViewType.ONLY_AUDIO) {
                commandActions.add(buildMessageAction(chatId, wordsText.toString(), callbackData));
           // }

//            if (userSettings.getWordsViewType() != WordsViewType.ONLY_WORDS) {
//                commandActions.addAll(audioActions);
//            }
        }
        else {
            userService.finishLearnByUser(userEntity);
            String wordsText = "Похоже, ты уже изучил(а) все английские слова, " +
                    "которые я знаю, если хочешь, то можем начать сначала \uD83D\uDE42 (для этого нажми команду ниже) \n";

            commandActions.add(buildMessageAction(chatId, wordsText, null));
        }

        //commandActions.add(buildMessageAction(chatId, "/words - ещё слова"));
        //commandActions.add(buildInvoiceAction(chatId));

        return commandActions;
    }

    public CommandActions buildAudioMessage(String chatId, List<String> wordIds) {
        CommandActions commandActions = new CommandActions();
        List<Word> words = wordService.getWordsByIds(wordIds);

        if (!words.isEmpty()) {
            for (Word word : words) {
                commandActions.add(buildAudioAction(chatId, word));
            }
        }

        return commandActions;
    }

    public SendMessageAction buildMessageAction(String chatId, String text, String callbackData) {
        SendMessage wordsMsg = new SendMessage(chatId, text);
        wordsMsg.enableMarkdown(true);
        if (callbackData != null && !callbackData.isBlank()) {
            wordsMsg.setReplyMarkup(buildInlineKeyboard(callbackData));
        }
        return new SendMessageAction(wordsMsg);
    }

    public SendInvoiceAction buildInvoiceAction(String chatId) {
        SendInvoice sendInvoice = new SendInvoice();
        sendInvoice.setChatId(chatId);
        sendInvoice.setTitle("Полный доступ");
        sendInvoice.setDescription("Полный доступ");
        sendInvoice.setPayload("payload");
        sendInvoice.setProviderToken("401643678:TEST:f2619bea-6991-4240-847d-63721146fbf7");
        sendInvoice.setStartParameter("param");
        sendInvoice.setCurrency("RUB");
        LabeledPrice labeledPrice = new LabeledPrice();
        labeledPrice.setLabel("RUB");
        labeledPrice.setAmount(10000);
        sendInvoice.setPrices(Collections.singletonList(labeledPrice));

        return new SendInvoiceAction(sendInvoice);
    }

    public SendAudioAction buildAudioAction(String chatId, Word word) {
        try {
            InputStream is = new URL(word.getAudio().getAudioLinkUK()).openStream();
            InputFile inputFile = new InputFile(is, word.toString());
            SendAudio sa = new SendAudio(chatId, inputFile);
            return new SendAudioAction(sa);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static InlineKeyboardMarkup buildInlineKeyboard(String callbackData) {

        InlineKeyboardMarkup.InlineKeyboardMarkupBuilder builder = InlineKeyboardMarkup.builder();

        builder.keyboardRow(Collections.singletonList(
                buildBtn("\uD83C\uDFB5", CallbackType.GA + callbackData)
        ));

        return builder.build();
    }

    private static InlineKeyboardButton buildBtn(String text, String callback) {
        InlineKeyboardButton btn = new InlineKeyboardButton();

        btn.setText(text);
        btn.setCallbackData(callback);
        return btn;
    }
}
