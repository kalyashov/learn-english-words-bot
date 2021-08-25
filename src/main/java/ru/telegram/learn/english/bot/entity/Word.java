package ru.telegram.learn.english.bot.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("english_words")
public class Word extends BaseEntity {
    @Column
    private String word;
    @Column
    private String translation;
    @Column
    private String level;
    @Column
    private String partOfSpeech;
    @Column
    private String emoji;
    @Column
    private Audio audio;

    public Word(String id, String word, String translation, String level, String partOfSpeech, String emoji, Audio audio) {
        super(id, true);
        this.word = word;
        this.translation = translation;
        this.level = level;
        this.partOfSpeech = partOfSpeech;
        this.emoji = emoji;
        this.audio = audio;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    @Override
    public String toString() {
        return  word + " - " + translation;
    }
}
