package edu.hw3;

import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class Task1Test {

    @Test
    public void encrypt() {
        String str = "Hello, World!";
        Assert.assertEquals("Svool dliow!", Task1.encrypt(str));
    }
}