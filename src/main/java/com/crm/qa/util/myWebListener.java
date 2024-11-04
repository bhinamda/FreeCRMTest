package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class myWebListener extends TestBase implements WebDriverListener
{
    public void beforeGet(WebDriver driver, String url) {
        System.out.println("Before navigating to: '" + url + "'");
    }

    public void afterGet(WebDriver driver, String url) {
        System.out.println("Navigated to:'" + prop.getProperty("url") + "'");
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find Element By : " + by.toString());
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found Element By : " + by.toString());
    }

    public void beforeGetTitle(WebDriver driver) {
    }

    public void afterGetTitle(WebDriver driver, String result) {
    }

    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        System.out.println("An error occurred while invoking method: " + method.getName());
        System.out.println("Error message: " + e.getMessage());
        try {
            // Call the screenshot method when an error occurs
            TestUtils.takeScreenshotAtEndOfTest();
            System.out.println("Screenshot taken for error: " + e.getMessage());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void beforeFindElement(WebDriver driver, By locator) {
    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
    }

    public void beforeQuit(WebDriver driver) {
        System.out.println("Before quitting the driver");
    }

    public void afterQuit(WebDriver driver) {
        System.out.println("After quitting the driver");
    }

    public void beforeClick(WebElement element) {
        System.out.println("Trying to click on: " + element.toString());
    }

    public void afterClick(WebElement element) {
        System.out.println("Clicked on: " + element.toString());
    }

    public void beforeSubmit(WebElement element) {
    }

    public void afterSubmit(WebElement element) {
    }

    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
    }

    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
    }

    public void beforeGetText(WebElement element) {
    }

    public void afterGetText(WebElement element, String result) {
    }

    public void beforeSendKeys(Alert alert, String text) {
    }

    public void afterSendKeys(Alert alert, String text) {
    }
}

