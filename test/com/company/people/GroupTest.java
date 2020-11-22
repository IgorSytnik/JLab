package com.company.people;

import com.company.hei.HigherEducationalInstitution;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {
    String group = "XX-00";
    int year = 3;
    Group g1 = new Group(group, year);
    Group g2 = new Group(group, year);
    Group g3 = new Group("HH-11", year);


    @Test
    void testInit() {
        String name = "XX-11";
        int num = 1;
        String expected =
                "p34-123\n" +
                        "12-yu\n" +
                        "XX-00\n" +
                        "n\n" +
                        name + "\n" +
                        "y\n" +
                        "2\n" +
                        "n\n" +
                        num + "\n" +
                        "y\n";
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);

        Group obj = new Group();

        assertEquals(name + ", year: " + num, obj.toString());
        System.setIn(sysInBackup);
    }

    @Test
    void addStudent() {
        int num = 1;
        String expected =
                "-2\n" +
                        "n\n" +
                        "0\n" +
                        "n\n" +
                        "FMA\n" +
                        "2\n" +
                        "n\n" +
                        num + "\n" +
                        "y\n";
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);

        g3.addStudent();
//        System.setIn(sysInBackup);
//
//        expected =
//                "-2\n" +
//                        "n\n" +
//                        "0\n" +
//                        "n\n" +
//                        "FMA\n" +
//                        "2\n" +
//                        "n\n" +
//                        num + "\n" +
//                        "y\n" +
//                        (num + 1) + "\n" +
//                        "y\n";
//        in = new ByteArrayInputStream(expected.getBytes());
//        System.setIn(in);
//        g3.addStudent();

        assertEquals(num + ", group: " + "HH-11" + ", year: " + year, g3.getStudent(0).toString());
        System.setIn(sysInBackup);
    }

    @Test
    void getStudentsList() {
        assertFalse(g3.getStudentsList());

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

        g3.addStudent();
        assertTrue(g3.getStudentsList());

        System.setIn(sysInBackup);
    }

    @Test
    void getStudent() {
        assertNull(g3.getStudent(3));

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

        g3.addStudent();
        assertNull(g3.getStudent(3));
        assertNotNull(g3.getStudent(0));

        System.setIn(sysInBackup);
    }

    @Test
    void getYear() {
        assertEquals(year, g1.getYear());
    }

    @Test
    void testToString() {
        assertEquals(group + ", year: " + year, g1.toString());
        assertEquals(g2.toString(), g1.toString());
        assertEquals(g1.toString(), g1.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(g1.hashCode(), g2.hashCode());
        assertEquals(g1.hashCode(), g1.hashCode());
    }

    @Test
    void testEquals() {
        assertEquals(g1, g2);
        assertNotEquals(g3, g1);
    }
}