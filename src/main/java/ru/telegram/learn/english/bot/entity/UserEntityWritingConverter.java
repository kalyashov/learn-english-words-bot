package ru.telegram.learn.english.bot.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;


@WritingConverter
public class UserEntityWritingConverter implements Converter<UserLearningProcess, PGobject> {

    private ObjectMapper objectMapper;

    public UserEntityWritingConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public PGobject convert(UserLearningProcess source) {
        try {
            PGobject jsonObject = new PGobject();
            jsonObject.setType("json");
            jsonObject.setValue(objectMapper.writeValueAsString(source));
            return jsonObject;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}