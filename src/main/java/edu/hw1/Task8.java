package edu.hw1;

public class Task8 {
    /**
     * 8. Кони на доске
     * Напишите функцию, которая возвращает true, если кони расставлены на шахматной доске так, что ни один конь не может захватить другого коня.
     * На вход подаётся двумерный массив размера 8х8, где 0 означает пустую клетку, а 1 - занятую конём клетку.
     */
    public static boolean eighthTask(int[][] deck) {
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (deck[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < 8 && y >= 0 && y < 8 && deck[x][y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return  true;
    }
}
