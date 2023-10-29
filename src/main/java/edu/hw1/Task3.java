package edu.hw1;

import java.util.Arrays;

public class Task3 {
    /**
     * 3. Вложенный массив
     * Напишите функцию, которая возвращает true, если первый массив может быть вложен во второй, и false в противном случае.
     * Массив может быть вложен, если:     *
     * min(a1) больше чем min(a2)
     * max(a1) меньше, чем max(a2)
     */
    public static boolean thirdTask(int[] first, int[] second) {
        int minFirst = Arrays.stream(first).min().orElse(0);
        int minSecond = Arrays.stream(second).min().orElse(0);
        int maxFirst = Arrays.stream(first).max().orElse(0);
        int maxSecond = Arrays.stream(second).max().orElse(0);
        return minSecond <= minFirst && maxSecond >= maxFirst;

    }
}
