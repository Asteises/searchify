package ru.asteises.searchify.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class BotButtons {

    private static ReplyKeyboardMarkup main;

    static {
        main = new ReplyKeyboardMarkup();
        main.setSelective(true);
        main.setResizeKeyboard(true);
        main.setOneTimeKeyboard(false);
    }

    public static ReplyKeyboardMarkup getMainButtons() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add("Зарегистрироваться");
        KeyboardRow row2 = new KeyboardRow();
        row2.add("Найти новости");
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        keyboardRows.add(row1);
        keyboardRows.add(row2);
        main.setKeyboard(keyboardRows);
        return main;
    }
}
