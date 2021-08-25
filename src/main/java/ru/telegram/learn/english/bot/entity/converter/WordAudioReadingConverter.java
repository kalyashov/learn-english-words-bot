package ru.telegram.learn.english.bot.entity.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import ru.telegram.learn.english.bot.entity.Audio;

@ReadingConverter
public class WordAudioReadingConverter implements Converter<PGobject, Audio> {

    private final ObjectMapper objectMapper;

    public WordAudioReadingConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Audio convert(PGobject pgObject) {
        try {
            String source = pgObject.getValue();
            return objectMapper.readValue(source, Audio.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
