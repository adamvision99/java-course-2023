package edu.hw5;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.*;

public class Task2Test {
    @Test
    public void testFindFridayThe13ths() {
        int year = 2024;
        List<LocalDate> fridayThe13ths = Task2.findFridayThe13ths(year);

        assertEquals(2, fridayThe13ths.size());
        assertEquals(LocalDate.of(2024, Month.SEPTEMBER, 13), fridayThe13ths.get(0));
        assertEquals(LocalDate.of(2024, Month.DECEMBER, 13), fridayThe13ths.get(1));
    }

    @Test
    public void testFindNextFridayThe13th() {
        LocalDate date = LocalDate.of(2024, Month.JULY, 15);
        LocalDate nextFridayThe13th = Task2.findNextFridayThe13th(date);

        assertEquals(LocalDate.of(2024, Month.SEPTEMBER, 13), nextFridayThe13th);
    }

}