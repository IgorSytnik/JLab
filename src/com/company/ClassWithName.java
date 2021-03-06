package com.company;

import java.io.IOException;
import java.util.Comparator;

public abstract class ClassWithName implements Name {
    //TODO 2 name
//    protected Input in = new Input();
    protected String name;

    // Used for sorting in ascending order
    protected Comparator<ClassWithName> NameComparator = Comparator.comparing(ClassWithName::getName);

    public String enterName(String question, String regex) throws IOException {
        String[] arrstr = Input.inputString(question, regex).split("\\s+");
        StringBuilder buildstr = new StringBuilder(arrstr[0]);
        if (arrstr.length > 1) {
            for (int i = 1; i < arrstr.length; i++) {
                buildstr.append(' ');
                buildstr.append(arrstr[i]);
            }
        }
        return buildstr.toString();
    }

    public String enterName() throws IOException {
        return enterName("Please enter full name:", "[a-zA-Z_0-9\\s]+");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
