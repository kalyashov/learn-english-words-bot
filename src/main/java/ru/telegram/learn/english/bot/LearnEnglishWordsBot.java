package ru.telegram.learn.english.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendInvoice;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.learn.english.bot.business.action.BotAction;
import ru.telegram.learn.english.bot.config.BotConfig;
import ru.telegram.learn.english.bot.processor.UpdateProcessor;
import ru.telegram.learn.english.bot.util.UpdateUtil;

import java.util.List;

@Service
public class LearnEnglishWordsBot extends TelegramLongPollingBot {

    private final Logger LOG = LoggerFactory.getLogger(LearnEnglishWordsBot.class);

    private final UpdateProcessor updateProcessor;
    private final BotConfig botConfig;

    public LearnEnglishWordsBot(UpdateProcessor updateProcessor, BotConfig botConfig) {
        this.updateProcessor = updateProcessor;
        this.botConfig = botConfig;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBot().getName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getBot().getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        LOG.info(update.toString());
        if (UpdateUtil.checkUpdate(update)) {
            processActions(updateProcessor.process(update).getActions());
        }
    }

    public void processActions(List<BotAction<?>> actions) {
        try {
            for(BotAction<?> action: actions) {
                LOG.info(action.toString());
                switch (action.getActionType()) {
                    case SEND_MESSAGE:
                        execute((SendMessage) action.getAction());
                        break;
                    case SEND_AUDIO:
                        execute((SendAudio) action.getAction());
                        break;
                    case SEND_STICKER:
                        execute((SendSticker) action.getAction());
                        break;
                    case SEND_INVOICE:
                        execute((SendInvoice) action.getAction());
                        break;
                    case SEND_POLL:
                        execute((SendPoll) action.getAction());
                        break;
                    case EDIT_MESSAGE_REPLY_MARKUP:
                        execute((EditMessageReplyMarkup) action.getAction());
                        break;
                    case NONE:
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
