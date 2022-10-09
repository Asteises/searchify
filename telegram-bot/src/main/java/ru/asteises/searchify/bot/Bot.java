package ru.asteises.searchify.bot;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.asteises.searchify.commands.CommandStorage;
import ru.asteises.searchify.commands.StartCommand;
import ru.asteises.searchify.core.service.TUserService;

@Slf4j
public class Bot extends TelegramLongPollingCommandBot {

    private final String BOT_NAME;
    private final String BOT_TOKEN;

    private final CommandStorage commandStorage;
    private final TUserService tUserService;

    public Bot(String botName, String botToken, TUserService tUserService) {
        super();
        this.BOT_NAME = botName;
        this.BOT_TOKEN = botToken;
        this.tUserService = tUserService;
        this.commandStorage = new CommandStorage(tUserService);

        register(new StartCommand("start", "старт"));
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                SendMessage sendMessage = commandStorage.getCommands().get(update.getMessage().getText()).execute(update);
                execute(sendMessage);
            }

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
