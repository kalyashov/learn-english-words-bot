package ru.telegram.learn.english.bot.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("users")
public class UserEntity extends BaseEntity {
    @Column
    private String chatId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String userName;
    @Column
    private UserLearningProcess learningProcess;
    @Column
    private UserSettings userSettings;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;

    public static UserEntity createNewUser(
                                String id,
                                String chatId,
                                String firstName,
                                String lastName,
                                String userName,
                                UserLearningProcess learningProcess) {
        UserEntity userEntity = new UserEntity(id,
                chatId,
                firstName,
                lastName,
                userName,
                learningProcess,
                UserSettings.defaultSettings(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        userEntity.setIsNew(true);

        return userEntity;
    }

    public UserEntity(String id, String chatId, String firstName, String lastName, String userName,
                      UserLearningProcess learningProcess, UserSettings userSettings,
                      LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, false);
        this.chatId = chatId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.learningProcess = learningProcess;
        this.userSettings = userSettings;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserLearningProcess getLearningProcess() {
        return learningProcess;
    }

    public UserSettings getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(UserSettings userSettings) {
        this.userSettings = userSettings;
    }

    public void setLearningProcess(UserLearningProcess learningStatus) {
        this.learningProcess = learningStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
