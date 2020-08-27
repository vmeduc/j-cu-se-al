package com.vm.jcuseal;

import io.cucumber.java.en.When;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class DebugSteps {

    public Map<String, String> temp = new HashMap<>() {{
       put("name", "vlad"); put("value", "11");
    }};

    @When("{string} соответствует {string}")
    public void соответствует(String name, String value) {
        Assert.assertEquals(name, temp.get(name));
        Assert.assertEquals(value, temp.get(value));
    }

    @Тогда("вот это поворот")
    public void вотЭтоПоворот() {

    }

    @Когда("имя {string} и число {string}")
    public void имяИЧисло(String name, String value) {
    }
}
