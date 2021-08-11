package ru.telegram.learn.english.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@EnableJdbcRepositories
@EnableTransactionManagement
@SpringBootApplication
public class LearnEnglishWordsBotApplication {

    private static final Logger LOG = LoggerFactory.getLogger(LearnEnglishWordsBotApplication.class);

    public LearnEnglishWordsBotApplication(LearnEnglishWordsBot bot) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            LOG.error(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(LearnEnglishWordsBotApplication.class, args);
    }
}
