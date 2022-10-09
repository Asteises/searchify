package ru.asteises.searchify.commands;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.asteises.searchify.buttons.BotButtons;

@Slf4j
public class StartCommand extends CommandService {

    public StartCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(false); // Выключает ответ html
        sendMessage.setChatId(chat.getId());
        sendMessage.setText("Hello");
        sendMessage.setReplyMarkup(BotButtons.getMainButtons());
        try {
            absSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.debug("Cant send message with parameters chatId {}, userName {}", chat.getId(), user.getUserName());
            throw new RuntimeException(e);
        }
    }
}
