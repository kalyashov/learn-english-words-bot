package ru.telegram.learn.english.bot.scheduler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.telegram.learn.english.bot.LearnEnglishWordsBot;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.business.action.SendMessageAction;
import ru.telegram.learn.english.bot.config.BotConfig;
import ru.telegram.learn.english.bot.entity.Word;
import ru.telegram.learn.english.bot.service.word.WordService;

import java.util.List;

@Component
public class ChannelMessageSender {

    private static final String CRON = "0 */1 * * * *";
    private static final String CHANNEL_ID = "-1001573779809";
    private final WordService wordService;
    private final BotConfig botConfig;
    private final LearnEnglishWordsBot bot;

    public ChannelMessageSender(WordService wordService, BotConfig botConfig, LearnEnglishWordsBot bot) {
        this.wordService = wordService;
        this.botConfig = botConfig;
        this.bot = bot;
    }

    //@Scheduled(cron = CRON)
    public void sendWords() {

        CommandActions commandActions = new CommandActions();
        List<Word> words = wordService.getRandomWords(10);


        if (!words.isEmpty()) {
            StringBuilder wordsText = new StringBuilder();
            int index = 1;
            for (Word word : words) {
                wordsText.append(index)
                        .append(". `")
                        .append(word.getWord())
                        .append("` - ")
                        .append(word.getTranslation())
                        .append(" ")
                        .append((word.getEmoji() != null) ? word.getEmoji() : "")
                        .append("\n");
                index++;
            }

            SendMessage wordsMsg = new SendMessage(CHANNEL_ID, wordsText.toString());
            commandActions.add(new SendMessageAction(wordsMsg));

            bot.processActions(commandActions.getActions());
        }
    }

}
