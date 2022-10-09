package ru.asteises.parser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parse {

    private WebDriver webDriver;
    private final String url = "https://dzen.ru/news?issue_tld=ru";

    // mg-card__title - название класса по которому ищем

    public void execute() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
}
