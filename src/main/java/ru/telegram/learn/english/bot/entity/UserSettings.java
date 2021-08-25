package ru.telegram.learn.english.bot.entity;

public class UserSettings {
    private WordsViewType wordsViewType;
    private AudioType audioType;
    private AccessType accessType;

    public UserSettings() {
    }

    public UserSettings(WordsViewType wordsViewType, AudioType audioType, AccessType accessType) {
        this.wordsViewType = wordsViewType;
        this.audioType = audioType;
        this.accessType = accessType;
    }

    public WordsViewType getWordsViewType() {
        return wordsViewType;
    }

    public void setWordsViewType(WordsViewType wordsViewType) {
        this.wordsViewType = wordsViewType;
    }

    public AudioType getAudioType() {
        return audioType;
    }

    public void setAudioType(AudioType audioType) {
        this.audioType = audioType;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public static UserSettings defaultSettings() {
        return new UserSettings(
                WordsViewType.WORDS_AND_AUDIO,
                AudioType.UK,
                AccessType.STANDART);
    }
}
