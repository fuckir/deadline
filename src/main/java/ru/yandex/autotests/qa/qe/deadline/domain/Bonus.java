package ru.yandex.autotests.qa.qe.deadline.domain;

import java.util.List;

/**
 * Created by dmitrys
 * 20.04.16.
 */
public class Bonus {

  private final String name;
  private final String task;
  private final String code;
  private final String[] codeArray;
  private final String hint;
  private final String linkName;
  private final String link;
  private final int delayHours;
  private final int delayMinutes;
  private final int delaySeconds;
  private final int validHours;
  private final int validMinutes;
  private final int validSeconds;
  private final int bonusHours;
  private final int bonusMinutes;
  private final int bonusSeconds;
  private final List<Integer> levelAvailableList;

  public Bonus(String name, String code, String hint) {
    this.name = name;
    this.task = null;
    this.code = code;
    this.codeArray = null;
    this.hint = hint;
    this.linkName = null;
    this.link = null;
    delayHours = 0;
    delayMinutes = 0;
    delaySeconds = 0;
    validHours = 0;
    validMinutes = 0;
    validSeconds = 0;
    bonusHours = 0;
    bonusMinutes = 0;
    bonusSeconds = 0;
    levelAvailableList = null;
  }

  public Bonus(String name, String task, String[] codeArray, String hint) {
    this.name = name;
    this.task = task;
    this.code = null;
    this.codeArray = codeArray;
    this.hint = hint;
    this.linkName = null;
    this.link = null;
    delayHours = 0;
    delayMinutes = 0;
    delaySeconds = 0;
    validHours = 0;
    validMinutes = 0;
    validSeconds = 0;
    bonusHours = 0;
    bonusMinutes = 0;
    bonusSeconds = 0;
    levelAvailableList = null;
  }

  public Bonus(String name, String code, String hint, String linkName, String link) {
    this.name = name;
    this.task = null;
    this.code = code;
    this.codeArray = null;
    this.hint = hint;
    this.linkName = linkName;
    this.link = link;
    delayHours = 0;
    delayMinutes = 0;
    delaySeconds = 0;
    validHours = 0;
    validMinutes = 0;
    validSeconds = 0;
    bonusHours = 0;
    bonusMinutes = 0;
    bonusSeconds = 0;
    levelAvailableList = null;
  }

  public Bonus(String name, String[] codeArray, String hint) {
    this.name = name;
    this.task = null;
    this.code = null;
    this.codeArray = codeArray;
    this.hint = hint;
    this.linkName = null;
    this.link = null;
    delayHours = 0;
    delayMinutes = 0;
    delaySeconds = 0;
    validHours = 0;
    validMinutes = 0;
    validSeconds = 0;
    bonusHours = 0;
    bonusMinutes = 0;
    bonusSeconds = 0;
    levelAvailableList = null;
  }

  public Bonus(String name, String task, String code, int delayMinutes, int validMinutes, int bonusMinutes, int bonusSeconds,
               String hint)
  {
    this.name = name;
    this.task = task;
    this.code = code;
    this.delayMinutes = delayMinutes;
    this.validMinutes = validMinutes;
    this.bonusMinutes = bonusMinutes;
    this.bonusSeconds = bonusSeconds;
    this.hint = hint;
    codeArray = null;
    linkName = null;
    link = null;
    delayHours = 0;
    delaySeconds = 0;
    validHours = 0;
    validSeconds = 0;
    bonusHours = 0;
    levelAvailableList = null;
  }

  public Bonus(String name, String task, String[] codeArray, int delayMinutes, int delaySeconds, int validMinutes, int validSeconds,
               int bonusMinutes, int bonusSeconds, String hint, List<Integer> levelAvailableList)
  {
    this.name = name;
    this.task = task;
    this.code = null;
    this.delayMinutes = delayMinutes;
    this.validMinutes = validMinutes;
    this.bonusMinutes = bonusMinutes;
    this.bonusSeconds = bonusSeconds;
    this.hint = hint;
    this.codeArray = codeArray;
    linkName = null;
    link = null;
    delayHours = 0;
    this.delaySeconds = delaySeconds;
    validHours = 0;
    this.validSeconds = validSeconds;
    bonusHours = 0;
    this.levelAvailableList = levelAvailableList;
  }

  public String getName() {
    return name;
  }

  public String getTask() {
    return task;
  }

  public String getCode() {
    return code;
  }

  public String getHint() {
    return hint;
  }

  public String getLinkName() {
    return linkName;
  }

  public String getLink() {
    return link;
  }

  public String[] getCodeArray() {
    return codeArray;
  }

  public int getDelayHours() {
    return delayHours;
  }

  public int getDelayMinutes() {
    return delayMinutes;
  }

  public int getDelaySeconds() {
    return delaySeconds;
  }

  public int getValidHours() {
    return validHours;
  }

  public int getValidMinutes() {
    return validMinutes;
  }

  public int getValidSeconds() {
    return validSeconds;
  }

  public int getBonusHours() {
    return bonusHours;
  }

  public int getBonusMinutes() {
    return bonusMinutes;
  }

  public int getBonusSeconds() {
    return bonusSeconds;
  }

  public List<Integer> getLevelAvailableList() {
    return levelAvailableList;
  }
}
