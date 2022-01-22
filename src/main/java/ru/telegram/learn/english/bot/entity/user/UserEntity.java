package ru.telegram.learn.english.bot.entity.user;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import ru.telegram.learn.english.bot.entity.BaseEntity;

import java.time.LocalDateTime;

@Table("users")
public class UserEntity extends BaseEntity {
    @Column
    private @Getter @Setter String chatId;
    @Column
    private @Getter @Setter String firstName;
    @Column
    private @Getter @Setter String lastName;
    @Column
    private @Getter @Setter String userName;
    @Column
    private @Getter @Setter UserLearningStatus learningStatus;
    @Column
    private @Getter @Setter AccessType accessType;
    @Column
    private @Getter @Setter UserLearningProcess learningProcess;
    @Column
    private @Getter @Setter UserSettings userSettings;
    @Column
    private @Getter @Setter LocalDateTime createdAt;
    @Column
    private @Getter @Setter LocalDateTime updatedAt;

    public static UserEntity createNewUser(
                                String id,
                                String chatId,
                                String firstName,
                                String lastName,
                                String userName) {
        val userEntity = new UserEntity(id,
                chatId,
                firstName,
                lastName,
                userName,
                UserLearningStatus.ACTIVE,
                AccessType.STANDART,
                new UserLearningProcess(Sets.newHashSet()),
                UserSettings.defaultSettings(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        userEntity.setIsNew(true);

        return userEntity;
    }

    public UserEntity(String id, String chatId, String firstName, String lastName, String userName,
                      UserLearningStatus learningStatus, AccessType accessType, UserLearningProcess learningProcess,
                      UserSettings userSettings, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, false);
        this.chatId = chatId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.learningStatus = learningStatus;
        this.accessType = accessType;
        this.learningProcess = learningProcess;
        this.userSettings = userSettings;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
