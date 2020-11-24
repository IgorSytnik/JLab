package com.company;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import java.io.ByteArrayInputStream;

class InputTest {

    @Test
    void inputStringTest() throws IOException {
        String expected = "sdfsfsdf\ny";
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        InputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);

        Input.inputString("Please enter full name:", "[a-zA-Z_0-9\\s]+");

        Input.inputString("Please enter full name:", "[a-zA-Z_0-9\\s]+");

        System.setIn(sysInBackup);
    }

}