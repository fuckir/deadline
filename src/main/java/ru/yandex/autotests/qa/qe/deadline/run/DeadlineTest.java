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
  private int gameID = 57413;

  @Rule
  public final WebDriverRule webDriverRule = new WebDriverRule(DesiredCapabilities.firefox());

  @Before
  public void login() throws Exception {
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
    steps.addBonus(level);
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
    steps.addBonus(level);
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
    steps.addBonus(level);
  }

  @Test
  public void addEdem() {
    steps.goToLink(serviceUrl);
    steps.waitMainContent();
    steps.login(LOGIN, PASSWORD);
    steps.waitMainContent();
    steps.goToLink(serviceUrl + "/Administration/Games/LevelManager.aspx?gid=" + gameID);
    steps.construct7BonusList();
    steps.addBonus(7);
    steps.addBonus(9);
    steps.addBonus(11);
    steps.addBonus(14);
    steps.addBonus(17);
    steps.addBonus(20);
    steps.addBonus(23);
    steps.addBonus(27);
    steps.addBonus(30);
    steps.addBonus(34);
    steps.addBonus(37);
    steps.addBonus(40);
    steps.addBonus(43);
    steps.addBonus(46);
    steps.addBonus(49);
    steps.addBonus(52);
    steps.addBonus(55);
    steps.addBonus(58);
    steps.addBonus(61);
    steps.addBonus(66);
    steps.addBonus(69);
    steps.addBonus(72);
    steps.addBonus(75);
    steps.addBonus(79);
  }

  @Test
  public void getLevelsAndCopyToDemo() throws Exception {
    int level = 42;
    steps.goToLink(serviceUrl);
    steps.waitMainContent();
    steps.login(LOGIN, PASSWORD);
    steps.waitMainContent();
    steps.goToLink(serviceUrl + "/Administration/Games/LevelManager.aspx?gid=" + gameID);
    steps.goToLevel(level);
    steps.copyLevel();

    steps.goToLink("http://demo.en.cx");
    steps.waitMainContent();
    steps.login(LOGIN, "demoPass");
    steps.waitMainContent();
    steps.goToLink("http://demo.en.cx" + "/Administration/Games/LevelManager.aspx?gid=" + 26982);
    steps.goToLevel(5);
    steps.addTask();
    steps.constructDemoBonusList();
    steps.addBonus( 5);
    steps.addSectors();
  }
}
