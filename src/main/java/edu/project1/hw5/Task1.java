package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {
    public static Duration calculateTotalDuration(List<String> sessions) {
        Duration totalDuration = Duration.ZERO;

        for (String session : sessions) {
            String[] sessionParts = session.split(" - ");

            LocalDateTime startDateTime = LocalDateTime.parse(sessionParts[0], DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm"));
            LocalDateTime endDateTime = LocalDateTime.parse(sessionParts[1], DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm"));

            Duration sessionDuration = Duration.between(startDateTime, endDateTime);
            totalDuration = totalDuration.plus(sessionDuration);
        }

        return totalDuration;
    }

    public static String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();

        return hours + "÷ " + minutes + "ì";
    }
}
