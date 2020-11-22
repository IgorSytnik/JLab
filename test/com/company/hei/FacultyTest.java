package com.company.hei;

import com.company.HashCodeTestClass;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class FacultyTest {
    String name = "Tim Shaq";
    Faculty s1 = new Faculty(name);
    Faculty s2 = new Faculty(name);
    Faculty obj = new Faculty("Shaq");

    @Test
    void getDepartmentsListAddDepartmentTest() {
        assertFalse(obj.getDepartmentsList());
        String name = "My string";
        String expected = "My@@ string\n" +
                "My string.\n" +
                "My string\n" +
                "My string\n" +
                "n\n" +
                "My string\n" +
                "y\n";
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);

        assertTrue(obj.addDepartment());
        assertFalse(obj.addDepartment());

        System.setIn(sysInBackup);

        assertTrue(obj.getDepartmentsList());
    }

    @Test
    void getDepartment() {
    }

    @Test
    void testHashCode() {
        assertEquals(s1.hashCode(), s2.hashCode());
        assertEquals(s1.hashCode(), s1.hashCode());
    }

    @Test
    void testEquals() {
        HashCodeTestClass O = new HashCodeTestClass();
        O.hashcode = s2.hashCode();
        assertFalse(s2.equals(O));
        assertEquals(s1, s2);
        assertNotEquals(obj, s1);
    }
}