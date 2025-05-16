package com.sudoku.model;

public class Space {

    private Integer actualValue;
    private final int expectedValue;
    private final boolean fixed;

    public Space(int expectedValue, boolean fixed) {
        this.expectedValue = expectedValue;
        this.fixed = fixed;

        if (this.fixed) {
            this.actualValue = expectedValue;
        }
    }

    public Integer getActualValue() {
        return actualValue;
    }

    public int getExpectedValue() {
        return expectedValue;
    }

    public boolean isFixed() {
        return fixed;
    }

    public boolean setActualValue(Integer actualValue) {
        if (!isFixed()) {
            this.actualValue = actualValue;
            return true;
        } else {
            return false;
        }
    }

    public boolean clearActualValue() {
        return setActualValue(null);
    }
}
