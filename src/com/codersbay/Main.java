package com.codersbay;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /*int field[][] = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };*/

        /* int nextGen[][] = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };*/

        int[][] field = new int[20][20];
        int[][] nextGen = new int[20][20];

        field[7][7] = 1;
        field[8][7] = 1;
        field[9][7] = 1;
        field[10][7] = 1;
        field[11][7] = 1;

        field[7][9] = 1;

        field[11][9] = 1;

        field[7][11] = 1;
        field[8][11] = 1;
        field[9][11] = 1;
        field[10][11] = 1;
        field[11][11] = 1;

        int colStart = 0, colEnd = 0;
        int rowStart = 0, rowEnd = 0;
        int aliveNeighbours = 0;

        // Arrays.fill(nextGen, 0);


        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++)
                if (field[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            System.out.println();
        }

        do {
            liveGame(field, nextGen);

      /*  for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0) {
                    rowStart = 0;
                    rowEnd = i + 1;
                } else {
                    rowStart = i - 1;
                    rowEnd = j + 1;
                }

                if (j == 0) {
                    colStart = 0;
                    colEnd = j + 1;
                } else {
                    colStart = j - 1;
                    colEnd = j + 1;
                }

                if (i == 9) {
                    rowEnd = 9;
                    rowStart = i - 1;
                } else if (i>0){
                    rowStart = i - 1;
                    rowEnd = i + 1;
                }
                if (j == 9) {
                    colStart = j - 1;
                    colEnd = j;
                } else if (j > 0) {
                    colStart = j - 1;
                    colStart = j + 1;
                }
                for (int k = rowStart; k <= rowEnd; k++) {
                    for (int l = colStart; l <= colEnd; l++) {
                        if ((((k == i) && (l == j)) == false) && (field[k][l] == 1))
                            nextGen[i][j] = nextGen[i][j] + 1;
                    }
                }
            }

        }*/

        /*for (int k = rowStart; k <= rowEnd; k++) {
            for (int l = colStart; l <= colEnd; l++) {
                nextGen[k][l] = nextGen[k][l] + 1;
            }
        }*/

     /*   for ( int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (nextGen[i][j] < 2)
                    field[i][j] = 0;
                else if ((nextGen[i][j] == 2) || (nextGen[i][j] == 3))
                    field[i][j] = 1;
                else if (nextGen[i][j] > 3)
                    field[i][j] = 0;
            }
        }*/


  //          field = nextGen;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    field[i][j] = nextGen[i][j];
                    if (field[i][j] == 0) {
                        System.out.print(".");
                    } else {
                        System.out.print("*");
                    }
                }
                System.out.println();
            }

        } while (true);
    }

    private static void liveGame(int[][] field, int[][] nextGen) {
        int aliveNeighbours;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (field[i][j] == 0) {
                    aliveNeighbours = 0;
                } else {
                    aliveNeighbours = -1;
                }
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        try {
                            aliveNeighbours += field[i + k][j + l];

                        } catch (ArrayIndexOutOfBoundsException e) {
                        // in order to avoid array indexoutofboundsexception
                        }
                        /*
                        try {
                            if ((field[i][j] == 1)) {
                                nextGen[i][j] = nextGen[i][j] + 1;
                            }
                        } catch ( ArrayIndexOutOfBoundsException e) {

                        }*/
                    }
                }
                // aliveNeighbours -= field[i][j];

                if ((field[i][j] == 1) && (aliveNeighbours < 2))
                    nextGen[i][j] = 0;
                else if ((field[i][j] == 1) && (aliveNeighbours > 3))
                    nextGen[i][j] = 0;
                else if ((field[i][j] == 0) && (aliveNeighbours == 3))
                    nextGen[i][j] = 1;
                else if ((field[i][j] == 1) && ((aliveNeighbours == 3) || (aliveNeighbours == 2)))
                    nextGen[i][j] = 1;
                else
                    nextGen[i][j] = field[i][j];
            }
        }
    }


}

