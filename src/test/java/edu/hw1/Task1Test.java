package edu.hw1;

import org.junit.Assert;
import org.junit.Test;


public class Task1Test {
    @Test
    public void getResult1() {
        Assert.assertEquals(836, Task1.firstTask("13:56"));
    }
    @Test
    public void getResult2() {
        Assert.assertEquals(60, Task1.firstTask("01:00"));
    }
    @Test
    public void getResult3() {
        Assert.assertEquals(-1, Task1.firstTask("10:60"));
    }
}