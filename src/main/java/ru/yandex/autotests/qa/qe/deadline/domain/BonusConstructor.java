package ru.yandex.autotests.qa.qe.deadline.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitrys
 * 20.04.16.
 */
public class BonusConstructor {
  private final List<Bonus> bonuses;

  public BonusConstructor() {
    this.bonuses = new ArrayList<>();
  }

  public List<Bonus> getBonuses() {
    return bonuses;
  }

  public void addBonus(String name, String code, String hint) {
    this.bonuses.add(new Bonus(name, code, hint));
  }

  public void addBonus(String name, String[] codeArray, String hint) {
    this.bonuses.add(new Bonus(name, codeArray, hint));
  }

  public void addBonus(String name, String task, String[] codeArray, String hint) {
    this.bonuses.add(new Bonus(name, task, codeArray, hint));
  }

}
