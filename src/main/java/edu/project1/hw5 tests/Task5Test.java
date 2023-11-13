package edu.hw5;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task5Test {
    @Test
    public void testValidateCarNumber() {
        assertTrue(Task5.validateCarNumber("ю123бе777"));
        assertTrue(Task5.validateCarNumber("н777нн177"));

        assertFalse(Task5.validateCarNumber("123юбе777"));
        assertFalse(Task5.validateCarNumber("ю123бе7777"));
    }

}