package ru.telegram.learn.english.bot.service.command.builder;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import ru.telegram.learn.english.bot.business.action.CommandActions;
import ru.telegram.learn.english.bot.business.action.SendPollAction;
import ru.telegram.learn.english.bot.config.BotConfig;
import ru.telegram.learn.english.bot.entity.UserEntity;
import ru.telegram.learn.english.bot.entity.Word;
import ru.telegram.learn.english.bot.service.user.UserService;
import ru.telegram.learn.english.bot.service.word.WordService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SendWordsQuizMessageBuilder {

    private final UserService userService;
    private final WordService wordService;
    private final BotConfig botConfig;
    private final int QUIZ_WORDS_COUND = 5;

    public SendWordsQuizMessageBuilder(UserService userService, WordService wordService, BotConfig botConfig) {
        this.userService = userService;
        this.wordService = wordService;
        this.botConfig = botConfig;
    }

    public CommandActions build(String chatId, Long userId) {
        CommandActions commandActions = new CommandActions();
        UserEntity userEntity = userService.getById(userId);
        List<String> viewedWordsIds = new ArrayList<>(userEntity.getLearningProcess().getViewedWordIds());
        Collections.shuffle(viewedWordsIds);

        List<String> wordsIdsForQuiz = viewedWordsIds
                .stream()
                .limit(QUIZ_WORDS_COUND)
                .collect(Collectors.toList());

        List<Word> wordsForQuiz = wordService.getWordsByIds(wordsIdsForQuiz);

        Random r = new Random();
        for (Word word: wordsForQuiz) {
            int correctAnswerId = r.nextInt(4);

            LinkedList<String> quizAnswers = wordService.getRandomWords(3)
                    .stream().map(Word::getTranslation).collect(Collectors.toCollection(LinkedList::new));

            quizAnswers.add(correctAnswerId, word.getTranslation());

            commandActions.add(buildPollAction(chatId, word.getWord(), quizAnswers, correctAnswerId));
        }

        return commandActions;
    }

    public SendPollAction buildPollAction(String chatId, String word,
                                          List<String> quizAnswers,
                                          Integer correctAnswerId) {
        SendPoll sendPoll = new SendPoll();
        sendPoll.setChatId(chatId);
        sendPoll.setQuestion("Выбери перевод слова " + word);
        sendPoll.setOptions(quizAnswers);
        sendPoll.setCorrectOptionId(correctAnswerId);
        sendPoll.setType("quiz");
        return new SendPollAction(sendPoll);
    }
}
