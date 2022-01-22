package ru.telegram.learn.english.bot.entity.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import ru.telegram.learn.english.bot.entity.user.UserLearningProcess;

@WritingConverter
@RequiredArgsConstructor
public class UserLearningProcessWritingConverter implements Converter<UserLearningProcess, PGobject> {

    private final ObjectMapper objectMapper;

    @Override
    public PGobject convert(UserLearningProcess source) {
        try {
            val jsonObject = new PGobject();
            jsonObject.setType("json");
            jsonObject.setValue(objectMapper.writeValueAsString(source));
            return jsonObject;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}