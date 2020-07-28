package utils;


import static com.codeborne.selenide.Selenide.open;

public class LkUtils {

    public static void openMain() {
        open("http://192.168.128.234/my/login");
    }
}
