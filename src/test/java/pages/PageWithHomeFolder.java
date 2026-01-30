package pages;


import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import io.qameta.allure.Step;
import org.openqa.selenium.devtools.v85.page.Page;

import static com.codeborne.selenide.Selenide.*;

public class PageWithHomeFolder {

    private final SelenideElement
            closeBanner = $(".insider-banner-close-button.mv-icon-button--small.mv-icon-button--transparent.mv-icon-button--none.mv-button.mv-icon-button"), // закрыть рекламный баннер
            cookieHome = $(".notification__button.mv-main-button--large.mv-main-button--primary.mv-button.mv-main-button"), // закрыть куки
            selectCity = $(".location-deny.link.link--blue"), // Выбрать другой город
            firstAppHeader = $(".app-header-top.app-header-columns"), // Первый заголовок
            secondAppHeader = $(".app-header-bottom.app-header-columns"), // Второй заголовок
            openDirectory = $(".catalog-button.mv-main-button--large.mv-main-button--primary.mv-button.mv-main-button"), // Открытие контейнера с каталогом
            gridContainer = $(".left-menu"), // раскрывшийся контейнер с каталогом
            closeDirectory = $(".catalog-button.mv-main-button--large.mv-main-button--primary.mv-button.mv-main-button"), // Закрытие контейнера с каталогом
            shoppingCart = $(".nav-tab.tab-cart"), // Значок корзины
            checkShoppingCart = $(".cart-empty__title"), // Проверка корзины после перехода в нее
            checkAuthorization = $(".cart-empty__button.cart-empty__button_fixed-width"), // Проверка кнопки авторизироваться
            checkAuthorizationButton = $(".mv-main-button--large.mv-main-button--primary.mv-button.mv-main-button"),
            checkAuthorizationButtons = $(".mv-main-button--large.mv-main-button--primary.mv-button.mv"),
            checkIkonAuthorization = $(".login-form.ng-untouched.ng-pristine.ng-valid"),
            closeAuthorization = $(".login-form-top-nav__btn-icon"); // Кнопка закрытия авторизации
    private final ElementsCollection
            selectCityEkaterinburg = $$(".location-select__location"), // Выбрать город Екатеринбург
            leftMenuItem = $$(".left-menu__item-text");


    @Step("Открыть главную страницу")
    public PageWithHomeFolder openPage() {
        open("https://www.mvideo.ru/");
        return this;
    }

    @Step("Закрыть рекламный баннер")
    public PageWithHomeFolder closeBanner() {
        closeBanner.click();
        return this;
    }

    @Step("Принять cookie")
    public PageWithHomeFolder cookieHome() {
        cookieHome.click();
        return this;
    }

    @Step("Выбрать другой город")
    public PageWithHomeFolder selectCity() {
        selectCity.click();
        return this;
    }

    @Step("Выбрать город Екатеринбург")
    public PageWithHomeFolder selectCityEkaterinburg() {
        selectCityEkaterinburg.findBy(text("Екатеринбург")).shouldBe(visible).click();
        Selenide.sleep(3000);
        return this;
    }

    @Step("Проверка первого заголовка: {value}")
    public PageWithHomeFolder firstAppHeader(String value) {
        firstAppHeader.shouldBe(visible).shouldHave(text(value));
        return this;
    }

    @Step("Проверка второго заголовка: {value}")
    public PageWithHomeFolder secondAppHeader(String value) {
        secondAppHeader.shouldBe(visible).shouldHave(text(value));
        return this;
    }

    @Step("Открытие контейнера с каталогом")
    public PageWithHomeFolder openDirectory() {
        openDirectory.click();
        Selenide.sleep(3000);
        return this;
    }

    @Step("Выбор католога Акции")
    public PageWithHomeFolder leftMenuItem() {
        leftMenuItem.findBy(text("Акции, скидки и распродажи")).shouldHave(text("Акции, скидки и распродажи")).hover();
        return this;
    }

    @Step("Проверка контейнера с каталогом")
    public PageWithHomeFolder gridContainer(String value) {
        gridContainer.shouldBe(visible).shouldHave(text(value));
        return this;
    }

    @Step("Закрытие контейнера с каталогом")
    public PageWithHomeFolder closeDirectory() {
        closeDirectory.click();
        Selenide.sleep(3000);
        return this;
    }

    @Step ("Нажать на значок Корзины")
    public PageWithHomeFolder shoppingCart(){
        shoppingCart.click();
        return this;
    }
    @Step ("Проверка пустой корзины {value}")
    public PageWithHomeFolder checkShoppingCart(String value){
        checkShoppingCart.shouldBe(visible).shouldHave(text(value));
        return this;
    }
    @Step ("Проверка кнопки авторизоваться {value}")
    public PageWithHomeFolder checkAuthorization(String value){
        checkAuthorization.shouldBe(visible).shouldHave(text(value));
        return this;
    }
    @Step ("Нажатие кнопки авторизоваться")
    public PageWithHomeFolder checkAuthorizationButton (){
        checkAuthorizationButton.shouldBe(visible).click();
        Selenide.sleep(3000);
        return this;
    }
    @Step ("Проверка окна авторизации {value}")
    public PageWithHomeFolder checkIkonAuthorization(String value){
        checkIkonAuthorization.shouldHave(visible).shouldHave(text(value));
        return this;
    }
    @Step ("Закрытие окна авторизации")
    public PageWithHomeFolder closeAuthorization(){
        closeAuthorization.click();
        Selenide.sleep(3000);
        return this;
    }
}

