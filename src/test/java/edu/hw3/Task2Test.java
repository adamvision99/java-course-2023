package edu.hw3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Task2Test {

        @Test
        public void test1() {
            String input = "((())())(()(()()))";
            List<String> result = Task2.clusterize(input);
            List<String> expected = new ArrayList<>();
            expected.add("((())())");
            expected.add("(()(()()))");
            assertEquals(expected, result);
        }

        @Test
        public void test2() {
            String input = "((())())(()(()())))";
            List<String> result = Task2.clusterize(input);
            List<String> expected = new ArrayList<>();
            expected.add("((())())");
            expected.add("(()(()()))");
            assertEquals(expected, result);
        }

        @Test
        public void test3() {
            String input = "";
            List<String> result = Task2.clusterize(input);
            List<String> expected = new ArrayList<>();
            assertEquals(expected, result);
        }

        @Test
        public void test4() {
            String input = "abcdefg";
            List<String> result = Task2.clusterize(input);
            List<String> expected = new ArrayList<>();
            expected.add("abcdefg");
            assertEquals(expected, result);
        }
    }
