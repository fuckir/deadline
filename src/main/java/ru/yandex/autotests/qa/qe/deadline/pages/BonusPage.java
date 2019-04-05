package ru.yandex.autotests.qa.qe.deadline.pages;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

  @Name("First Empty Answer")
  @FindBy(xpath = "//input[@name='answer_-1']")
  private HtmlElement firstEmptyAnswer;

  @Name("Answer List")
  @FindBy(xpath = "//tbody[@class='answersContainer']//input")
  private List<HtmlElement> answerList;

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

  @Name("bonusHours")
  @FindBy(xpath = "//input[@name='txtHours']")
  private HtmlElement bonusHours;

  @Name("bonusMinutes")
  @FindBy(xpath = "//input[@name='txtMinutes']")
  private HtmlElement bonusMinutes;

  @Name("bonusSeconds")
  @FindBy(xpath = "//input[@name='txtSeconds']")
  private HtmlElement bonusSeconds;

  @Name("txtHelp")
  @FindBy(xpath = "//textarea[@name='txtHelp']")
  private HtmlElement txtHelp;

  @Name("add bonus button")
  @FindBy(xpath = "//input[@name='btnAdd']")
  private HtmlElement addBonusUrl;

  @Name("Edit Button")
  @FindBy(xpath = "//td[@class='buttons_panel']/a[contains(@href, 'action=edit')]")
  private HtmlElement editButton;

  @Name("Delete bonus button")
  @FindBy(xpath = "//a[img[@title='Удалить']]")
  private HtmlElement deleteBonusButton;

  @Name("List level Available")
  @FindBy(xpath = "//div[@class='levelWrapper'][div//input[@checked]]//span")
  private List<HtmlElement> levelAvailableElementList;

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

  public HtmlElement getFirstEmptyAnswer() {
    return firstEmptyAnswer;
  }

  public List<HtmlElement> getAnswerList() {
    return answerList;
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

  public HtmlElement getBonusHours() {
    return bonusHours;
  }

  public HtmlElement getBonusMinutes() {
    return bonusMinutes;
  }

  public HtmlElement getBonusSeconds() {
    return bonusSeconds;
  }

  public HtmlElement getTxtHelp() {
    return txtHelp;
  }

  public HtmlElement getAddBonusUrl() {
    return addBonusUrl;
  }

  public HtmlElement getEditButton() {
    return editButton;
  }

  public HtmlElement getDeleteBonusButton() {
    return deleteBonusButton;
  }

  public WebElement getCurrentAnswer(int index) {
    return (WebElement) js.executeScript("return $(\"input[name=answer_-" + (index + 1) + "]\")[0];");
  }

  public WebElement getTenMoreAnswers() {
    return (WebElement) js.executeScript("return $(\".dashed:contains('10')\")[0];");
  }

  public List<Integer> getLevelAvailableElementList() {
    List<Integer> levelAvailableList = new ArrayList<>();
    for (HtmlElement level : levelAvailableElementList) {
      levelAvailableList.add(Integer.parseInt(level.getText()));
    }
    return levelAvailableList;
  }
}
