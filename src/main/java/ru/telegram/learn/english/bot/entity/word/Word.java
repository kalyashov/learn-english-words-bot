package ru.telegram.learn.english.bot.entity.word;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import ru.telegram.learn.english.bot.entity.BaseEntity;

@Table("english_words")
public class Word extends BaseEntity {
    @Column
    private @Getter @Setter String word;
    @Column
    private @Getter @Setter String translation;
    @Column
    private @Getter @Setter String level;
    @Column
    private @Getter @Setter String partOfSpeech;
    @Column
    private @Getter @Setter String emoji;
    @Column
    private @Getter @Setter WordAudioData audio;

    public Word(String id, String word, String translation, String level, String partOfSpeech,
                String emoji, WordAudioData audio) {
        super(id, true);
        this.word = word;
        this.translation = translation;
        this.level = level;
        this.partOfSpeech = partOfSpeech;
        this.emoji = emoji;
        this.audio = audio;
    }

    @Override
    public String toString() {
        return  word + " - " + translation;
    }
}
