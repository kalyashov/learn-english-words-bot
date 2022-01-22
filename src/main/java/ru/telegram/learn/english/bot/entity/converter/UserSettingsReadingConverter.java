package ru.telegram.learn.english.bot.entity.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import ru.telegram.learn.english.bot.entity.user.UserSettings;

@ReadingConverter
@RequiredArgsConstructor
public class UserSettingsReadingConverter implements Converter<PGobject, UserSettings> {

    private final ObjectMapper objectMapper;

    @Override
    public UserSettings convert(PGobject pgObject) {
        try {
            val source = pgObject.getValue();
            return objectMapper.readValue(source, UserSettings.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
