package ru.yandex.autotests.qa.qe.deadline.domain;

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

  public Bonus(String name, String code, String hint) {
    this.name = name;
    this.task = null;
    this.code = code;
    this.codeArray = null;
    this.hint = hint;
    this.linkName = null;
    this.link = null;
  }

  public Bonus(String name, String task, String[] codeArray, String hint) {
    this.name = name;
    this.task = task;
    this.code = null;
    this.codeArray = codeArray;
    this.hint = hint;
    this.linkName = null;
    this.link = null;
  }

  public Bonus(String name, String code, String hint, String linkName, String link) {
    this.name = name;
    this.task = null;
    this.code = code;
    this.codeArray = null;
    this.hint = hint;
    this.linkName = linkName;
    this.link = link;
  }

  public Bonus(String name, String[] codeArray, String hint) {
    this.name = name;
    this.task = null;
    this.code = null;
    this.codeArray = codeArray;
    this.hint = hint;
    this.linkName = null;
    this.link = null;
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
}
