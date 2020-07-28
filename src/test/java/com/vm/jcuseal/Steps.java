package com.vm.jcuseal;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import utils.LkUtils;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Steps {

    @Дано("today is Sunday")
    public void today_is_sunday() {
        assertTrue(true);
    }

    @Когда("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_friday_yet() {
        assertTrue(true);
    }

    @Тогда("I should be told {string}")
    public void i_should_be_told(String string) {
        System.out.println("Hello World!");
        assertTrue(true);
    }

    @Дано("открыта страница авторизации")
    public void открытаСтраницаАвторизации() {
        LkUtils.openMain();
    }

    @Когда("пользователь вводит логин {string}")
    public void пользовательВводитЛогин(String login) {
        $(By.id("username")).setValue(login);
    }

    @И("пользователь вводит пароль {string}")
    public void пользовательВводитПароль(String password) {
        $(By.id("password")).setValue(password);
    }

    @И("пользователь нажимает {string}")
    public void пользовательНажимает(String text) {
        $(By.xpath("//button[text()='" + text + "']")).click();
    }
}
