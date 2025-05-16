package com.sudoku.model;

import java.util.Collection;
import java.util.List;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Board {

    private final List<List<Space>> spaces;

    public Board(List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    public GameStatusEnum getStatus() {
        if (spaces.stream().
                flatMap(Collection::stream)
                .noneMatch(s -> {
                    return !s.isFixed() && nonNull(s.getActualValue());
                })) {
            return GameStatusEnum.NON_STARTED;
        }

        return spaces.stream()
                .flatMap(Collection::stream)
                .anyMatch(s -> isNull(s.getActualValue())) ? GameStatusEnum.INCOMPLETE : GameStatusEnum.COMPLETE;
    }

    private boolean hasError() {
        if (getStatus() == GameStatusEnum.NON_STARTED) {
            return false;
        }

        return spaces.stream().
                flatMap(Collection::stream).
                anyMatch(s -> nonNull(s.getActualValue()) && !s.getActualValue().equals(s.getExpectedValue()));
    }

    public boolean updateSpace(int column, int row, int value) {
        return spaces.get(column).get(row).setActualValue(value);
    }

    public boolean clearSpace(int column, int row) {
        return spaces.get(column).get(row).clearActualValue();
    }

    public void resetBoard() {
        spaces.forEach(column -> column.forEach(Space::clearActualValue));
    }

    public boolean gameIsFinished() {
        return !this.hasError() && this.getStatus() == GameStatusEnum.COMPLETE;
    }
}
