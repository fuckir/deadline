package ru.yandex.autotests.qa.qe.deadline.domain;

/**
 * Created by dmitrys
 * 20.04.16.
 */
public class Bonus {

    private final String name;
    private final String code;
    private final String hint;

    public Bonus(String name, String code, String hint) {
        this.name = name;
        this.code = code;
        this.hint = hint;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getHint() {
        return hint;
    }
}
