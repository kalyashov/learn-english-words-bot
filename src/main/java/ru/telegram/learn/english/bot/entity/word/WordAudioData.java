package ru.telegram.learn.english.bot.entity.word;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Данные аудио с произношением слова
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WordAudioData {
    private String audioFileNameUK;
    private String audioFileNameUS;
    private String audioLinkUK;
    private String audioLinkUS;
}
