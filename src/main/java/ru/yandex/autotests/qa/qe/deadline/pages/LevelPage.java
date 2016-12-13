package ru.yandex.autotests.qa.qe.deadline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by dmitrys
 * 27.10.15.
 */
public class LevelPage {

    public LevelPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
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

    @Name("Add Bonus")
    @FindBy(xpath = "//a[img[@name='ctl06_ctl00_btnBonusAdd']]")
    private HtmlElement addBonusButton;

    public HtmlElement getMainContent() {
        return mainContent;
    }

    public HtmlElement getLevelName() {
        return levelName;
    }

    public HtmlElement getAddPenaltyPrompt() {
        return addPenaltyPrompt;
    }

    public HtmlElement getAddBonusButton() {
        return addBonusButton;
    }
}
