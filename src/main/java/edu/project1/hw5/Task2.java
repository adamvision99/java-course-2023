package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static List<LocalDate> findFridayThe13ths(int year) {
        List<LocalDate> fridayThe13ths = new ArrayList<>();

        for (Month month : Month.values()) {
            LocalDate date = LocalDate.of(year, month, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridayThe13ths.add(date);
            }
        }

        return fridayThe13ths;
    }

    public static LocalDate findNextFridayThe13th(LocalDate date) {
        List<LocalDate> findFridayThe13ths = findFridayThe13ths(date.getYear());
        for (LocalDate ld : findFridayThe13ths) {
            if (ld.isAfter(date))
                return ld;
        }
        return null;
    }
}
