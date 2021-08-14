package ru.telegram.learn.english.bot.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.core.convert.converter.Converter;
import org.postgresql.util.PGobject;

@ReadingConverter
public class UserEntityReadingConverter implements Converter<PGobject, UserLearningProcess> {

    private ObjectMapper objectMapper;

    public UserEntityReadingConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public UserLearningProcess convert(PGobject pgObject) {
        try {
            String source = pgObject.getValue();
            return objectMapper.readValue(source, UserLearningProcess.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
