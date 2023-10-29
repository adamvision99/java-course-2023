package edu.hw2;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Task2Test {
    @Test
    public void rectangleArea() {
        Task2.Rectangle rect = new Task2.Rectangle(10,20);
        long res = Math.round(rect.area());
        Assert.assertEquals(200,res);
    }
    @Test
    public void squareArea() {
        Task2.Square sq = new Task2.Square(20);
        long res = Math.round(sq.area());
        Assert.assertEquals(400,res);
    }

}