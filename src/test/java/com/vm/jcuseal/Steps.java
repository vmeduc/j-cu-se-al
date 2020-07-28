package com.vm.jcuseal;

import io.cucumber.java.ru.*;
import org.openqa.selenium.*;
import com.vm.jcuseal.utils.LkUtils;

import static com.codeborne.selenide.Selenide.$;

public class Steps {

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
