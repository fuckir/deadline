package ru.yandex.autotests.qa.qe.deadline.rule;

import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

/**
 * Created by dmitrys
 * 04.06.15.
 */
public class ErrorsRule extends TestWatcher {
    private final WebDriverRule driver;

    public ErrorsRule(WebDriverRule webDriver) {
        this.driver = webDriver;
    }

    protected void failed(Throwable e, Description description) {
        driver.makeScreenshot();
    }

    protected void skipped(AssumptionViolatedException e, Description description) {
        driver.makeScreenshot();
    }


    public WebDriver getDriver() {
        return this.driver;
    }


}
