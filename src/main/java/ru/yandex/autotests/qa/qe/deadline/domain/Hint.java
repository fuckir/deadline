package ru.yandex.autotests.qa.qe.deadline.domain;

import java.util.Objects;

/**
 * @author dmitrys
 * @since 22.05.2018
 */
public class Hint {

  private final int number;
  private final int minutes;
  private final int seconds;
  private final String prompt;

  public Hint(int number, int minutes, int seconds, String prompt) {
    this.number = number;
    this.minutes = minutes;
    this.seconds = seconds;
    this.prompt = prompt;
  }

  public int getNumber() {
    return number;
  }

  public int getMinutes() {
    return minutes;
  }

  public int getSeconds() {
    return seconds;
  }

  public String getPrompt() {
    return prompt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Hint hint = (Hint) o;
    return number == hint.number &&
           minutes == hint.minutes &&
           seconds == hint.seconds &&
           Objects.equals(prompt, hint.prompt);
  }

  @Override
  public int hashCode() {

    return Objects.hash(number, minutes, seconds, prompt);
  }

  @Override
  public String toString() {
    return "Hint{" +
           "number=" + number +
           ", minutes=" + minutes +
           ", seconds=" + seconds +
           ", prompt='" + prompt + '\'' +
           '}';
  }
}
