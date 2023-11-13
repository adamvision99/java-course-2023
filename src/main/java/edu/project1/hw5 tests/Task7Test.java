package edu.hw5;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task7Test {
    @Test
    public void testRegex() {
        assertFalse(Task7.matchesRegex("101", ".*.{2}0.*"));
        assertTrue(Task7.matchesRegex("110", ".*.{2}0.*"));
        assertTrue(Task7.matchesRegex("111", "^(.|.*(.).*\\2.*|)$"));
        assertTrue(Task7.matchesRegex("000", "^(.|.*(.).*\\2.*|)$"));
        assertTrue(Task7.matchesRegex("01", "^.{1,3}$"));
        assertFalse(Task7.matchesRegex("0000", "^.{1,3}$"));
    }

}