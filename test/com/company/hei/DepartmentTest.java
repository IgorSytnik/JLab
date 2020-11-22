package com.company.hei;

import com.company.people.AcademicPosition;
import com.company.people.Group;
import com.company.people.Student;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    String name = "Tim Shaq";
    Department s1 = new Department(name);
    Department s2 = new Department(name);
    Department obj = new Department("Bigu");

    @Test
    void addGroup() {
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

        obj.addGroup();
        assertEquals(name + ", year: " + num, obj.getGroup(0).toString());

        System.setIn(sysInBackup);
    }

    @Test
    void addTeacher() {
        String name = "1";
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

        obj.addTeacher();
        assertEquals(name + ", position: " + AcademicPosition.values()[num-1], obj.getTeacher(0).toString());

        System.setIn(sysInBackup);
    }

    @Test
    void getGroupsList() {
        assertFalse(obj.getGroupsList());
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

        obj.addGroup();

        System.setIn(sysInBackup);

        assertTrue(obj.getGroupsList());
    }

    @Test
    void getTeachersList() {
        assertFalse(obj.getTeachersList());
        String name = "1";
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

        obj.addTeacher();

        System.setIn(sysInBackup);

        assertTrue(obj.getTeachersList());
    }

    @Test
    void getGroup() {
    }

    @Test
    void getTeacher() {
    }

    @Test
    void testHashCode() {
        assertEquals(s1.hashCode(), s2.hashCode());
        assertEquals(s1.hashCode(), s1.hashCode());
    }

    @Test
    void testEquals() {
        assertEquals(s1, s2);
        assertNotEquals(obj, s1);
    }
}