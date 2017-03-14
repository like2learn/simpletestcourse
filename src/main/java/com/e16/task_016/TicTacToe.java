package com.e16.task_016;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicTacToe {
    private static final Logger log =
            LoggerFactory.getLogger(TicTacToe.class);

    private final int[][] values;

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    /**
     * Checking for win(TicTacToe rules)
     * work on square arrays,
     * with length from 2 to n.
     * using {@link #diagonalsHasWin()} and
     * {@link #linesOrColumnsHasWin()}
     * @return true if has a win, otherwise false
     */
    public boolean hasWinner() {
        if (values == null) {
            log.error("Array is null");
            return false;
        }
        if (values.length < 2 || values[0].length < 2) {
            log.error("Array length less than 2");
            return false;
        }
        if (values.length != values[0].length) {
            log.error("Array not square");
            return false;
        }

        log.info("Checking for win");
        return linesOrColumnsHasWin() || diagonalsHasWin();
    }

    /**
     * Checking diagonals for win
     * @return true if any diagonal has win,
     * otherwise false
     */
    private boolean diagonalsHasWin() {
        int rightBorder = values.length - 1;
        /* Checking diagonal */
        for (int i = 0; i < rightBorder; i++) {
            if (values[i][i] == values[i + 1][i + 1]) {
                if (i + 1 == rightBorder) {
                    return true;
                }
            } else {
                break;
            }
        }
        /* Checking inverse diagonal */
        int j = 1;
        for (int i = rightBorder - 1; i >= 0; i--) {
            if (values[j][i] == values[j - 1][i + 1]) {
                if (j == rightBorder) {
                    return true;
                }
                j++;
            } else {
                break;
            }
        }

        return false;
    }

    /**
     * Checking lines and columns for win
     * @return true if any line or column has win,
     * otherwise false
     */
    private boolean linesOrColumnsHasWin() {
        int rightBorder = values.length - 1;

        for (int j = 0; j < values.length; j++) {
            /* Checking lines */
            for (int i = 0; i < rightBorder; i++) {
                if (values[j][i] == values[j][i + 1]) {
                    if (i + 1 == rightBorder) {
                        return true;
                    }
                } else {
                    break;
                }
            }
            /* Checking columns */
            for (int i = 0; i < rightBorder; i++) {
                if (values[i][j] == values[i + 1][j]) {
                    if (i + 1 == rightBorder) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }

        return false;
    }
}
