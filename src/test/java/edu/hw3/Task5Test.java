package edu.hw3;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Task5Test {
    @Test
    public void testParseContactsAscendingOrder() {
        String[] names = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        List<Task5> result = Task5.parseContacts(names, "ASC");

        assertEquals("Thomas Aquinas", result.get(0).getFullName());
        assertEquals("Rene Descartes", result.get(1).getFullName());
        assertEquals("David Hume", result.get(2).getFullName());
        assertEquals("John Locke", result.get(3).getFullName());
    }

    @Test
    public void testParseContactsDescendingOrder() {
        String[] names = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        List<Task5> result = Task5.parseContacts(names, "DESC");

        assertEquals("John Locke", result.get(0).getFullName());
        assertEquals("David Hume", result.get(1).getFullName());
        assertEquals("Rene Descartes", result.get(2).getFullName());
        assertEquals("Thomas Aquinas", result.get(3).getFullName());
    }

}