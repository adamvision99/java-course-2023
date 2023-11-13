package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
//
public class Task3 {
    public static Optional<LocalDate> parseDate(String input) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter shortDateFormatter = DateTimeFormatter.ofPattern("[M/d/uu][yyyy-M-d]");
        LocalDate today = LocalDate.now();

        try {
            LocalDate date = LocalDate.parse(input, dateFormatter);
            return Optional.of(date);
        } catch (Exception ignored) {}

        try {
            LocalDate date = LocalDate.parse(input, shortDateFormatter);
            return Optional.of(date);
        } catch (Exception ignored) {}

        if (input.equalsIgnoreCase("tomorrow")) {
            return Optional.of(today.plusDays(1));
        } else if (input.equalsIgnoreCase("today")) {
            return Optional.of(today);
        } else if (input.equalsIgnoreCase("yesterday")) {
            return Optional.of(today.minusDays(1));
        }

        try {
            String[] parts = input.split(" ");
            if (parts.length == 3 && (parts[1].equals("day")||parts[1].equals("days")) && parts[2].equals("ago")) {
                int daysAgo = Integer.parseInt(parts[0]);
                return Optional.of(today.minusDays(daysAgo));
            }
        } catch (Exception ignored) {}

        return Optional.empty();
    }
}
