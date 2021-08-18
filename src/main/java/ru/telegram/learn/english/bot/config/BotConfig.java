package ru.telegram.learn.english.bot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import ru.telegram.learn.english.bot.business.bot.StickerId;

import java.util.HashMap;

@ConstructorBinding
@ConfigurationProperties(prefix = "learn-english-words-bot")
public class BotConfig {

    private Bot bot;
    private Messages messages;
    private HashMap<StickerId, String> stickers;

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    public HashMap<StickerId, String> getStickers() {
        return stickers;
    }

    public void setStickers(HashMap<StickerId, String> stickers) {
        this.stickers = stickers;
    }

    public static class Bot {
        private String name;
        private String token;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    public static class Messages {
        private String startLearning;
        private String stopLearning;
        private String resumeLearning;
        private String learningAlreadyStarted;
        private String unknownCommand;
        private String info;
        private String commands;
        private String support;
        private String donate;

        public String getStartLearning() {
            return startLearning;
        }

        public void setStartLearning(String startLearning) {
            this.startLearning = startLearning;
        }

        public String getStopLearning() {
            return stopLearning;
        }

        public void setStopLearning(String stopLearning) {
            this.stopLearning = stopLearning;
        }

        public String getResumeLearning() {
            return resumeLearning;
        }

        public void setResumeLearning(String resumeLearning) {
            this.resumeLearning = resumeLearning;
        }

        public String getLearningAlreadyStarted() {
            return learningAlreadyStarted;
        }

        public void setLearningAlreadyStarted(String learningAlreadyStarted) {
            this.learningAlreadyStarted = learningAlreadyStarted;
        }

        public String getUnknownCommand() {
            return unknownCommand;
        }

        public void setUnknownCommand(String unknownCommand) {
            this.unknownCommand = unknownCommand;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getCommands() {
            return commands;
        }

        public void setCommands(String commands) {
            this.commands = commands;
        }

        public String getSupport() {
            return support;
        }

        public void setSupport(String support) {
            this.support = support;
        }

        public String getDonate() {
            return donate;
        }

        public void setDonate(String donate) {
            this.donate = donate;
        }
    }
}
