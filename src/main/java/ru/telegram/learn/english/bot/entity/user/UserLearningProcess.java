package ru.telegram.learn.english.bot.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLearningProcess {
    private Set<String> viewedWordIds;

    public void addViewedWordIds(Set<String> newViewedWordIds) {
        this.viewedWordIds.addAll(newViewedWordIds);
    }
}
