package ru.yandex.autotests.qa.qe.deadline.domain;

/**
 * Created by dmitrys
 * 13.04.17.
 */
public class Answer {
  private String answer;
  private String additionalValue;

  public Answer(String answer, String additionalValue) {
    this.answer = answer;
    this.additionalValue = additionalValue;
  }

  public Answer(String answer) {
    this.answer = answer;
    additionalValue = null;
  }

  public String getAnswer() {
    return answer;
  }

  public String getAdditionalValue() {
    return additionalValue;
  }
}
