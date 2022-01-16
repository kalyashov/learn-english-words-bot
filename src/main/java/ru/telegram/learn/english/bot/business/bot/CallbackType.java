package ru.telegram.learn.english.bot.business.bot;

/**
 * Типы callback
 */
public enum CallbackType {
    /**
     * UK произношение
     */
    SET_UK_AUDIO,

    /**
     * US произношение
     */
    SET_US_AUDIO,

    /**
     * Отправка аудио
     */
    GA,

    /**
     * Неизвестный тип
     */
    UNKNOWN;

    public static CallbackType fromValue(String callbackRaw) {
        for (CallbackType callbackType : values()) {
            if (callbackRaw.contains(callbackType.name())) {
                return callbackType;
            }
        }

        return UNKNOWN;
    }
}
