package ru.asteises.searchify.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.asteises.searchify.bot.Bot;
import ru.asteises.searchify.core.service.TUserService;

@Configuration
public class TelegramBotConfiguration {

    @Bean
    public Bot telegramBot(@Value("${bot.name}") String  name,
                           @Value("${bot.token}") String token,
                           TUserService tUserService) {
        return new Bot(name, token, tUserService);
    }

    @Bean
    public TelegramBotsApi telegramBotsApi(Bot bot) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
        return telegramBotsApi;
    }
}
