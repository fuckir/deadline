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
 * 27.10.15.
 */
public class EditGamePage {
    private WebDriver driver;

    public EditGamePage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
    }

    @Name("Manage page link")
    @FindBy(xpath = "//*[@id='lnkGameLevelManager']")
    private HtmlElement managePageLink;

    public HtmlElement getManagePageLink() {
        return managePageLink;
    }

    public WebElement goToLevel(String number) {
        return (WebElement) ((JavascriptExecutor) driver).executeScript("return $('#LevelNamesRepeater_ctl"+number+"_lnkLevelEdit')[0]");
    } //$('#LevelNamesRepeater_ctl02_lnkLevelEdit')
}
