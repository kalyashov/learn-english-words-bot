package ru.telegram.learn.english.bot.entity.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import ru.telegram.learn.english.bot.entity.payment.PaymentMetaData;

@ReadingConverter
@RequiredArgsConstructor
public class PaymentMetaDataReadingConverter implements Converter<PGobject, PaymentMetaData> {

    private final ObjectMapper objectMapper;

    @Override
    public PaymentMetaData convert(PGobject pgObject) {
        try {
            val source = pgObject.getValue();
            return objectMapper.readValue(source, PaymentMetaData.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
