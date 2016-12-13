package ru.yandex.autotests.qa.qe.deadline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by dmitrys
 * 28.10.15.
 */
public class EditPenaltyPromptPage {

    public EditPenaltyPromptPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    @Name("Content")
    @FindBy(xpath = "//div[contains(@class, 'space_content')]")
    private HtmlElement content;

    @Name("Prompt Timeout Days")
    @FindBy(xpath = "//input[@name='NewPromptTimeoutDays']")
    private HtmlElement promptTimeoutDays;

    @Name("Prompt Timeout Hours")
    @FindBy(xpath = "//input[@name='NewPromptTimeoutHours']")
    private HtmlElement promptTimeoutHours;

    @Name("Prompt Timeout Minutes")
    @FindBy(xpath = "//input[@name='NewPromptTimeoutMinutes']")
    private HtmlElement promptTimeoutMinutes;

    @Name("Prompt Timeout Seconds")
    @FindBy(xpath = "//input[@name='NewPromptTimeoutSeconds']")
    private HtmlElement promptTimeoutSeconds;

    @Name("Prompt Description")
    @FindBy(xpath = "//textarea[@name='txtPenaltyComment']")
    private HtmlElement promptDescription;

    @Name("Prompt")
    @FindBy(xpath = "//textarea[@name='NewPrompt']")
    private HtmlElement prompt;

    @Name("PenaltyPromptHours")
    @FindBy(xpath = "//input[@name='PenaltyPromptHours']")
    private HtmlElement penaltyPromptHours;

    @Name("PenaltyPromptMinutes")
    @FindBy(xpath = "//input[@name='PenaltyPromptMinutes']")
    private HtmlElement penaltyPromptMinutes;

    @Name("PenaltyPromptSeconds")
    @FindBy(xpath = "//input[@name='PenaltyPromptSeconds']")
    private HtmlElement penaltyPromptSeconds;

    @Name("PenaltyPrompt addButton")
    @FindBy(xpath = "//input[@id='btnAdd']")
    private HtmlElement addButton;

    public HtmlElement getContent() {
        return content;
    }

    public HtmlElement getPromptTimeoutDays() {
        return promptTimeoutDays;
    }

    public HtmlElement getPromptTimeoutHours() {
        return promptTimeoutHours;
    }

    public HtmlElement getPromptTimeoutMinutes() {
        return promptTimeoutMinutes;
    }

    public HtmlElement getPromptTimeoutSeconds() {
        return promptTimeoutSeconds;
    }

    public HtmlElement getPromptDescription() {
        return promptDescription;
    }

    public HtmlElement getPrompt() {
        return prompt;
    }

    public HtmlElement getPenaltyPromptHours() {
        return penaltyPromptHours;
    }

    public HtmlElement getPenaltyPromptMinutes() {
        return penaltyPromptMinutes;
    }

    public HtmlElement getPenaltyPromptSeconds() {
        return penaltyPromptSeconds;
    }

    public HtmlElement getAddButton() {
        return addButton;
    }
}
