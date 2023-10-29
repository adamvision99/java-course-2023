package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

public class Task6 {
    /**
     * 6. Постоянная Капрекара
     * Выберем любое четырёхзначное число n, больше 1000, в котором не все цифры одинаковы.
     * Расположим цифры сначала в порядке возрастания, затем в порядке убывания.
     * Вычтем из большего меньшее. Производя перестановки цифр и вычитания, нули следует сохранять.
     * Описанное действие назовём функцией Капрекара K(n).
     * Повторяя этот процесс с получающимися разностями, не более чем за семь шагов мы получим число 6174, которое будет затем воспроизводить само себя.
     * Это свойство числа 6174 было открыто в 1949 году. индийским математиком Д. Р. Капрекаром, в честь которого оно и получило своё название.
     */
    public static int sixthTask(int number, int count) {
        if (number == 6174)
            return count;
        else {
            Integer[] array = new Integer[4];
            for (int i = 0; i < 4; i++) {
                array[i] = number % 10;
                number /= 10;
            }
            Arrays.sort(array);
            int order = array[0] * 1000 + array[1] * 100 + array[2] * 10 + array[3];
            Arrays.sort(array, Collections.reverseOrder());
            int reorder = array[0] * 1000 + array[1] * 100 + array[2] * 10 + array[3];
            count++;
            return sixthTask(Math.abs(order - reorder), count);
        }
    }
}
