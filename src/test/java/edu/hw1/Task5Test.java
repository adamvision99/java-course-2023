package edu.hw1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task5Test {
    @Test
    public void fifthTask1() {
        Assert.assertTrue(Task5.fifthTask(11211230));
    }
    @Test
    public void fifthTask2() {
        Assert.assertTrue(Task5.fifthTask(13001120));
    }
    @Test
    public void fifthTask3() {
        Assert.assertTrue(Task5.fifthTask(23336014));
    }
    @Test
    public void fifthTask4() {
        Assert.assertTrue(Task5.fifthTask(11));
    }

}