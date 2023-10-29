package edu.hw1;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class Task2Test {
    @Test
    public void testSecondTask1() {
        Assert.assertEquals(4,Task2.secondTask(4666));
    }
    @Test
    public void testSecondTask2() {
        Assert.assertEquals(3,Task2.secondTask(544));
    }
    @Test
    public void testSecondTask3() {
        Assert.assertEquals(1,Task2.secondTask(0));
    }
}