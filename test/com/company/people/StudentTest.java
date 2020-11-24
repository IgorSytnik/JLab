package com.company.people;

import com.company.HashCodeTestClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    String name = "Tim Shaq";
    String group = "XX-00";
    int year = 3;
    Student s1 = new Student(name, group, year);
    Student s2 = new Student(name, group, year);
    Student s3 = new Student("Bigu", group, year);

    @Test
    void toStringTest() {
        assertEquals(name + ", group: " + group + ", year: " + year, s1.toString());
        assertEquals(s2.toString(), s1.toString());
        assertEquals(s1.toString(), s1.toString());
    }

    @Test
    void hashCodeTest() {
        assertEquals(s1.hashCode(), s2.hashCode());
        assertEquals(s1.hashCode(), s1.hashCode());
    }

    @Test
    void equalsTest() {
        HashCodeTestClass O = new HashCodeTestClass();
        O.hashcode = s2.hashCode();
        assertFalse(s2.equals(O));
        assertEquals(s1, s2);
        assertNotEquals(s3, s1);
    }
}