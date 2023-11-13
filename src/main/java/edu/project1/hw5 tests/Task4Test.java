package edu.hw5;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task4Test {
    @Test
    public void testValidatePassword() {
        assertFalse(Task4.validatePassword("securePassword"));

        assertTrue(Task4.validatePassword("password@123"));

        assertTrue(Task4.validatePassword("complex!Password"));
    }

}