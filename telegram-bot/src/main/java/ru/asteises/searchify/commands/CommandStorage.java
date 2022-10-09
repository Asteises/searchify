package ru.asteises.searchify.commands;

import ru.asteises.searchify.bot.BotCommands;
import ru.asteises.searchify.core.service.TUserService;

import java.util.HashMap;
import java.util.Map;

public class CommandStorage {

    private final Map<String, BotCommands> commands;

    public CommandStorage(TUserService tUserService) {
        this.commands = new HashMap<>();
        commands.put("Зарегистрироваться", new UserRegister(tUserService));
        commands.put("Найти новости", new NewsSearch());
    }

    public Map<String, BotCommands> getCommands() {
        return commands;
    }
}
