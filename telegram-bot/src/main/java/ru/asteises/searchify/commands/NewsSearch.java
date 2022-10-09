package ru.asteises.searchify.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.asteises.searchify.bot.BotCommands;
import ru.asteises.searchify.buttons.BotButtons;

public class NewsSearch implements BotCommands {
    @Override
    public SendMessage execute(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.enableMarkdown(false);
        sendMessage.setReplyMarkup(BotButtons.getMainButtons());
        sendMessage.setText("Найти новости");
        return sendMessage;
    }
}
