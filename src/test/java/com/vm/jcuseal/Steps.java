package com.vm.jcuseal;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class Steps {

    private WebDriver driver;

    public Steps() {

    }

    @Дано("открыта главная страница Яндекс")
    public void открытаГлавнаястраницаЯндекс() {
        open("https://yandex.ru");
    }

    @Когда("пользователь вводит запрос {string}")
    public void пользовательВводитЗапрос(String query) {
        $(By.id("text")).setValue(query);
    }

    @И("нажимает Найти")
    public void нажимаетНайти() {
        $(By.xpath("//button")).click();
    }

    @Тогда("на странице есть {string}")
    public void наСтраницеЕсть(String text) {
        $(By.xpath("//div[@class='entity-search__header']")).shouldHave(Condition.text(text));
    }
}
