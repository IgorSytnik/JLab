package com.company;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    void inputString() {
        String expected = "sdfsfsdf\ny";
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(expected.getBytes());
        in.mark(0);
        System.setIn(in);
        Input.inputString("Please enter full name:", "[a-zA-Z_0-9\\s]+");
//        Throwable thrown = assertThrows(IOException.class, () -> {
//            Input.inputString("Please enter full name:", "[a-zA-Z_0-9\\s]+");
//        });

//        expectedException(g3.getStudent(3));
//        assertNotNull(g3.getStudent(0));

        System.setIn(sysInBackup);
    }

    @Test
    void inputInt() {
    }
}