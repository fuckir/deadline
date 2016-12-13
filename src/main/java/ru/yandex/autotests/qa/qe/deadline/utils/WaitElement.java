package ru.yandex.autotests.qa.qe.deadline.utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitElement {

    private final WebDriver driver;

    public WaitElement(WebDriver driver) {
        this.driver = driver;
    }

    public void wait(WebElement element, int timeOutInSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new RuntimeException(e.getMessage() + " " + driver.getCurrentUrl());
        }
    }
}
