package ru.asteises.searchify.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotCommands {

    SendMessage execute(Update update);
}
