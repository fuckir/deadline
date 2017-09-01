package ru.yandex.autotests.qa.qe.deadline.steps;

import ru.yandex.autotests.qa.qe.deadline.domain.Answer;
import ru.yandex.autotests.qa.qe.deadline.domain.Bonus;
import ru.yandex.autotests.qa.qe.deadline.domain.BonusConstructor;
import ru.yandex.autotests.qa.qe.deadline.domain.Sector;
import ru.yandex.autotests.qa.qe.deadline.pages.*;
import ru.yandex.autotests.qa.qe.deadline.utils.PageSwitcher;
import ru.yandex.autotests.qa.qe.deadline.utils.WaitElement;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by dmitrys
 * 27.10.15.
 */
public class Steps {

  private WebDriver driver;
  private MainPage mainPage;
  private LoginPage loginPage;
  private EditGamePage editGamePage;
  private LevelPage levelPage;
  private WaitElement waitElement;
  private EditPenaltyPromptPage editPenaltyPromptPage;
  private BonusPage bonusPage;
  private TaskPage taskPage;
  private BonusConstructor bonusConstructor = new BonusConstructor();

  private String textLevel;
  private List<Bonus> bonusList = new ArrayList<>();
  private List<Sector> sectors = new ArrayList<>();

  public Steps(WebDriver driver) {
    this.driver = driver;
    mainPage = new MainPage(driver);
    loginPage = new LoginPage(driver);
    editGamePage = new EditGamePage(driver);
    levelPage = new LevelPage(driver);
    waitElement = new WaitElement(driver);
    editPenaltyPromptPage = new EditPenaltyPromptPage(driver);
    bonusPage = new BonusPage(driver);
    taskPage = new TaskPage(driver);
  }

  @Step
  public void waitMainContent() {
    waitElement.wait(mainPage.getMainContent(), 5);
  }

  @Step
  public void login(String login, String pass) {
    mainPage.getLoginLink().click();
    loginPage.getLogin().sendKeys(login);
    loginPage.getPassword().sendKeys(pass);
    loginPage.getLoginButton().click();
  }

  @Step
  public void goToLink(String link) {
    driver.get(link);
  }

  @Step
  public void goToManagerPage() {
    editGamePage.getManagePageLink().click();
  }

  @Step
  public void addPenaltyPrompt(String number) {
    editGamePage.goToLevel(number).click();
    waitElement.wait(levelPage.getMainContent(), 5);
    String levelName = levelPage.getLevelName().getText();
    levelPage.getAddPenaltyPrompt().click();
    waitElement.wait(editPenaltyPromptPage.getContent(), 5);
    for (int i = 1; i < 2; i++) {
      editPenaltyPromptPage.getPromptTimeoutHours().clear();
      editPenaltyPromptPage.getPromptTimeoutHours().sendKeys("1");
      editPenaltyPromptPage.getPromptDescription().clear();
      editPenaltyPromptPage.getPromptDescription().sendKeys(levelName + i);

      editPenaltyPromptPage.getPenaltyPromptHours().clear();
      editPenaltyPromptPage.getPenaltyPromptMinutes().clear();
      editPenaltyPromptPage.getPenaltyPromptMinutes().sendKeys("10");

      editPenaltyPromptPage.getAddButton().click();
    }
  }

