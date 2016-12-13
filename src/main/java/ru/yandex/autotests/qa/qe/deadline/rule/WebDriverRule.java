package ru.yandex.autotests.qa.qe.deadline.rule;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.selenium.grid.GridClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;


import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverRule extends TestWatcher implements WebDriver, TakesScreenshot, HasInputDevices, JavascriptExecutor {
  private WebDriver driver;
  private DesiredCapabilities caps;

  public WebDriverRule(DesiredCapabilities caps) {
    this.caps = caps;
  }

  public WebDriverRule(WebDriver webDriver) {
    this.driver = webDriver;
  }

  protected void starting(Description description) {
    this.getDriver();
  }

  protected void finished(Description description) {
    if (this.driver != null && this.isRemoteSessionActive()) {
      this.driver.quit();
    }

    this.driver = null;
  }

  protected void failed(Throwable e, Description description) {
    try {
      makeScreenshot();
    } catch (RuntimeException err) {
      err.printStackTrace();
    }

  }

  protected void skipped(AssumptionViolatedException e, Description description) {
    makeScreenshot();
  }

  @Attachment(
      type = "image/png"
  )
  public byte[] makeScreenshot() {
    return ((TakesScreenshot) (new Augmenter()).augment(this.driver)).getScreenshotAs(OutputType.BYTES);
  }

  public WebDriver getDriver() {
    if (this.driver == null) {
      try {
        this.driver = new RemoteWebDriver(new URL(String.format("http://%s:%s@%s:%s/wd/hub", "ff", "pp", "localhost", 4444)), caps);
      } catch (MalformedURLException e) {
        throw new RuntimeException("Аailed to open browser");
      }
    }

    return this.driver;
  }

  public DesiredCapabilities getCaps() {
    return this.caps;
  }

  public void setDriver(WebDriver driver) {
    this.driver = driver;
  }

  private boolean isRemoteSessionActive() {
    try {
      this.driver.getCurrentUrl();
      return true;
    } catch (WebDriverException var2) {
      return false;
    }
  }

  public void get(String s) {
    this.getDriver().get(s);
  }

  public String getCurrentUrl() {
    return this.getDriver().getCurrentUrl();
  }

  public String getTitle() {
    return this.getDriver().getTitle();
  }

  public List<WebElement> findElements(By by) {
    return this.getDriver().findElements(by);
  }

  public WebElement findElement(By by) {
    return this.getDriver().findElement(by);
  }

  public String getPageSource() {
    return this.getDriver().getPageSource();
  }

  public void close() {
    this.getDriver().close();
  }

  public void quit() {
    this.getDriver().quit();
  }

  public Set<String> getWindowHandles() {
    return this.getDriver().getWindowHandles();
  }

  public String getWindowHandle() {
    return this.getDriver().getWindowHandle();
  }

  public TargetLocator switchTo() {
    return this.getDriver().switchTo();
  }

  public Navigation navigate() {
    return this.getDriver().navigate();
  }

  public Options manage() {
    return this.getDriver().manage();
  }

  public Keyboard getKeyboard() {
    return ((HasInputDevices) (new Augmenter()).augment(this.driver)).getKeyboard();
  }

  public Mouse getMouse() {
    return ((HasInputDevices) (new Augmenter()).augment(this.driver)).getMouse();
  }

  public <X> X getScreenshotAs(OutputType<X> target) {
    return ((TakesScreenshot) (new Augmenter()).augment(this.driver)).getScreenshotAs(target);
  }

  public Object executeScript(String script, Object... args) {
    return ((JavascriptExecutor) (new Augmenter()).augment(this.driver)).executeScript(script, args);
  }

  public Object executeAsyncScript(String script, Object... args) {
    return ((JavascriptExecutor) (new Augmenter()).augment(this.driver)).executeAsyncScript(script, args);
  }
}
