package com.vm.jcuseal;

import com.codeborne.selenide.Condition;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.ru.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.StackTrace;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {

    private WebDriver driver;

    @Before
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

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
        driver.get("https://yandex.ru");
    }

    @Когда("пользователь вводит запрос {string}")
    public void пользовательВводитЗапрос(String query) {
        driver.findElement(By.id("text")).sendKeys(query);
    }

    @И("нажимает Найти")
    public void нажимаетНайти() {
        driver.findElement(By.xpath("//button")).click();
    }

    @Тогда("на странице есть {string}")
    public void наСтраницеЕсть(String text) {
        try {
            driver.findElement(By.xpath("//div[text()='огурецы']"));
        } catch (Throwable e) {
            Assert.assertTrue(" Текст \"" + text + "\" не найден: " + e.getMessage(), false);
            e.printStackTrace();
        }
    }
}
