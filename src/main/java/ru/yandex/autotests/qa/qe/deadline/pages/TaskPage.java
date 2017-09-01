package ru.yandex.autotests.qa.qe.deadline.pages;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * @author dmitrys
 * @since 31.08.17
 */
public class TaskPage {

  public TaskPage(WebDriver driver) {
    HtmlElementLoader.populatePageObject(this, driver);
  }

  @Name("Edit Button")
  @FindBy(xpath = "//a[@id='lnkEdit']")
  private HtmlElement editButton;

  @Name("Edit Text")
  @FindBy(xpath = "//textarea")
  private HtmlElement editText;

  @Name("Text")
  @FindBy(xpath = "//textarea[@class='textarea_blank']")
  private HtmlElement text;

  @Name("Add button")
  @FindBy(xpath = "//input[@id='btnAdd']")
  private HtmlElement addButton;

  public HtmlElement getEditButton() {
    return editButton;
  }

  public HtmlElement getEditText() {
    return editText;
  }

  public HtmlElement getText() {
    return text;
  }

  public HtmlElement getAddButton() {
    return addButton;
  }
}
