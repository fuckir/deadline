package ru.yandex.autotests.qa.qe.deadline.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by dmitrys
 * 06.05.15.
 */
public class PageSwitcher {
    private final WebElement link;
    private String originalWindow;
    private String newWindow;
    private final WebDriver driver;

    public PageSwitcher(WebElement link, WebDriver driver) {
        this.link = link;
        this.driver = driver;
    }

    public String getOriginalWindow() {
        return originalWindow;
    }

    public String getNewWindow() {
        return newWindow;
    }

    public PageSwitcher invoke() {
        originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();
        link.click();
        newWindow = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        return this;
    }
}
