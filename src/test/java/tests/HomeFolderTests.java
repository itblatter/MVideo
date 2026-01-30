package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;


@Tag("checking")
public class HomeFolderTests extends TestBase {

    PageWithHomeFolder pageWithHomeFolder = new PageWithHomeFolder();
    @Test
    @DisplayName("Проверка главной страницы")
    @Tag("smoke")
    @Owner("Daniil Ruban")
    void homeFolderTest() {
        pageWithHomeFolder.openPage() // Открыть сайт MVideo
                .closeBanner() // Закрыть
                .cookieHome() // Принять cookie

                .selectCity() // Выбрать другой город
                .selectCityEkaterinburg() // Выбрать город Екатеринбург

                .firstAppHeader("Екатеринбург")
                .firstAppHeader("Магазины")
                .firstAppHeader("Установка и ремонт")
                .firstAppHeader("Мобильное приложение")
                .firstAppHeader("М.Комбо")
                .firstAppHeader("М.Клик")
                .firstAppHeader("Войти в ЛК продавца")
                .firstAppHeader("Стать продавцом")

                .secondAppHeader("ВСЕ АКЦИИ")
                .secondAppHeader("Дерзкая распродажа")
                .secondAppHeader("СМАРТФОНЫ")
                .secondAppHeader("ТЕЛЕВИЗОРЫ")
                .secondAppHeader("УМНЫЙ ДОМ")
                .secondAppHeader("НОУТБУКИ")
                .secondAppHeader("СТИРАЛЬНЫЕ МАШИНЫ")

                .openDirectory() // Открыть каталог
                .leftMenuItem() // Проверяем что каталог открылся
                .gridContainer("Акции, скидки и распродажи")
                .gridContainer("Смартфоны и гаджеты")
                .gridContainer("Ноутбуки и компьютеры")
                .gridContainer("Аудиотехника")
                .gridContainer("Техника для кухни")
                .closeDirectory(); // Закрыть каталог
    }


    @Test
    @DisplayName("Переход в корзину и проверка авторизации")
    @Tag("smoke")
    @Owner("Daniil Ruban")
    void homeFolderTesting() {
        pageWithHomeFolder.openPage()
                .shoppingCart()
                .checkShoppingCart("Корзина пуста")
                .checkAuthorization("Авторизоваться")
                .checkAuthorizationButton()
                .checkIkonAuthorization("Вход или регистрация")
                .closeAuthorization();

    }

    @Test
    @DisplayName("Негативный: Кнопка авторизации не доступна")
    @Tag("smoke")
    @Owner("Daniil Ruban")
    void homeFolderTestingNegative(){
        pageWithHomeFolder.openPage()
                .shoppingCart()
                .checkShoppingCart("Корзина пуста")
                .checkAuthorization("Авторизоваться")
                .checkAuthorizationButton()
                .checkIkonAuthorization("Вход или регистрация")
                .closeAuthorization();
    }

}


