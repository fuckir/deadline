package ru.yandex.autotests.qa.qe.deadline.pages;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dmitrys
 * 28.10.15.
 */
public class EditPromptPage {

  public EditPromptPage(WebDriver driver) {
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

  @Name("Prompt")
  @FindBy(xpath = "//textarea[@name='NewPrompt']")
  private HtmlElement prompt;

  @Name("Prompt addButton")
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

  public HtmlElement getPrompt() {
    return prompt;
  }

  public HtmlElement getAddButton() {
    return addButton;
  }
}
