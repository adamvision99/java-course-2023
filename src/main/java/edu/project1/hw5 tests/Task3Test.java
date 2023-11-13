package edu.hw5;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

public class Task3Test {
    @Test
    public void testParseDate() {
        assertEquals(Optional.of(LocalDate.of(2020, 10, 10)), Task3.parseDate("2020-10-10"));
        assertEquals(Optional.of(LocalDate.of(2020, 12, 2)), Task3.parseDate("2020-12-2"));
        assertEquals(Optional.of(LocalDate.of(2020, 1, 3)), Task3.parseDate("1/3/20"));
        assertEquals(Optional.of(LocalDate.now().plusDays(1)), Task3.parseDate("tomorrow"));
        assertEquals(Optional.of(LocalDate.now()), Task3.parseDate("today"));
        assertEquals(Optional.of(LocalDate.now().minusDays(1)), Task3.parseDate("yesterday"));
        assertEquals(Optional.of(LocalDate.now().minusDays(1)), Task3.parseDate("1 day ago"));
        assertEquals(Optional.of(LocalDate.now().minusDays(2234)), Task3.parseDate("2234 days ago"));

        // Проверка на пустой результат для некорректного формата
        assertFalse(Task3.parseDate("invalid date format").isPresent());
    }

}