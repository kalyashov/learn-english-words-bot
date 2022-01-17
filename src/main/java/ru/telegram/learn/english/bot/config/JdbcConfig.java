package ru.telegram.learn.english.bot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import ru.telegram.learn.english.bot.entity.converter.*;

import java.util.Arrays;

@Configuration
public class JdbcConfig extends AbstractJdbcConfiguration {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @Bean
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(Arrays.asList(
                new UserLearningProcessWritingConverter(objectMapper),
                new UserLearningProcessReadingConverter(objectMapper),
                new UserSettingWritingConverter(objectMapper),
                new UserSettingsReadingConverter(objectMapper),
                new WordAudioWritingConverter(objectMapper),
                new WordAudioReadingConverter(objectMapper),
                new PaymentMetaDataWritingConverter(objectMapper),
                new PaymentMetaDataReadingConverter(objectMapper)
        ));
    }
}