package edu.hw1;

public class Task1 {
    /**
     * 1. Длина видео
     * Дана строка с длиной видео в формате mm:ss, например 12:44.
     * Напишите функцию, которая возвращает общую длину видео в секундах.
     */
    public static int firstTask(String str) {
        String[] parts = str.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        if (sec >= 60)
            return -1;
        else
            return min * 60 + sec;
    }
}
