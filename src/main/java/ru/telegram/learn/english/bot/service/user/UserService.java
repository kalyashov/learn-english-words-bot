package ru.telegram.learn.english.bot.service.user;

import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.User;
import ru.telegram.learn.english.bot.entity.UserEntity;
import ru.telegram.learn.english.bot.entity.UserLearningProcess;
import ru.telegram.learn.english.bot.entity.UserLearningStatus;
import ru.telegram.learn.english.bot.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.stream.*;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getUsers() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public UserEntity getById(Long id) {
        return userRepository.findById(id.toString()).orElse(null);
    }

    public UserEntity startLearnProcess(User user, String chatId) {

        UserLearningProcess learningProcess =
                new UserLearningProcess(UserLearningStatus.ACTIVE, Sets.newHashSet());

        UserEntity userEntity = UserEntity.createNewUser(
                user.getId().toString(),
                chatId,
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                learningProcess
        );

        userRepository.save(userEntity);

        return userEntity;
    }

    public UserEntity restartLearnProcess(UserEntity userEntity) {
        userEntity.getLearningProcess().setLearningStatus(UserLearningStatus.ACTIVE);
        userEntity.getLearningProcess().setViewedWordIds(new HashSet<>());
        userRepository.save(userEntity);

        return userEntity;
    }


    public UserEntity continueLearnProcess(UserEntity userEntity) {
        userEntity.getLearningProcess().setLearningStatus(UserLearningStatus.ACTIVE);
        userRepository.save(userEntity);

        return userEntity;
    }

    public void stopLearnByUser(org.telegram.telegrambots.meta.api.objects.User user) {
        UserEntity userEntity = userRepository.findById(user.getId().toString()).orElse(null);

        if (userEntity != null) {
            userEntity.getLearningProcess().setLearningStatus(UserLearningStatus.PAUSED);
            userEntity.setUpdatedAt(LocalDateTime.now());
            userRepository.save(userEntity);
        }
    }

    public void finishLearnByUser(UserEntity userEntity) {
        userEntity.getLearningProcess().setLearningStatus(UserLearningStatus.FINISHED);
        userEntity.setUpdatedAt(LocalDateTime.now());
        userRepository.save(userEntity);
    }

    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}
