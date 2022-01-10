package ru.telegram.learn.english.bot.service.word;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;
import ru.telegram.learn.english.bot.entity.UserEntity;
import ru.telegram.learn.english.bot.entity.UserLearningProcess;
import ru.telegram.learn.english.bot.entity.Word;
import ru.telegram.learn.english.bot.repository.WordRepository;
import ru.telegram.learn.english.bot.service.user.UserService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WordService {

    private final WordRepository wordRepository;
    private final UserService userService;

    public WordService(WordRepository wordRepository, UserService userService) {
        this.wordRepository = wordRepository;
        this.userService = userService;
    }

    public List<Word> getWords(UserEntity userEntity, Integer wordsPageSize) {
        UserLearningProcess learningProcess = userEntity.getLearningProcess();
        List<String> wordIds = Lists.newArrayList(
                        CollectionUtils.subtract(wordRepository.getAllWordIds(), learningProcess.getViewedWordIds()));
        Collections.shuffle(wordIds);

        List<String> preparedWordIds = wordIds.stream().limit(wordsPageSize).collect(Collectors.toList());

        learningProcess.addViewedWordIds(Sets.newHashSet(preparedWordIds));
        userEntity.setLearningProcess(learningProcess);

        userService.saveUser(userEntity);

        return Lists.newArrayList(wordRepository.findAllById(preparedWordIds));
    }

    public List<Word> getWordsByIds(List<String> wordIds) {
        return IterableUtils.toList(wordRepository.findAllById(wordIds));
    }

    public List<Word> getRandomWords(int wordsCount) {
        List<String> randomWordIds = new ArrayList<>();
        Integer maxWordId = wordRepository.getMaxWordId();
        Random r = new Random();

        for (int i = 0; i < wordsCount; i++) {
            int randomWordId = r.nextInt(maxWordId - 1) + 1;
            randomWordIds.add(String.valueOf(randomWordId));
        }

        return getWordsByIds(randomWordIds);
    }
}
