package edu.hw1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task6Test {
    @Test
    public void sixthTask1() {
        Assert.assertEquals(5, Task6.sixthTask(6621,0));
    }
    @Test
    public void sixthTask2() {
        Assert.assertEquals(4, Task6.sixthTask(6554,0));
    }
    @Test
    public void sixthTask3() {
        Assert.assertEquals(3, Task6.sixthTask(1234,0));
    }
}