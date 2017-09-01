package ru.yandex.autotests.qa.qe.deadline.pages;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dmitrys
 * 27.10.15.
 */
public class LevelPage {
  private WebDriver driver;
  private JavascriptExecutor js;

  public LevelPage(WebDriver driver) {
    HtmlElementLoader.populatePageObject(this, driver);
    this.driver = driver;
    js = (JavascriptExecutor) this.driver;
  }

  @Name("Main content")
  @FindBy(xpath = "//td[@id='tdContentCenter']")
  private HtmlElement mainContent;

  @Name("Level name")
  @FindBy(xpath = "//a[@id='pnlSettings_lnkLevelNameEdit']")
  private HtmlElement levelName;

  @Name("Add Penalty Prompt")
  @FindBy(xpath = "//a[img[@name='ctl05_ctl00_btnPenaltyPromptAdd']]")
  private HtmlElement addPenaltyPrompt;

  @Name("Add Task button")
  @FindBy(xpath = "//a[@id='ctl02_ctl00_lnkTaskAdd']")
  private HtmlElement addTaskButton;

  @Name("Add Bonus")
  @FindBy(xpath = "//a[img[@name='ctl06_ctl00_btnBonusAdd']]")
  private HtmlElement addBonusButton;

  @Name("First bonus")
  @FindBy(xpath = "(//a[contains(@href, 'action=view')])[1]")
  private HtmlElement firstBonusLink;

  @Name("First list")
  @FindBy(xpath = "//a[contains(@href, 'action=view')]")
  private List<HtmlElement> bonusLinkList;

  @Name("Task link")
  @FindBy(xpath = "//a[@id='ctl02_ctl00_TasksRepeater_ctl00_lnkTaskEditor']")
  private HtmlElement taskLink;

  @Name("Show Answers")
  @FindBy(xpath = "//a[@id='AnswersTable_ctl00_lnkShowAnswers']")
  private HtmlElement showAnswersButton;

  @Name("Sectors list")
  @FindBy(xpath = "//div[@class='cb']/form/div[contains(@id, 'divSectorManage')]")
  private List<HtmlElement> sectorsList;

  @Name("Add sector link")
  @FindBy(xpath = "//a[@id='AnswersTable_ctl00_lnkCreateSector']")
  private HtmlElement addSectorLink;

  @Name("Sector Name")
  @FindBy(xpath = "//input[@name='txtSectorName']")
  private HtmlElement sectorName;

  @Name("Save Sector")
  @FindBy(xpath = "(//input[@name='btnSaveSector'])[1]")
  private HtmlElement saveSector;

  public HtmlElement getMainContent() {
    return mainContent;
  }

  public HtmlElement getLevelName() {
    return levelName;
  }

  public HtmlElement getAddTaskButton() {
    return addTaskButton;
  }

  public HtmlElement getAddPenaltyPrompt() {
    return addPenaltyPrompt;
  }

  public HtmlElement getAddBonusButton() {
    return addBonusButton;
  }

  public HtmlElement getTaskLink() {
    return taskLink;
  }

  public int getBonusCount() {
    return Integer.parseInt(js.executeScript("return $(\"a[href*='action=view']\").length").toString());
  }

  public boolean hasBonus() {
    return (boolean) js.executeScript("return $(\"a[href*='action=view']\").length > 0");
  }

  public WebElement getFirstBonusLink() {
    return firstBonusLink;
//    return (WebElement) js.executeScript("return $(\"a[href*='action=view']\")[0]");
  }

  public List<HtmlElement> getBonusLinkList() {
    return bonusLinkList;
  }

  public HtmlElement getShowAnswersButton() {
    return showAnswersButton;
  }

  public List<HtmlElement> getSectorsList() {
    return sectorsList;
  }

  public List<WebElement> getAnswersFromSector(String id) {
    return driver.findElements(By.xpath("//div[@id='divAnswersView_" + id + "']/div/div/div/div"));
  }

  public HtmlElement getAddSectorLink() {
    return addSectorLink;
  }

  public HtmlElement getSectorName() {
    return sectorName;
  }

  public WebElement getNextAnswer(int i) {
    return driver.findElement(By.xpath("(//input[@name='txtAnswer_" + i + "'])[2]"));
  }

  public HtmlElement getSaveSector() {
    return saveSector;
  }
}
