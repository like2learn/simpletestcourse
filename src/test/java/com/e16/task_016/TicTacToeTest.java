package com.e16.task_016;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TicTacToeTest {
    @Test
    public void whenDiagonalWinThenReturnTrue() throws Exception {
        TicTacToe field = new TicTacToe(
                new int[][] {
                        {1, 0, 0},
                        {1, 1, 0},
                        {0, 0, 1}
                }
        );

        assertThat(field.hasWinner(), is(true));
    }

    @Test
    public void whenInverseDiagonalWinThenReturnTrue() throws Exception {
        TicTacToe field = new TicTacToe(
                new int[][] {
                        {1, 1, 0, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 1, 0},
                        {0, 1, 0, 1, 1},
                        {1, 1, 0, 1, 1}
                }
        );

        assertThat(field.hasWinner(), is(true));
    }

    @Test
    public void whenNoWinnerThenReturnFalse() throws Exception {
        TicTacToe field = new TicTacToe(
                new int[][] {
                        {1, 0, 1},
                        {1, 1, 0},
                        {0, 1, 0}
                }
        );

        assertThat(field.hasWinner(), is(false));
    }

    @Test
    public void whenLastColumnWinThenReturnTrue() throws Exception {
        TicTacToe field = new TicTacToe(
                new int[][] {
                        {1, 1, 0, 0, 0},
                        {1, 0, 1, 0, 0},
                        {1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 0},
                        {0, 1, 0, 1, 0}
                }
        );

        assertThat(field.hasWinner(), is(true));
    }

    @Test
    public void whenLastLineWinThenReturnTrue() throws Exception {
        TicTacToe field = new TicTacToe(
                new int[][] {
                        {1, 1, 0, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {0, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}
                }
        );

        assertThat(field.hasWinner(), is(true));
    }

    @Test
    public void whenArrayNotSquareThenReturnFalse() throws Exception {
        TicTacToe field = new TicTacToe(
                new int[][] {
                        {1, 1, 0, 0, 1},
                        {1, 0, 1, 1, 1}
                }
        );

        assertThat(field.hasWinner(), is(false));
    }

    @Test
    public void whenArrayLengthLessThanTwoThenReturnFalse() throws Exception {
        TicTacToe field = new TicTacToe(
                new int[][] {
                        {1, 1, 0, 0, 1}
                }
        );

        assertThat(field.hasWinner(), is(false));
    }

    @Test
    public void whenArrayIsNullThenReturnFalse() throws Exception {
        TicTacToe field = new TicTacToe(null);

        assertThat(field.hasWinner(), is(false));
    }
}