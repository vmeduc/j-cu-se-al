package com.vm.jcuseal;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Steps {

    private WebDriver driver;

    @Before
    public void setupClass() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(500, 500));

        WebDriverRunner.setWebDriver(driver);

        System.out.println("Before");
    }

    @BeforeStep
    public void setupTest() {

        System.out.println("Before step");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
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
        boolean exists = $(By.xpath("//b[contains(text(),'cucumber.io')]")).exists();
        Assert.assertTrue("огурцов нет", exists);
    }
}
