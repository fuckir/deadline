package ru.yandex.autotests.qa.qe.deadline.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by dmitrys
 * 30.10.15.
 */
public class BonusPage {
    private WebDriver driver;
    private JavascriptExecutor js;

    public BonusPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        js = (JavascriptExecutor) this.driver;
    }

    @Name("Name")
    @FindBy(xpath = "//input[@name='txtBonusName']")
    private HtmlElement name;

    @Name("Task")
    @FindBy(xpath = "//textarea[@name='txtTask']")
    private HtmlElement task;

    @Name("First Answer")
    @FindBy(xpath = "//input[@name='answer_-1']")
    private HtmlElement firstAnswer;

    @Name("chkDelay")
    @FindBy(xpath = "//input[@id='chkDelay']")
    private HtmlElement chkDelay;

    @Name("txtDelayHours")
    @FindBy(xpath = "//input[@id='txtDelayHours']")
    private HtmlElement txtDelayHours;

    @Name("txtDelayMinutes")
    @FindBy(xpath = "//input[@id='txtDelayMinutes']")
    private HtmlElement txtDelayMinutes;

    @Name("txtDelaySeconds")
    @FindBy(xpath = "//input[@id='txtDelaySeconds']")
    private HtmlElement txtDelaySeconds;

    @Name("chkRelativeLimit")
    @FindBy(xpath = "//input[@id='chkRelativeLimit']")
    private HtmlElement chkRelativeLimit;

    @Name("txtValidHours")
    @FindBy(xpath = "//input[@id='txtValidHours']")
    private HtmlElement txtValidHours;

    @Name("txtValidMinutes")
    @FindBy(xpath = "//input[@id='txtValidMinutes']")
    private HtmlElement txtValidMinutes;

    @Name("txtValidSeconds")
    @FindBy(xpath = "//input[@id='txtValidSeconds']")
    private HtmlElement txtValidSeconds;

    @Name("txtHelp")
    @FindBy(xpath = "//textarea[@name='txtHelp']")
    private HtmlElement txtHelp;

    @Name("add bonus button")
    @FindBy(xpath = "//input[@name='btnAdd']")
    private HtmlElement addBonusUrl;

    public HtmlElement getName() {
        return name;
    }

    public HtmlElement getTask() {
        return task;
    }

    public WebElement getCurrentLevel(int levelNumber) {
        int index = levelNumber - 1;
        return (WebElement) js.executeScript("return $('.levelWrapper input')[" + index + "]");
    }

    public HtmlElement getFirstAnswer() {
        return firstAnswer;
    }

    public HtmlElement getChkDelay() {
        return chkDelay;
    }

    public HtmlElement getTxtDelayHours() {
        return txtDelayHours;
    }

    public HtmlElement getTxtDelayMinutes() {
        return txtDelayMinutes;
    }

    public HtmlElement getTxtDelaySeconds() {
        return txtDelaySeconds;
    }

    public HtmlElement getChkRelativeLimit() {
        return chkRelativeLimit;
    }

    public HtmlElement getTxtValidHours() {
        return txtValidHours;
    }

    public HtmlElement getTxtValidMinutes() {
        return txtValidMinutes;
    }

    public HtmlElement getTxtValidSeconds() {
        return txtValidSeconds;
    }

    public HtmlElement getTxtHelp() {
        return txtHelp;
    }

    public HtmlElement getAddBonusUrl() {
        return addBonusUrl;
    }
}
