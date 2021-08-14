package ru.telegram.learn.english.bot.entity;

import java.util.Set;

public class UserLearningProcess {

    private UserLearningStatus learningStatus;
    private Set<String> viewedWordIds;

    public UserLearningProcess() {}

    public UserLearningProcess(UserLearningStatus learningStatus, Set<String> viewedWordIds) {
        this.learningStatus = learningStatus;
        this.viewedWordIds = viewedWordIds;
    }

    public UserLearningStatus getLearningStatus() {
        return learningStatus;
    }

    public void setLearningStatus(UserLearningStatus learningStatus) {
        this.learningStatus = learningStatus;
    }

    public Set<String> getViewedWordIds() {
        return viewedWordIds;
    }

    public void setViewedWordIds(Set<String> viewedWordIds) {
        this.viewedWordIds = viewedWordIds;
    }

    public void addViewedWordIds(Set<String> newViewedWordIds) {
        this.viewedWordIds.addAll(newViewedWordIds);
    }
}
