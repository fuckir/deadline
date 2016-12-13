package ru.yandex.autotests.qa.qe.deadline.steps;

import org.openqa.selenium.WebDriver;
import ru.yandex.autotests.qa.qe.deadline.domain.BonusConstructor;
import ru.yandex.autotests.qa.qe.deadline.pages.*;
import ru.yandex.autotests.qa.qe.deadline.utils.PageSwitcher;
import ru.yandex.autotests.qa.qe.deadline.utils.WaitElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

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
    private BonusConstructor bonusConstructor = new BonusConstructor();

    public Steps(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        editGamePage = new EditGamePage(driver);
        levelPage = new LevelPage(driver);
        waitElement = new WaitElement(driver);
        editPenaltyPromptPage = new EditPenaltyPromptPage(driver);
        bonusPage = new BonusPage(driver);
    }

    @Step
    public void waitMainContent() {
        waitElement.wait(mainPage.getMainContent(), 5);
    }

    @Step
    public void login() {
        mainPage.getLoginLink().click();
        loginPage.getLogin().sendKeys("FuckIR");
        loginPage.getPassword().sendKeys("test");
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
    public void addPenaltyPrompt() {
        editGamePage.goToLevel("3").click();
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
    public void addBonus(int level) {
        String zero = "";
        if (level < 10) {
            zero = "0";
        }
        editGamePage.goToLevel(zero + (level - 1)).click();
        waitElement.wait(levelPage.getMainContent(), 5);

        int size = bonusConstructor.getBonuses().size();
        for (int i = 0; i < size; i++) {
            PageSwitcher pageSwitcher = new PageSwitcher(levelPage.getAddBonusButton(), driver).invoke();
            driver.switchTo().window(pageSwitcher.getNewWindow());

            bonusPage.getName().sendKeys(bonusConstructor.getBonuses().get(i).getName());

            bonusPage.getFirstAnswer().sendKeys(bonusConstructor.getBonuses().get(i).getCode());

            bonusPage.getCurrentLevel(level).click();

//            bonusPage.getChkDelay().click(); //Задержать время появления
//            bonusPage.getTxtDelayMinutes().clear();
//            bonusPage.getTxtDelayMinutes().sendKeys("45");
//
//            bonusPage.getChkRelativeLimit().click(); //Ограничить время выполнения:
//            bonusPage.getTxtValidMinutes().clear();
//            bonusPage.getTxtValidMinutes().sendKeys("30");

            bonusPage.getTxtHelp().sendKeys(bonusConstructor.getBonuses().get(i).getHint());

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

    public void constructBonusList() {
        bonusConstructor.addBonus("А1", "А1кв1", "кв1");
        bonusConstructor.addBonus("А2", "А2Бофорс", "Бофорс");
        bonusConstructor.addBonus("А3", "А3QF6", "QF6");
        bonusConstructor.addBonus("А4", "А4Т28", "Т28");
        bonusConstructor.addBonus("А5", "А5Dewoitine27", "Dewoitine27");
        bonusConstructor.addBonus("А6", "А6STEN", "STEN");
        bonusConstructor.addBonus("А7", "А7Саратога", "Саратога");
        bonusConstructor.addBonus("А8", "А8Curtiss", "Curtiss");
        bonusConstructor.addBonus("А9", "А9Гнейзенау", "Гнейзенау");
        bonusConstructor.addBonus("Б1", "Б1И153", "И153");
        bonusConstructor.addBonus("Б2", "Б2ЛаГГ3", "ЛаГГ3");
        bonusConstructor.addBonus("Б3", "Б3KwK39", "KwK39");
        bonusConstructor.addBonus("Б4", "Б4Fury", "Fury");
        bonusConstructor.addBonus("Б5", "Б5H35", "H35");
        bonusConstructor.addBonus("Б6", "Б6ИК2", "ИК2");
        bonusConstructor.addBonus("Б7", "Б7т34", "т34");
        bonusConstructor.addBonus("Б8", "Б8Matilda2", "Matilda2");
        bonusConstructor.addBonus("Б9", "Б9MAB", "MAB");
        bonusConstructor.addBonus("В1", "В1у2", "у2");
        bonusConstructor.addBonus("В2", "В2M114", "M114");
        bonusConstructor.addBonus("В3", "В3fox", "fox");
        bonusConstructor.addBonus("В4", "В4Jagdpanzer38", "Jagdpanzer38");
        bonusConstructor.addBonus("В5", "В5Нельсон", "Нельсон");
        bonusConstructor.addBonus("В6", "В6су100", "су100");
        bonusConstructor.addBonus("В7", "В7Blenheim", "Blenheim");
        bonusConstructor.addBonus("В8", "В8тирпиц", "тирпиц");
        bonusConstructor.addBonus("В9", "В9оклахома", "оклахома");
        bonusConstructor.addBonus("Г1", "Г1Як9", "Як9");
        bonusConstructor.addBonus("Г2", "Г2Lublin", "Lublin");
        bonusConstructor.addBonus("Г3", "Г3Тайфун", "Тайфун");
        bonusConstructor.addBonus("Г4", "Г4B24", "B24");
        bonusConstructor.addBonus("Г5", "Г5Виккерс", "Виккерс");
        bonusConstructor.addBonus("Г6", "Г6TKS", "TKS");
        bonusConstructor.addBonus("Г7", "Г7FlaK43", "FlaK43");
        bonusConstructor.addBonus("Г8", "Г8NC31", "NC31");
        bonusConstructor.addBonus("Г9", "Г9Ла5", "Ла5");
        bonusConstructor.addBonus("Д1", "Д1amc35", "amc35");
        bonusConstructor.addBonus("Д2", "Д2Эрликон", "Эрликон");
        bonusConstructor.addBonus("Д3", "Д3Дойчланд", "Дойчланд");
        bonusConstructor.addBonus("Д4", "Д4F4U", "F4U");
        bonusConstructor.addBonus("Д5", "Д5MG34", "MG34");
        bonusConstructor.addBonus("Д6", "Д6HMSUnicorn", "HMSUnicorn");
        bonusConstructor.addBonus("Д7", "Д7БТ7", "БТ7");
        bonusConstructor.addBonus("Д8", "Д8Хорнет", "Хорнет");
        bonusConstructor.addBonus("Д9", "Д9PZL24", "PZL24");
        bonusConstructor.addBonus("Е1", "Е1ДБ3", "ДБ3");
        bonusConstructor.addBonus("Е2", "Е2Hurricane", "Hurricane");
        bonusConstructor.addBonus("Е3", "Е3MAS36", "MAS36");
        bonusConstructor.addBonus("Е4", "Е4Йорктаун", "Йорктаун");
        bonusConstructor.addBonus("Е5", "Е5P40", "P40");
        bonusConstructor.addBonus("Е6", "Е6StuH42", "StuH42");
        bonusConstructor.addBonus("Е7", "Е7Fokker", "Fokker");
        bonusConstructor.addBonus("Е8", "Е8Vickers", "Vickers");
        bonusConstructor.addBonus("Е9", "Е9невада", "невада");
        bonusConstructor.addBonus("Ж1", "Ж1Mauser98", "Mauser98");
        bonusConstructor.addBonus("Ж2", "Ж2F6F", "F6F");
        bonusConstructor.addBonus("Ж3", "Ж3Vanguard", "Vanguard");
        bonusConstructor.addBonus("Ж4", "Ж4тигр6", "тигр6");
        bonusConstructor.addBonus("Ж5", "Ж5Дюнкерк", "Дюнкерк");
        bonusConstructor.addBonus("Ж6", "Ж6Dewoitine", "Dewoitine");
        bonusConstructor.addBonus("Ж7", "Ж7Lockheed", "Lockheed");
        bonusConstructor.addBonus("Ж8", "Ж8Бисмарк", "Бисмарк");
        bonusConstructor.addBonus("Ж9", "Ж9BESA", "BESA");
        bonusConstructor.addBonus("З1", "З1Bren", "Bren");
        bonusConstructor.addBonus("З2", "З2FlaK18", "FlaK18");
        bonusConstructor.addBonus("З3", "З3Шлезиен", "Шлезиен");
        bonusConstructor.addBonus("З4", "З4Lancer", "Lancer");
        bonusConstructor.addBonus("З5", "З5ф22", "ф22");
        bonusConstructor.addBonus("З6", "З6FT17", "FT17");
        bonusConstructor.addBonus("З7", "З7зис3", "зис3");
        bonusConstructor.addBonus("З8", "З8Superfortress", "Superfortress");
        bonusConstructor.addBonus("З9", "З9S35", "S35");
        bonusConstructor.addBonus("И1", "И1Аризона", "Аризона");
        bonusConstructor.addBonus("И2", "И2Ла7", "Ла7");
        bonusConstructor.addBonus("И3", "И3Blenheim2", "Blenheim2");
        bonusConstructor.addBonus("И4", "И4Ринуан", "Ринуан");
        bonusConstructor.addBonus("И5", "И5Firefly2", "Firefly2");
        bonusConstructor.addBonus("И6", "И6JunkersJu88", "JunkersJu88");
        bonusConstructor.addBonus("И7", "И7Potez63", "Potez63");
        bonusConstructor.addBonus("И8", "И8Спитфайр", "Спитфайр");
        bonusConstructor.addBonus("И9", "И9f1", "f1");
    }
}
