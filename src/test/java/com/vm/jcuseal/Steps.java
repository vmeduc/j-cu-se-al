package com.vm.jcuseal;

import com.vm.jcuseal.CucumberTest;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Steps {

    @Дано("открыта главная страница Яндекс")
    public void открытаСтраницаЯндекс() {
        CucumberTest.openMain();
    }

    @Когда("пользователь вводит запрос {string}")
    public void пользовательВводитЗапрос(String query) {
        $(By.id("text")).setValue(query);
    }

    @И("пользователь нажимает Найти")
    public void пользовательНажимает() {
        $(By.xpath("//button[1]")).click();
    }

    @И("пользователь плохо нажимает Найти")
    public void пользовательПлохоНажимаетНайти() {
        $(By.xpath("//button[0]")).click();
    }
}
