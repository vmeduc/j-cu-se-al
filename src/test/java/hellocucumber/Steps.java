package hellocucumber;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

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

}
