package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;



import java.util.List;
import java.util.Map;

import static helpers.Attach.*;

public class TestBase {

    @BeforeAll // выполняет настройки которые в ней заданы ПЕРЕД ВСЕМИ тестами один раз
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager"; //стратегия загрузки, не дожидаемся полной загрузки
        Configuration.baseUrl = "https://www.mvideo.ru/"; // выносим основной сайт
        Configuration.holdBrowserOpen = false;
        Configuration.browserCapabilities.setCapability("goog:chromeOptions", Map.of(
                "args", List.of(
                        "--disable-blink-features=AutomationControlled",
                        "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36"
                )
        ));

    }

    @BeforeEach //метод выполняется перед каждым тестом
    void setUpBeforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()); //включение слушателя Аллюр

    }
    @AfterEach
        //выполняется после каждого теста
    void addAttachments() {
        Attach.screenshotAs("Last screenshot"); //Скриншот последнего состояния браузера.
        Attach.pageSource(); //Исходный код страницы.
        Attach.browserConsoleLogs(); //Логи консоли браузера.
        Attach.addVideo(); //Видео записи теста.
        Selenide.closeWebDriver(); //Закрывает браузер.
    }
}

