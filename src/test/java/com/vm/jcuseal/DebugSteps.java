package com.vm.jcuseal;

import io.cucumber.java.ru.Когда;
import io.qameta.allure.Allure;

public class DebugSteps {
    @Когда("вводится текст")
    public void вводитсяТекст(String text) {
        Allure.addAttachment("text", text);
    }
}
