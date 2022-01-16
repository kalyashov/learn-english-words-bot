package ru.telegram.learn.english.bot.business.action;

/**
 * Тип действия
 */
public enum BotActionType {

    /**
     * Отправка сообщения
     */
    SEND_MESSAGE,

    /**
     * Отправка аудио
     */
    SEND_AUDIO,

    /**
     * Отправка стикера
     */
    SEND_STICKER,

    /**
     * Отправка счета для оплаты
     */
    SEND_INVOICE,

    /**
     * Отправка опроса
     */
    SEND_POLL,

    /**
     * Отредактировать разметку сообщения
     */
    EDIT_MESSAGE_REPLY_MARKUP,

    /**
     * Отправка ответа на подготовку платежа
     */
    SEND_ANSWER_PRE_CHECKOUT,

    /**
     *  Нет действия
     */
    NONE
}
