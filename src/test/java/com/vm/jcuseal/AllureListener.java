package com.vm.jcuseal;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureListener implements TestListener {

    @Attachment
    public byte[] saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void addError(Test test, Throwable e) {

    }

    @Override
    public void addFailure(Test test, AssertionFailedError e) {

    }

    @Override
    public void endTest(Test test) {

    }

    @Override
    public void startTest(Test test) {

    }
}
