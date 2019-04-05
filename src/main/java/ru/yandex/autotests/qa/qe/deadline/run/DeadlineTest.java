package ru.yandex.autotests.qa.qe.deadline.run;

import ru.yandex.autotests.qa.qe.deadline.rule.WebDriverRule;
import ru.yandex.autotests.qa.qe.deadline.steps.Steps;

import java.util.concurrent.TimeUnit;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by dmitrys
 * 27.10.15.
 */

public class DeadlineTest {
  private Steps steps;
  private String serviceUrl = "http://deadline.en.cx";
  //  private String serviceUrl = "http://demo.en.cx/";
  private String LOGIN = "FuckIR";
  private String PASSWORD = "password";
  private int gameID = 61646;

  @Rule
  public final WebDriverRule webDriverRule = new WebDriverRule(DesiredCapabilities.firefox());

  @Before
  public void login() {
    WebDriver driver = webDriverRule.getDriver();

    steps = new Steps(driver);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
  }

  @Test
  public void testAddBonus() {
    int level = 7;
    steps.goToLink(serviceUrl);
    steps.waitMainContent();
    steps.login(LOGIN, PASSWORD);
    steps.waitMainContent();
    steps.goToLink(serviceUrl + "/Administration/Games/LevelManager.aspx?gid=" + gameID);
    steps.goToLevel(level);
    steps.deleteAllBonus();
    steps.construct7BonusListWhite();
    steps.construct7BonusList();
    steps.addBonus();
  }

  @Test
  public void testAdd3Bonus() {
    int level = 3;
    steps.goToLink(serviceUrl);
    steps.waitMainContent();
    steps.login(LOGIN, PASSWORD);
    steps.waitMainContent();
    steps.goToLink(serviceUrl + "/Administration/Games/LevelManager.aspx?gid=" + gameID);
    steps.goToLevel(level);
    steps.deleteAllBonus();
    steps.construct3BonusList();
    steps.addBonus();
  }

  @Test
  public void testAddAllBonus() {
    int level = 11;
    steps.goToLink(serviceUrl);
    steps.waitMainContent();
    steps.login(LOGIN, PASSWORD);
    steps.waitMainContent();
    steps.goToLink(serviceUrl + "/Administration/Games/LevelManager.aspx?gid=" + gameID);
    steps.goToLevel(level);
    steps.constructAllBonusList();
    steps.addBonus();
  }

  @Test
  public void addEdem() {
    steps.goToLink(serviceUrl);
    steps.waitMainContent();
    steps.login(LOGIN, PASSWORD);
    steps.waitMainContent();
    steps.goToLink(serviceUrl + "/Administration/Games/LevelManager.aspx?gid=" + gameID);
    steps.construct7BonusList();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
    steps.addBonus();
  }

  @Test
  public void getLevelsAndCopyToDemo() {
    int level = 1;
    steps.goToLink(serviceUrl);
    steps.waitMainContent();
    steps.login(LOGIN, PASSWORD);
    steps.waitMainContent();
    steps.goToLink(serviceUrl + "/Administration/Games/LevelManager.aspx?gid=" + 59542);
    steps.goToLevel(level);
    steps.copyLevel();

    steps.goToLink("http://demo.en.cx/Administration/Games/LevelManager.aspx?gid=28376");
//    steps.waitMainContent();
    steps.login(LOGIN, "demoPass");
//    steps.waitMainContent();
    steps.goToLink("http://demo.en.cx/Administration/Games/LevelManager.aspx?gid=" + 28376);
    steps.goToLevel(6);
    steps.addPenaltyPrompt();
    steps.addSectors();
    steps.addTask();
    steps.constructDemoBonusList();
    steps.addBonus();
  }

  @Test
  public void market() {
    steps.goToLink("http://demo.en.cx");
    steps.waitMainContent();
    steps.login(LOGIN, "demoPass");
    steps.waitMainContent();
    steps.goToLink("http://demo.en.cx/Administration/Games/LevelManager.aspx?gid=" + 28238);
    steps.goToLevel(5);

    steps.constructPenalty();
    steps.addPenaltyPrompt();

    steps.constructSaleBonuses();
    steps.addBonus();
    steps.constructBuyBonuses();
    steps.addBonus();
    steps.constructHints();
    steps.addPrompt();
  }


  @Test
  public void demoCopy() {
    steps.goToLink("http://demo.en.cx");
    steps.waitMainContent();
    steps.login(LOGIN, "demoPass");
    steps.waitMainContent();
    steps.goToLink("http://demo.en.cx/Administration/Games/LevelManager.aspx?gid=" + 28667);

    int level = 20;
    steps.goToLevel(level);
    steps.copyLevel();

    steps.goToLink(serviceUrl);
    steps.waitMainContent();
    steps.login(LOGIN, PASSWORD);
    steps.waitMainContent();
    steps.goToLink(serviceUrl + "/Administration/Games/LevelManager.aspx?gid=" + 63030);
    steps.goToLevel(level);
    steps.addSectors();
    steps.addTask();
    steps.constructDemoBonusList();
    steps.addBonus();
    steps.addPenaltyPrompt();
  }
}
