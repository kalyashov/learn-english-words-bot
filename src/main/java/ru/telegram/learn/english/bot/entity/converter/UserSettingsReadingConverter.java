package ru.telegram.learn.english.bot.entity.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import ru.telegram.learn.english.bot.entity.UserSettings;

@ReadingConverter
public class UserSettingsReadingConverter implements Converter<PGobject, UserSettings> {

    private ObjectMapper objectMapper;

    public UserSettingsReadingConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public UserSettings convert(PGobject pgObject) {
        try {
            String source = pgObject.getValue();
            return objectMapper.readValue(source, UserSettings.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