  @Step
  public void addBonus(int... levels) {
    int size = bonusConstructor.getBonuses().size();
    for (int i = 0; i < size; i++) {
      PageSwitcher pageSwitcher = new PageSwitcher(levelPage.getAddBonusButton(), driver).invoke();
      driver.switchTo().window(pageSwitcher.getNewWindow());

      //name
      bonusPage.getName().sendKeys(bonusConstructor.getBonuses().get(i).getName());
      //task
      bonusPage.getTask().sendKeys(bonusConstructor.getBonuses().get(i).getTask());
      //codes
      String code = bonusConstructor.getBonuses().get(i).getCode();
      if (code != null) {
        bonusPage.getFirstEmptyAnswer().sendKeys(code);
      } else {
        String[] codeArray = bonusConstructor.getBonuses().get(i).getCodeArray();
        for (int j = 0; j < codeArray.length; j++) {
          bonusPage.getCurrentAnswer(j).sendKeys(codeArray[j]);
        }
      }
      //level checkboxes
      for (int level : levels) {
        bonusPage.getCurrentLevel(level).click();
      }

//            bonusPage.getChkDelay().click(); //Задержать время появления
//            bonusPage.getTxtDelayMinutes().clear();
//            bonusPage.getTxtDelayMinutes().sendKeys("45");
//
//            bonusPage.getChkRelativeLimit().click(); //Ограничить время выполнения:
//            bonusPage.getTxtValidMinutes().clear();
//            bonusPage.getTxtValidMinutes().sendKeys("30");
      //hint
      String hint = bonusConstructor.getBonuses().get(i).getHint();
      bonusPage.getTxtHelp().sendKeys(hint);

      //bonus minutes
//      if (code != null) {
//        bonusPage.getBonusMinutes().clear();
//        bonusPage.getBonusMinutes().sendKeys("1");
//      }

      bonusPage.getAddBonusUrl().click();

      driver.close();
      driver.switchTo().window(pageSwitcher.getOriginalWindow());

      try {
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    waitElement.wait(levelPage.getMainContent(), 5);

    goToManagerPage();
  }

  public void construct7BonusList() {
    List<Answer> values = new ArrayList<>();
    values.add(new Answer("тополь", "#00FF00"));
    values.add(new Answer("курица", "#FF0000"));
    values.add(new Answer("коробка", "#00FF00"));
    values.add(new Answer("ленин", "#FF0000"));
    values.add(new Answer("вино", "#FF0000"));
    values.add(new Answer("смарт", "#FF0000"));
    values.add(new Answer("патрон", "#00FF00"));
    values.add(new Answer("сыр", "#FF0000"));
    values.add(new Answer("медаль", "#00FF00"));
    values.add(new Answer("свет", "#FF0000"));
    values.add(new Answer("арена", "#FF0000"));
    values.add(new Answer("клен", "#00FF00"));
    values.add(new Answer("лед", "#FF0000"));
    values.add(new Answer("ель", "#FF0000"));
    values.add(new Answer("утка", "#00FF00"));
    values.add(new Answer("ринг", "#FF0000"));
    values.add(new Answer("лампа", "#FF0000"));
    values.add(new Answer("доски", "#FF0000"));
    values.add(new Answer("бокс", "#00FF00"));
    values.add(new Answer("тарелка", "#FF0000"));
    values.add(new Answer("башня", "#00FF00"));
    values.add(new Answer("мишень", "#00FF00"));
    values.add(new Answer("петух", "#00FF00"));
    values.add(new Answer("шайба", "#FF0000"));
    values.add(new Answer("молния", "#FF0000"));

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        String number = (i + 1) + "." + (j + 1);
        String word = values.get(0).getAnswer();
        String color = values.get(0).getAdditionalValue();
        String script =
            "<script type=\"text/javascript\">document.getElementById(\"" + number + "\").style.backgroundColor = \"" + color + "\";"
            + " document.getElementById(\"" + number + "\").innerHTML = \"" + word + "\"; </script>";
        bonusConstructor.addBonus("", word, script);
        values.remove(0);
      }
    }
  }

