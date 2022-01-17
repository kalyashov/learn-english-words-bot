package ru.telegram.learn.english.bot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import ru.telegram.learn.english.bot.business.bot.StickerId;

import java.util.HashMap;
import java.util.List;

@ConstructorBinding
@ConfigurationProperties(prefix = "learn-english-words-bot")
public class BotConfig {

    private @Getter @Setter Bot bot;
    private @Getter @Setter Settings settings;
    private @Getter @Setter Messages messages;
    private @Getter @Setter HashMap<StickerId, String> stickers;
    private @Getter @Setter Payment payment;

    public static class Bot {
        private @Getter @Setter String name;
        private @Getter @Setter String token;
    }

    public static class Settings {
        private @Getter @Setter Integer wordsPageSize;
        private @Getter @Setter Integer quizPageSize;
        private @Getter @Setter Integer testLimitWordsPageCount;
        private @Getter @Setter Integer quizStartWordsCount;
    }

    public static class Messages {
        private @Getter @Setter String startLearning;
        private @Getter @Setter String stopLearning;
        private @Getter @Setter String resumeLearning;
        private @Getter @Setter String learningAlreadyStarted;
        private @Getter @Setter String allWordsLearned;
        private @Getter @Setter String fullAccessAlreadyPurchased;
        private @Getter @Setter String settings;
        private @Getter @Setter String unknownCommand;
        private @Getter @Setter String info;
        private @Getter @Setter String commands;
        private @Getter @Setter String support;
        private @Getter @Setter String donate;
        private @Getter @Setter String successFullAccessPayment;
        private @Getter @Setter String successDonatePayment;
        private @Getter @Setter String wordsFullAccess;
        private @Getter @Setter String testPeriodOver;
    }

    public static class Payment {
        private @Getter @Setter String providerToken;

        private @Getter @Setter FullAccessPayment fullAccess;
        private @Getter @Setter DonatePayment donate;
    }

    public static class FullAccessPayment {
        private @Getter @Setter String title;
        private @Getter @Setter String description;
        private @Getter @Setter String currency;
        private @Getter @Setter Integer amount;
    }

    public static class DonatePayment {
        private @Getter @Setter String title;
        private @Getter @Setter String description;
        private @Getter @Setter String currency;
        private @Getter @Setter List<Integer> amounts;
    }
}
