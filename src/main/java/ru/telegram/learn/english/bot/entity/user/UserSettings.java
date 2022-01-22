package ru.telegram.learn.english.bot.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.telegram.learn.english.bot.entity.word.AudioType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSettings {
    private AudioType audioType;

    public static UserSettings defaultSettings() {
        return new UserSettings(AudioType.UK);
    }
}
