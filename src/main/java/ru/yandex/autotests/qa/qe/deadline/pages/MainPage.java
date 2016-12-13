package ru.yandex.autotests.qa.qe.deadline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by dmitrys
 * 27.10.15.
 */
public class MainPage {

    public MainPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    @Name("Main content")
    @FindBy(xpath = "//td[@id='tdContentCenter']")
    private HtmlElement mainContent;

    @Name("Login link")
    @FindBy(xpath = "//a[@id='ctl14_ctl04_ctl00_lnkLogin']")
    private HtmlElement loginLink;

    public HtmlElement getMainContent() {
        return mainContent;
    }

    public HtmlElement getLoginLink() {
        return loginLink;
    }
}
