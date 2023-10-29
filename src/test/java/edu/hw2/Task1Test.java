package edu.hw2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task1Test {
    @Test
    public void getResult(){
        var two = new Task1.Expr.Constant(2);
        var four = new Task1.Expr.Constant(4);
        long res = Math.round(new Task1.Expr.Addition(two, four).evaluate());
        Assert.assertEquals(6, res );
    }

}