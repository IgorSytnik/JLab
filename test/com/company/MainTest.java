package com.company;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMain() {
        String input = "";
        String[] args = null;
        final InputStream original = System.in;
        final ByteArrayInputStream bin = new ByteArrayInputStream(input.getBytes());
        System.setIn(bin);
        Main.main(args);
        System.setIn(original);
    }
}