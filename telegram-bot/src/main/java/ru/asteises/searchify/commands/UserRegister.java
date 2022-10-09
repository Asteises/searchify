package ru.asteises.searchify.commands;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.asteises.searchify.bot.BotCommands;
import ru.asteises.searchify.buttons.BotButtons;
import ru.asteises.searchify.core.entity.TUser;
import ru.asteises.searchify.core.service.TUserService;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@RequiredArgsConstructor
public class UserRegister implements BotCommands {

    private final TUserService tUserService;

    @Override
    public SendMessage execute(Update update) {
        TUser user = new TUser();
        user.setId(UUID.nameUUIDFromBytes(update.getMessage().getChatId().toString().getBytes(StandardCharsets.UTF_8)));
        user.setName(update.getMessage().getFrom().getUserName());
        user.setChatId(update.getMessage().getChatId());
        tUserService.createTUser(user);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.enableMarkdown(false);
        sendMessage.setReplyMarkup(BotButtons.getMainButtons());
        sendMessage.setText("Зарегистрироваться");
        return sendMessage;
    }
}
