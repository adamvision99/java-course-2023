package edu.hw1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task4Test {
    @Test
    public void testFourthTask1() {
        Assert.assertEquals("214365", Task4.fourthTask("123456"));
    }
    @Test
    public void testFourthTask2() {
        Assert.assertEquals("This is a mixed up string.", Task4.fourthTask("hTsii  s aimex dpus rtni.g"));
    }
    @Test
    public void testFourthTask3() {
        Assert.assertEquals("abcde", Task4.fourthTask("badce"));
    }

}