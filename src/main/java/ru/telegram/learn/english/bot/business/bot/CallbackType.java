package ru.telegram.learn.english.bot.business.bot;

/**
 * Типы callback
 */
public enum CallbackType {
    SET_UK_AUDIO,
    SET_US_AUDIO,
    GET_FULL_ACCESS,
    GA,
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
