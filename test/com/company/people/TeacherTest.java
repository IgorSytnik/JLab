package com.company.people;

import com.company.HashCodeTestClass;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {
    String name = "Tim Shaq";
    AcademicPosition position = AcademicPosition.ASPIRANT;
    Teacher t1 = new Teacher(name, position);
    Teacher t2 = new Teacher(name, position);
    Teacher t3 = new Teacher("Bigu", AcademicPosition.DOCTORAL_STUDENT);

    @Test
    void toStringTest() {
        assertEquals(name + ", position: " + position, t1.toString());
        assertEquals(t2.toString(), t1.toString());
        assertEquals(t1.toString(), t1.toString());
        assertNotEquals(t1.toString(), t3.toString());
    }

    @Test
    void hashCodeTest() {
        assertEquals(t1.hashCode(), t2.hashCode());
        assertEquals(t1.hashCode(), t1.hashCode());
    }

    @Test
    void equalsTest() {
        HashCodeTestClass O = new HashCodeTestClass();
        O.hashcode = t2.hashCode();
        assertFalse(t2.equals(O));
        assertTrue(t2.equals(t1));
        assertFalse(t1.equals(t3));
    }
}