  public void construct7BonusListWhite() {
    List<String> words = new ArrayList<>();
    words.add("тополь74");
    words.add("курица49");
    words.add("коробка35");
    words.add("ленин88");
    words.add("вино113");
    words.add("смарт119");
    words.add("патрон214");
    words.add("сыр238");
    words.add("медаль111");
    words.add("свет95");
    words.add("арена93");
    words.add("клен99");
    words.add("лед56");
    words.add("ель72");
    words.add("утка212");
    words.add("ринг86");
    words.add("лампа392");
    words.add("доски31");
    words.add("бокс53");
    words.add("тарелка66");
    words.add("башня57");
    words.add("мишень18");
    words.add("петух41");
    words.add("шайба34");
    words.add("молния52");

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        String number = (i + 1) + "." + (j + 1);
        String word = words.get(0);
        String script =
            "<script type=\"text/javascript\">document.getElementById(\"" + number + "\").style.backgroundColor = \"#ffffff\";"
            + " document.getElementById(\"" + number + "\").innerHTML = \"" + word.split("[0-9]")[0] + "\"; </script>";
        bonusConstructor.addBonus("", word, script);
        words.remove(0);
      }
    }
  }

  @Step
  public void construct3BonusList() {
    List<Bonus> list = new ArrayList<>();
    list.add(new Bonus("Ветка 1", "Д33ГП19А17П64ПМ72Л45В13ПЛ45Ч78ПВо99В53П64ТИ81Б35Н79КЗ66А13ЛП22ПВе27", "", "", ""));
    list.add(new Bonus("Ветка 2", "Па74ПП31О91У27Пи59ЧР42Пе38Г18нп78СП56ТИ57Ф45МВ99Э54ПП62М76З11К32", "", "", ""));
    list.add(new Bonus("Ветка 3", "П58В73ГД95М11ПАН77Е74Л81П41О95Р54", "", "", ""));
    list.add(new Bonus("Ветка 4", "С88Д89ЛП21ПАН57Н92Л78ПБ76УД85", "", "", ""));
    list.add(new Bonus("Ветка 5", "КП47СД25КО32Ч59Сп95А78Са63З75ОК29В64Б42М46", "", "", ""));

    list.add(new Bonus("Паук1", "", "", "", ""));
    list.add(new Bonus("Паук2", "", "", "", ""));
    list.add(new Bonus("Паук3", "", "", "", ""));
    list.add(new Bonus("Паук4", "", "", "", ""));
    list.add(new Bonus("Паук5", "", "", "", ""));
    list.add(new Bonus("Паук6", "", "", "", ""));
    list.add(new Bonus("Паук7", "", "", "", ""));
    list.add(new Bonus("Паук8", "", "", "", ""));
    list.add(new Bonus("Паук9", "", "", "", ""));
    list.add(new Bonus("Паук10", "", "", "", ""));

    list.add(new Bonus("А1Север", "а1ПМ72", "", "б1", "http://d1.endata.cx/data/games/58168/3сб1_8736.jpg"));
    list.add(new Bonus("Б1Север", "б1Л45", "", "в1", "http://d1.endata.cx/data/games/58168/3св1_8644.jpg"));
    list.add(new Bonus("В1Север", "в1ГП19", "", "г1", "http://d1.endata.cx/data/games/58168/3сг1_7523.jpg"));
    list.add(new Bonus("Г1Север", "г1А17", "", "д1", "http://d1.endata.cx/data/games/58168/3сд1_974324.jpg"));
    list.add(new Bonus("Д1Север", "д1Ч78", "", "е1", "http://d1.endata.cx/data/games/58168/3се1_85725.jpg"));
    list.add(new Bonus("Е1Север", "е1Д33", "", "ж1", "http://d1.endata.cx/data/games/58168/3сж1_2678423.jpg"));
    list.add(new Bonus("Ж1Север", "ж1ПЛ45", "", "з1", "http://d1.endata.cx/data/games/58168/3сз1_143564.jpg"));
    list.add(new Bonus("З1Север", "з1П64", "", "и1", "http://d1.endata.cx/data/games/58168/3си1_134854.jpg"));
    list.add(new Bonus("И1Север", "и1В13", "", "к1", "http://d1.endata.cx/data/games/58168/3ск1_98765.jpg"));
    list.add(new Bonus("К1Север", "к1ПВо99", "", "а2", "http://d1.endata.cx/data/games/58168/3са2_53114.jpg"));
    list.add(new Bonus("А2Север", "а2нп78", "", "б2", "http://d1.endata.cx/data/games/58168/3сб2_5446.jpg"));
    list.add(new Bonus("Б2Север", "б2Па74", "", "в2", "http://d1.endata.cx/data/games/58168/3св2_76535.jpg"));
    list.add(new Bonus("В2Север", "в2У27", "", "г2", "http://d1.endata.cx/data/games/58168/3сг2_95525.jpg"));
    list.add(new Bonus("Г2Север", "г2Пе38", "", "д2", "http://d1.endata.cx/data/games/58168/3сд2_9652.jpg"));
    list.add(new Bonus("Д2Север", "д2О91", "", "е2", "http://d1.endata.cx/data/games/58168/3се2_098.jpg"));
    list.add(new Bonus("Е2Север", "е2ЧР42", "", "ж2", "http://d1.endata.cx/data/games/58168/3сж2_521.jpg"));
    list.add(new Bonus("Ж2Север", "ж2ПП31", "", "з2", "http://d1.endata.cx/data/games/58168/3сз2_832432.jpg"));
    list.add(new Bonus("З2Север", "з2Г18", "", "и2", "http://d1.endata.cx/data/games/58168/3си2_423075.jpg"));
    list.add(new Bonus("И2Север", "и2Пи59", "", "к2", "http://d1.endata.cx/data/games/58168/3ск2_86532.jpg"));
    list.add(new Bonus("К2Север", "к2СП56", "", "б3", "http://d1.endata.cx/data/games/58168/3сб3_85.jpg"));
    list.add(new Bonus("А3Север", "", "", "", ""));
    list.add(new Bonus("Б3Север", "б3В73", "", "ж3", "http://d1.endata.cx/data/games/58168/3сж3_62788.jpg"));
    list.add(new Bonus("В3Север", "", "", "", ""));
    list.add(new Bonus("Г3Север", "", "", "", ""));
    list.add(new Bonus("Д3Север", "", "", "", ""));
    list.add(new Bonus("Е3Север", "", "", "", ""));
    list.add(new Bonus("Ж3Север", "ж3М11", "", "з3", "http://d1.endata.cx/data/games/58168/3сз3_235474.jpg"));
    list.add(new Bonus("З3Север", "з3ГД95", "", "и3", "http://d1.endata.cx/data/games/58168/3си3_742853.jpg"));
    list.add(new Bonus("И3Север", "и3П58", "", "к3", "http://d1.endata.cx/data/games/58168/3ск3_7644.jpg"));
    list.add(new Bonus("К3Север", "к3ПАН77", "", "к4", "http://d1.endata.cx/data/games/58168/3ск4_856473642.jpg"));
    list.add(new Bonus("А4Север", "", "", "", ""));
    list.add(new Bonus("Б4Север", "", "", "", ""));
    list.add(new Bonus("В4Север", "", "", "", ""));
    list.add(new Bonus("Г4Север", "", "", "", ""));
    list.add(new Bonus("Д4Север", "", "", "", ""));
    list.add(new Bonus("Е4Север", "", "", "", ""));
    list.add(new Bonus("Ж4Север", "", "", "", ""));
    list.add(new Bonus("З4Север", "", "", "", ""));
    list.add(new Bonus("И4Север", "", "", "", ""));
    list.add(new Bonus("К4Север", "к4С88", "", "а5", "http://d1.endata.cx/data/games/58168/3са5_65313.jpg"));
    list.add(new Bonus("А5Север", "а5Ч59", "", "б5", "http://d1.endata.cx/data/games/58168/3сб5_7543.jpg"));
    list.add(new Bonus("Б5Север", "б5КП47", "", "в5", "http://d1.endata.cx/data/games/58168/3св5_9842.jpg"));
    list.add(new Bonus("В5Север", "в5Сп95", "", "г5", "http://d1.endata.cx/data/games/58168/3сг5_732.jpg"));
    list.add(new Bonus("Г5Север", "г5КО32", "", "е5", "http://d1.endata.cx/data/games/58168/3се5_53225.jpg"));
    list.add(new Bonus("Д5Север", "", "", "", ""));
    list.add(new Bonus("Е5Север", "е5СД25", "", "з5", "http://d1.endata.cx/data/games/58168/3сз5_853.jpg"));
    list.add(new Bonus("Ж5Север", "", "", "", ""));
    list.add(new Bonus("З5Север", "з5А78", "", "к5", "http://d1.endata.cx/data/games/58168/3ск5_85642.jpg"));
    list.add(new Bonus("И5Север", "", "", "", ""));
    list.add(new Bonus("К5Север", "к5Са63", "", "", ""));
    list.add(new Bonus("А1Юг", "а1ПВо99", "", "б1", "http://d1.endata.cx/data/games/58168/3юб1_97236.jpg"));
    list.add(new Bonus("Б1Юг", "б1А13", "", "в1", "http://d1.endata.cx/data/games/58168/3юв1_8316.jpg"));
    list.add(new Bonus("В1Юг", "в1ТИ81", "", "г1", "http://d1.endata.cx/data/games/58168/3юг1_7211.jpg"));
    list.add(new Bonus("Г1Юг", "г1В53", "", "д1", "http://d1.endata.cx/data/games/58168/3юд1_964.jpg"));
    list.add(new Bonus("Д1Юг", "д1КЗ66", "", "е1", "http://d1.endata.cx/data/games/58168/3юе1_836.jpg"));
    list.add(new Bonus("Е1Юг", "е1Б35", "", "ж1", "http://d1.endata.cx/data/games/58168/3юж1_9732.jpg"));
    list.add(new Bonus("Ж1Юг", "ж1ПВе27", "", "з1", "http://d1.endata.cx/data/games/58168/3юз1_836.jpg"));
    list.add(new Bonus("З1Юг", "з1ЛП22", "", "и1", "http://d1.endata.cx/data/games/58168/3юи1_377.jpg"));
    list.add(new Bonus("И1Юг", "и1Н79", "", "к1", "http://d1.endata.cx/data/games/58168/3юк1_93717.jpg"));
    list.add(new Bonus("К1Юг", "к1П64", "", "а2", "http://d1.endata.cx/data/games/58168/3юа2_7362.jpg"));
    list.add(new Bonus("А2Юг", "а2СП56", "", "б2", "http://d1.endata.cx/data/games/58168/3юб2_83629.jpg"));
    list.add(new Bonus("Б2Юг", "б2Ф45", "", "в2", "http://d1.endata.cx/data/games/58168/3юв2_82631.jpg"));
    list.add(new Bonus("В2Юг", "в2М76", "", "г2", "http://d1.endata.cx/data/games/58168/3юг2_81737.jpg"));
    list.add(new Bonus("Г2Юг", "г2Э54", "", "д2", "http://d1.endata.cx/data/games/58168/3юд2_9742.jpg"));
    list.add(new Bonus("Д2Юг", "д2ТИ57", "", "е2", "http://d1.endata.cx/data/games/58168/3юе2_9237.jpg"));
    list.add(new Bonus("Е2Юг", "е2К32", "", "ж2", "http://d1.endata.cx/data/games/58168/3юж2_83261.jpg"));
    list.add(new Bonus("Ж2Юг", "ж2ПП62", "", "з2", "http://d1.endata.cx/data/games/58168/3юз2_31763.jpg"));
    list.add(new Bonus("З2Юг", "з2З11", "", "к2", "http://d1.endata.cx/data/games/58168/3юк2_8271.jpg"));
    list.add(new Bonus("И2Юг", "", "", "", ""));
    list.add(new Bonus("К2Юг", "к2МВ99", "", "а3", "http://d1.endata.cx/data/games/58168/3юа3_73629.jpg"));
    list.add(new Bonus("А3Юг", "а3ПАН77", "", "б3", "http://d1.endata.cx/data/games/58168/3юб3_827.jpg"));
    list.add(new Bonus("Б3Юг", "б3Л81", "", "в3", "http://d1.endata.cx/data/games/58168/3юв3_7631.jpg"));
    list.add(new Bonus("В3Юг", "в3Е74", "", "г3", "http://d1.endata.cx/data/games/58168/3юг3_6318.jpg"));
    list.add(new Bonus("Г3Юг", "г3О95", "", "д3", "http://d1.endata.cx/data/games/58168/3юд3_8613.jpg"));
    list.add(new Bonus("Д3Юг", "Д3П41", "", "к3", "http://d1.endata.cx/data/games/58168/3юк3_2731.jpg"));
    list.add(new Bonus("Е3Юг", "", "", "", ""));
    list.add(new Bonus("Ж3Юг", "", "", "", ""));
    list.add(new Bonus("З3Юг", "", "", "", ""));
    list.add(new Bonus("И3Юг", "", "", "", ""));
    list.add(new Bonus("К3Юг", "К3Р54", "", "а4", "http://d1.endata.cx/data/games/58168/3юа4_9361.jpg"));
    list.add(new Bonus("А4Юг", "А4С88", "", "б4", "http://d1.endata.cx/data/games/58168/3юб4_863.jpg"));
    list.add(new Bonus("Б4Юг", "б4ПАН57", "", "в4", "http://d1.endata.cx/data/games/58168/3юв4_8631.jpg"));
    list.add(new Bonus("В4Юг", "в4Л78", "", "д4", "http://d1.endata.cx/data/games/58168/3юд4_97242.jpg"));
    list.add(new Bonus("Г4Юг", "", "", "", ""));
    list.add(new Bonus("Д4Юг", "д4ПБ76", "", "е4", "http://d1.endata.cx/data/games/58168/3юе4_8246.jpg"));
    list.add(new Bonus("Е4Юг", "е4ЛП21", "", "ж4", "http://d1.endata.cx/data/games/58168/3юж4_973.jpg"));
    list.add(new Bonus("Ж4Юг", "ж4Н92", "", "з4", "http://d1.endata.cx/data/games/58168/3юз4_94211.jpg"));
    list.add(new Bonus("З4Юг", "з4УД85", "", "к4", "http://d1.endata.cx/data/games/58168/3юк4_974.jpg"));
    list.add(new Bonus("И4Юг", "", "", "", ""));
    list.add(new Bonus("К4Юг", "к4Д89", "", "а5", "http://d1.endata.cx/data/games/58168/3юа5_8342.jpg"));
    list.add(new Bonus("А5Юг", "а5Са63", "", "б5", "http://d1.endata.cx/data/games/58168/3юб5_83221.jpg"));
    list.add(new Bonus("Б5Юг", "б5В64", "", "в5", "http://d1.endata.cx/data/games/58168/3юв5_8163.jpg"));
    list.add(new Bonus("В5Юг", "в5З75", "", "е5", "http://d1.endata.cx/data/games/58168/3юе5_8341.jpg"));
    list.add(new Bonus("Г5Юг", "", "", "", ""));
    list.add(new Bonus("Д5Юг", "", "", "", ""));
    list.add(new Bonus("Е5Юг", "е5Б42", "", "ж5", "http://d1.endata.cx/data/games/58168/3юж5_9274.jpg"));
    list.add(new Bonus("Ж5Юг", "ж5ОК29", "", "и5", "http://d1.endata.cx/data/games/58168/3юи5_8632.jpg"));
    list.add(new Bonus("З5Юг", "", "", "", ""));
    list.add(new Bonus("И5Юг", "и5М46", "", "", ""));
    list.add(new Bonus("К5Юг", "", "", "", ""));

    for (Bonus bonus : list) {
      String imgLink = "";
      String linkName = bonus.getLinkName();
      if (!linkName.equals("")) {
        imgLink = "<a href=\"" + bonus.getLink() + "\" target=\"_blank\">" + linkName + "</a>";
      }
      bonusConstructor.addBonus(bonus.getName(), bonus.getCode(), imgLink);
    }
  }

  @Step
  public void deleteAllBonus() {
    while (levelPage.hasBonus()) {
      PageSwitcher pageSwitcher = new PageSwitcher(levelPage.getFirstBonusLink(), driver).invoke();
      driver.switchTo().window(pageSwitcher.getNewWindow());
      bonusPage.getDeleteBonusButton().click();
      driver.switchTo().alert().accept();

//      driver.close();
      driver.switchTo().window(pageSwitcher.getOriginalWindow());

      try {
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      driver.navigate().refresh();
      waitElement.wait(levelPage.getMainContent(), 5);
    }
  }

  @Step
  public void goToLevel(int level) {
    String zero = "";
    if (level <= 10) {
      zero = "0";
    }
    String number = zero + (level - 1);
    editGamePage.goToLevel(number).click();
    waitElement.wait(levelPage.getMainContent(), 5);
  }

  @Step
  public void constructAllBonusList() {
    List<Bonus> list = new ArrayList<>();

    list.add(new Bonus("Север Bonus Unlock", new String[]{"шеншин"}, "Фотопоиск: "));
    list.add(new Bonus("1", "страннек55", ""));
    list.add(new Bonus("2", "фастбигланч17", ""));
    list.add(new Bonus("3", "прегги55", ""));
    list.add(new Bonus("4", "ниибусь30", ""));
    list.add(new Bonus("5", "оввеен404", ""));

    list.add(new Bonus("Восток Bonus Unlock", new String[]{""}, "Коды отписаны по меткам 413 LDR 1-4,bonus"));
    list.add(new Bonus("1", "факирыч36", ""));
    list.add(new Bonus("2", "пион77", ""));
    list.add(new Bonus("3", "хукфай84", ""));
    list.add(new Bonus("4", "шаваед13", ""));
    list.add(new Bonus("5", "неверь45", ""));

    list.add(new Bonus("Юг Bonus Unlock", new String[]{""}, "Коды отписаны по меткам DZR NN 1-5"));
    list.add(new Bonus("1", "дронь11", ""));
    list.add(new Bonus("2", "байкальскирыб", ""));
    list.add(new Bonus("3", "крайтер92", ""));
    list.add(new Bonus("4", "макс11", ""));
    list.add(new Bonus("5", "мимимибус74", ""));

    for (Bonus bonus : list) {
      String code = bonus.getCode();
      if (code != null) {
        bonusConstructor.addBonus(bonus.getName(), code, bonus.getHint());
      } else {
        bonusConstructor.addBonus(bonus.getName(), bonus.getCodeArray(), bonus.getHint());
      }
    }
  }

  @Step
  public void constructDemoBonusList() {
    for (Bonus bonus : bonusList) {
      bonusConstructor.addBonus(bonus.getName(), bonus.getTask(), bonus.getCodeArray(), bonus.getHint());
    }
  }

  @Step
  public void copyLevel() {
    fillTextLevel();
    fillSectors();
    fillBonusList();
  }

  @Step
  public void addTask() {
    PageSwitcher pageSwitcher = new PageSwitcher(levelPage.getAddTaskButton(), driver).invoke();
    driver.switchTo().window(pageSwitcher.getNewWindow());

    taskPage.getEditText().sendKeys(textLevel);
    taskPage.getAddButton().click();

    driver.close();
    driver.switchTo().window(pageSwitcher.getOriginalWindow());
  }

  @Step
  public void addSectors() {
    levelPage.getShowAnswersButton().click();

    for (Sector sector : sectors) {
      levelPage.getAddSectorLink().click();
      levelPage.getSectorName().sendKeys(sector.getName());
      List<Answer> answers = sector.getAnswers();
      for (int i = 0; i < answers.size(); i++) {
        levelPage.getNextAnswer(i).sendKeys(answers.get(i).getAnswer());
      }
      levelPage.getSaveSector().click();
    }
  }

  private void fillTextLevel() {
    PageSwitcher pageSwitcher = new PageSwitcher(levelPage.getTaskLink(), driver).invoke();
    driver.switchTo().window(pageSwitcher.getNewWindow());
    taskPage.getEditButton().click();
    textLevel = taskPage.getText().getText();
    driver.close();
    driver.switchTo().window(pageSwitcher.getOriginalWindow());
  }

  private void fillBonusList() {
    for (HtmlElement bonus : levelPage.getBonusLinkList()) {
      PageSwitcher pageSwitcher = new PageSwitcher(bonus, driver).invoke();
      driver.switchTo().window(pageSwitcher.getNewWindow());

      bonusPage.getEditButton().click();
      waitElement.wait(bonusPage.getName(), 3);
      String name = bonusPage.getName().getAttribute("value");
      bonusList.add(new Bonus(
          name,
          bonusPage.getTask().getText(),
          getAnswerArray(),
          bonusPage.getTxtHelp().getText()
      ));

      driver.close();
      driver.switchTo().window(pageSwitcher.getOriginalWindow());
    }
  }

  private void fillSectors() {
    levelPage.getShowAnswersButton().click();

    List<HtmlElement> sectorsList = levelPage.getSectorsList();
    for (HtmlElement sector : sectorsList) {
      String name = sector.findElement(By.xpath("span")).getText();
      String[] idArray = sector.getAttribute("id").split("_");
      String id = idArray[idArray.length - 1];
      List<Answer> answers = new ArrayList<>();
      for (WebElement answer : levelPage.getAnswersFromSector(id)) {
        answers.add(new Answer(answer.getText()));
      }
      sectors.add(new Sector(name, answers));
    }
  }

  private String[] getAnswerArray() {
    List<String> result = new ArrayList<>();
    for (HtmlElement answer : bonusPage.getAnswerList()) {
      String value = answer.getAttribute("value");
      if (!value.equals("")) {
        result.add(value);
      }
    }
    return result.toArray(new String[result.size()]);
  }
}
