package com.company.people;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcademicPositionTest {

    @Test
    void list() {
        assertNotNull(AcademicPosition.list());
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < AcademicPosition.values().length; i++) {
            str.append(i+1);
            str.append(' ');
            str.append(AcademicPosition.values()[i]);
            str.append('\n');
        }
        assertEquals(str.toString(), AcademicPosition.list());

    }

    @Test
    void testToString() {
    }

    @Test
    void values() {
    }

    @Test
    void valueOf() {
    }
}