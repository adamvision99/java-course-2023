package edu.hw1;

import java.util.logging.Logger;

public class Task0 {
    /**
     * 0. Привет, мир!
     * Напишите функцию, которая выводит в консоль фразу "Привет, мир!" при помощи метода LOGGER.info().
     * Тестировать задание не нужно :)
     */
    public static void zeroTask() {
        Logger logger = Logger.getLogger("Logger");
        logger.info("Hello, world!");
    }
}
