package com.company.people;

import com.company.HashCodeTestClass;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {
    String name = "Tim Shaq";
    AcademicPosition position = AcademicPosition.ASPIRANT;
    Teacher t1 = new Teacher(name, position);
    Teacher t2 = new Teacher(name, position);
    Teacher t3 = new Teacher("Bigu", AcademicPosition.DOCTORAL_STUDENT);

    @Test
    void testInit() {
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
        InputStream in = new ByteArrayInputStream(expected.getBytes());
        in.mark(0);
        System.setIn(in);

        Teacher obj = new Teacher();

        assertEquals(name + ", position: " + AcademicPosition.values()[num-1], obj.toString());
        System.setIn(sysInBackup);
    }

    @Test
    void testToString() {
        assertEquals(name + ", position: " + position, t1.toString());
        assertEquals(t2.toString(), t1.toString());
        assertEquals(t1.toString(), t1.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(t1.hashCode(), t2.hashCode());
        assertEquals(t1.hashCode(), t1.hashCode());
    }

    @Test
    void testEquals() {
        HashCodeTestClass O = new HashCodeTestClass();
        O.hashcode = t2.hashCode();
        assertFalse(t2.equals(O));
        assertTrue(t2.equals(t1));
        assertFalse(t1.equals(t3));
    }
}