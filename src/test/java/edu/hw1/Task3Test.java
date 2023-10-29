package edu.hw1;

import junit.framework.Assert;
import org.junit.Test;

public class Task3Test {
    @Test
    public void testThirdTask1() {
        int[] first = new int[] {1, 2, 3, 4};
        int[] second = new int[] {0, 6};
        Assert.assertTrue(Task3.thirdTask(first, second));
    }
    @Test
    public void testThirdTask2() {
        int[] first = new int[] {3, 1};
        int[] second = new int[] {4, 0};
        Assert.assertTrue(Task3.thirdTask(first, second));
    }
    @Test
    public void testThirdTask3() {
        int[] first = new int[] {1, 2, 3, 4};
        int[] second = new int[] {2, 3};
        Assert.assertFalse(Task3.thirdTask(first, second));
    }
}