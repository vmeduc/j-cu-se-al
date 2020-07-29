package com.vm.jcuseal;

import com.vm.jcuseal.utils.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.open;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", glue = "com.vm.jcuseal", features = "src/test/resources/features")
@Listeners({AllureListener.class})
public class CucumberTest extends BaseClass {

    private WebDriver driver;

    @Before
    public void setUp() {
        BaseClass baseClass = new BaseClass();
        driver = baseClass.initialize_driver();

        driver.get("https://demo.nopcommerce.com/");
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    public static void  openMain() {
        open("https://yandex.ru/");
    }
}
