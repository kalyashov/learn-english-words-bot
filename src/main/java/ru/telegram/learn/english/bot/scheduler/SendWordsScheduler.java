package ru.telegram.learn.english.bot.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.telegram.learn.english.bot.LearnEnglishWordsBot;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.entity.UserEntity;
import ru.telegram.learn.english.bot.entity.UserLearningStatus;
import ru.telegram.learn.english.bot.service.command.builder.SendWordsMessageActionBuilder;
import ru.telegram.learn.english.bot.service.user.UserService;

import java.util.List;

@Component
public class SendWordsScheduler {

    private static final String CRON = "0 */9 * * * *";
    private final UserService userService;
    private final SendWordsMessageActionBuilder actionBuilder;
    private final LearnEnglishWordsBot bot;

    public SendWordsScheduler(UserService userService, SendWordsMessageActionBuilder actionBuilder, LearnEnglishWordsBot bot) {
        this.userService = userService;
        this.actionBuilder = actionBuilder;
        this.bot = bot;
    }

    @Scheduled(cron = CRON)
    public void sendWords() {
        List<UserEntity> users = userService.getUsers();
        for(UserEntity user: users) {
            if (user.getLearningProcess().getLearningStatus() == UserLearningStatus.ACTIVE) {
                CommandActions actions = actionBuilder.build(user.getChatId(), Long.valueOf(user.getId()));
                bot.processActions(actions.getActions());
            }
        }
    }

}
