package edu.hw5;

import org.junit.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Task1Test {
    @Test
    public void testCalculateTotalDuration() {
        List<String> sessions = new ArrayList<>();
        sessions.add("2022-03-12, 20:20 - 2022-03-12, 23:50");
        sessions.add("2022-04-01, 21:30 - 2022-04-02, 01:20");

        Duration totalDuration = Task1.calculateTotalDuration(sessions);

        assertEquals(Duration.ofHours(7).plusMinutes(20), totalDuration);
    }

    @Test
    public void testFormatDuration() {
        Duration duration = Duration.ofHours(3).plusMinutes(40);

        String formattedDuration = Task1.formatDuration(duration);

        assertEquals("3÷ 40ì", formattedDuration);
    }

}