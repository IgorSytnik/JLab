package com.company.hei;

import com.company.people.Group;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HigherEducationalInstitutionTest {
    String n = "XX-00";
    HigherEducationalInstitution g1 = new HigherEducationalInstitution(n);
    HigherEducationalInstitution g2 = new HigherEducationalInstitution(n);
    HigherEducationalInstitution obj = new HigherEducationalInstitution("Tim Shaq");

    @Test
    void testInit() {
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

        HigherEducationalInstitution hei = new HigherEducationalInstitution();

        assertEquals(name, hei.getName());
        System.setIn(sysInBackup);
    }

    @Test
    void addFaculty() {
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

        obj.addFaculty();
        assertEquals(name, obj.getFaculty(0).getName());

//        HigherEducationalInstitution hei = new HigherEducationalInstitution(name);
//        list.add(hei);
//        assertTrue(obj.getList(list, "fff"));

        System.setIn(sysInBackup);
    }

    @Test
    void addDepartment() {
        obj.addDepartment();
        String name = "1";
        String expected = "1\n" +
                        "y\n";
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);

        obj.addFaculty();
        assertEquals(name, obj.getFaculty(0).getName());

        System.setIn(sysInBackup);

        System.setIn(in);

        obj.addDepartment();
        assertEquals(name, obj.getFaculty(0).getDepartment(0).getName());

        System.setIn(sysInBackup);
    }

    @Test
    void getFacList() {
        assertFalse(obj.getFacList());
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

        obj.addFaculty();

        System.setIn(sysInBackup);

        assertTrue(obj.getFacList());
    }

    @Test
    void getFaculty() {
    }

    @Test
    void testHashCode() {
        assertEquals(g1.hashCode(), g2.hashCode());
        assertEquals(g1.hashCode(), g1.hashCode());
    }

    @Test
    void testEquals() {
        assertEquals(g1, g2);
        assertNotEquals(obj, g1);
    }
}