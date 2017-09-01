package ru.yandex.autotests.qa.qe.deadline.domain;

import java.util.List;

/**
 * @author dmitrys
 * @since 31.08.17
 */
public class Sector {
  private String name;
  private List<Answer> answers;

  public Sector(String name, List<Answer> answers) {
    this.name = name;
    this.answers = answers;
  }

  public String getName() {
    return name;
  }

  public List<Answer> getAnswers() {
    return answers;
  }
}
