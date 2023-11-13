package edu.hw5;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task6Test {
    @Test
    public void testIsSubsequence() {
        assertTrue(Task6.isSubsequence("abc", "achfdbaabgabcaabg"));
        assertTrue(Task6.isSubsequence("abc", "abcfghij"));
        assertTrue(Task6.isSubsequence("def", "abcdefgh"));

        assertFalse(Task6.isSubsequence("123", "1a2b3c"));
        assertFalse(Task6.isSubsequence("123", "456789"));
        assertFalse(Task6.isSubsequence("abc", "aabbcc"));
    }

}