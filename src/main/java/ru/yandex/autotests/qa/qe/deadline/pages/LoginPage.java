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
public class LoginPage {

    public LoginPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    @Name("Login")
    @FindBy(xpath = "//input[@id='txtLogin']")
    private HtmlElement login;

    @Name("Password")
    @FindBy(xpath = "//input[@id='txtPassword']")
    private HtmlElement password;

    @Name("loginButton")
    @FindBy(xpath = "//input[@name='EnButton1']")
    private HtmlElement loginButton;

    public HtmlElement getLogin() {
        return login;
    }

    public HtmlElement getPassword() {
        return password;
    }

    public HtmlElement getLoginButton() {
        return loginButton;
    }
}
