package edu.hw5;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task5Test {
    @Test
    public void testValidateCarNumber() {
        assertTrue(Task5.validateCarNumber("�123��777"));
        assertTrue(Task5.validateCarNumber("�777��177"));

        assertFalse(Task5.validateCarNumber("123���777"));
        assertFalse(Task5.validateCarNumber("�123��7777"));
    }

}