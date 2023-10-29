package edu.hw1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task7Test {

    @Test
    public void seventhLeft1() {
        Assert.assertEquals(1, Task7.seventhLeft(16,1));
    }
    @Test
    public void seventhLeft2() {
        Assert.assertEquals(6, Task7.seventhLeft(17,2));
    }

    @Test
    public void seventhRight1() {
        Assert.assertEquals(4, Task7.seventhRight(8,1));
    }
}