package com.company.hei;

import com.company.ClassWithName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstitutionTest {
    Institution obj = new Institution() {
        @Override
        public String enterName() throws IOException {
            return super.enterName();
        }

        @Override
        protected boolean getList(List col, String name) {
            return super.getList(col, name);
        }

        @Override
        protected Object getOne(Collection<? extends ClassWithName> col, String name, int i) {
            return super.getOne(col, name, i);
        }
    };

    @Test
    void enterName_GotTheProperString_Equals() throws IOException {
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

        assertEquals(name, obj.enterName());
        System.setIn(sysInBackup);
    }
}