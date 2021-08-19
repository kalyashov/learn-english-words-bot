package ru.telegram.learn.english.bot.entity.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import ru.telegram.learn.english.bot.entity.UserSettings;


@WritingConverter
public class UserSettingWritingConverter implements Converter<UserSettings, PGobject> {

    private final ObjectMapper objectMapper;

    public UserSettingWritingConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public PGobject convert(UserSettings source) {
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