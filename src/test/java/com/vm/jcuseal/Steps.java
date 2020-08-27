package com.vm.jcuseal;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Link;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Steps {

    private WebDriver driver;

    @Before
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverRunner.setWebDriver(driver);

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false)
        );
    }

    @After
    public void tearDown() {
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
        boolean exists = $(By.xpath("//b[contains(text(),'" + text + "')]")).exists();
        Assert.assertTrue("огурцов нет", exists);
    }

    @Тогда("происходит скриншот")
    public void происходитСкриншот() {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screen attachment", new ByteArrayInputStream(screenshot));
    }

    @И("происходит прикрепление ссылки")
    @Link(name = "myLink", url = "https://github.com/vmeduc")
    public void происходитПрикреплениеСсылки() {
    }

}
