package com.company.hei;

import com.company.HashCodeTestClass;
import com.company.people.AcademicPosition;
import com.company.people.Group;
import com.company.people.Student;
import com.company.people.Teacher;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    String name = "Tim Shaq";
    Department s1 = new Department(name);
    Department s2 = new Department(name);
    Department obj = new Department("Bigu");

    @Test
    void addGroup_AddAGroup_True() throws IOException {
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

        assertTrue(obj.addGroup());

        System.setIn(sysInBackup);
    }

    @Test
    void addGroup_AddTwoEqualGroups_False() throws IOException {
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
        assertFalse(obj.addGroup());

        System.setIn(sysInBackup);
    }

    @Test
    void getGroup_EmptyList_Null() {
        assertNull(obj.getGroup(0));
    }

    @Test
    void getGroup_WrongNumber_Null() throws IOException {
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

        assertNull(obj.getGroup(4));
    }

    @Test
    void getGroup_GetTeacherFromList_NotNull() throws IOException {
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

        assertNotNull(obj.getGroup(0));
    }

    @Test
    void addTeacher_AddATeacher_True() throws IOException {
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

        assertTrue(obj.addTeacher());

        System.setIn(sysInBackup);
    }

    @Test
    void addTeacher_AddTwoEqualTeachers_False() throws IOException {
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
        assertFalse(obj.addTeacher());

        System.setIn(sysInBackup);
    }

    @Test
    void getTeacher_EmptyList_Null(){
        assertNull(obj.getTeacher(0));
    }

    @Test
    void getTeacher_WrongNumber_Null() throws IOException {
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

        assertNull(obj.getTeacher(4));
    }

    @Test
    void getTeacher_GetTeacherFromList_NotNull() throws IOException {
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

        assertNotNull(obj.getTeacher(0));
    }

    @Test
    void getGroupsList_GetEmptyList_False() {
        assertFalse(obj.getGroupsList());
    }

    @Test
    void getGroupsList_GetNotEmptyList_True() throws IOException {
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
    void getTeachersList_GetEmptyList_False() {
        assertFalse(obj.getTeachersList());
    }

    @Test
    void getTeachersList_GetNotEmptyList_True() throws IOException {
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
    void hashCode_CompareEqualDepartmentHashCodes_Equals() {
        assertEquals(s1.hashCode(), s2.hashCode());
        assertEquals(s1.hashCode(), s1.hashCode());
    }

    @Test
    void hashCode_CompareNotEqualDepartmentHashCodes_NotEquals() {
        assertNotEquals(obj.hashCode(), s1.hashCode());
    }

    @Test
    void equals_CompareNotEqualDepartments_NotEquals() {
        HashCodeTestClass O = new HashCodeTestClass();
        O.hashcode = s2.hashCode();
        assertFalse(s2.equals(O));
        assertNotEquals(obj, s1);
    }

    @Test
    void equals_CompareEqualDepartments_Equals() {
        assertEquals(s1, s2);
    }
}