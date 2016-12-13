package ru.yandex.autotests.qa.qe.deadline.run;

import ru.yandex.aqua.annotations.project.Aqua;
import ru.yandex.aqua.annotations.project.Feature;
import ru.yandex.autotests.qa.qe.deadline.rule.WebDriverRule;
import ru.yandex.autotests.qa.qe.deadline.steps.Steps;
import ru.yandex.junitextensions.rules.passportrule.PassportRule;

import java.net.MalformedURLException;
import java.net.URL;
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

@Aqua.Test(title = "Заливалка заданий на deadline", description = "Заливалка заданий на deadline")
@Feature("DeadlineTest")
public class DeadlineTest {

  private Steps steps;
  //    private String serviceUrl = "http://deadline.en.cx";
  private String serviceUrl = "http://demo.en.cx/";

  @Rule
  public final WebDriverRule webDriverRule = new WebDriverRule(DesiredCapabilities.firefox());

  @Rule
  public PassportRule passport;

  @Before
  public void login() throws Exception {
    WebDriver driver = webDriverRule.getDriver();

    steps = new Steps(driver);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);

    final String login = "zomb-backa-dev-monit";
    final String password = "dfsKT4kdG3";
    final URL host = getPassportHost();

    passport = new PassportRule(driver)
        .onHost(host)
        .withLoginPassword(login, password)
        .withRetpath(serviceUrl);
    passport.login();


  }

  private URL getPassportHost() {
    try {
      return new URL("https://passport.yandex-team.ru/");
    } catch (MalformedURLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testAddBonus() {
    String gameID = "51825";
    int level = 28;
    steps.goToLink(serviceUrl);
    steps.waitMainContent();
    steps.login();
    steps.waitMainContent();
    steps.goToLink(serviceUrl + "/Administration/Games/LevelManager.aspx?gid=" + gameID);
    steps.constructBonusList();
    steps.addBonus(level);
  }

  @Test
  public void addEdem() {
    String gameID = "51826";
    steps.goToLink(serviceUrl);
    steps.waitMainContent();
    steps.login();
    steps.waitMainContent();
    steps.goToLink(serviceUrl + "/Administration/Games/LevelManager.aspx?gid=" + gameID);
    steps.constructBonusList();
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

}
