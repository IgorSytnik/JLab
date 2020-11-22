package com.company.people;

import com.company.ClassWithName;

public class Teacher extends ClassWithName {
    private AcademicPosition position;
    public Teacher() {
        this.name = this.enterName();
        AcademicPosition[] val = AcademicPosition.values();
        this.position = val[in.inputInt(
                AcademicPosition.list() + "\nPlease enter the number of teacher's position from the list above:"
                , 1
                , val.length
                ) - 1];
    }

    public Teacher(String n, AcademicPosition p) {
        this.name = n;
        this.position = p;
    }

    @Override
    public String toString() {
        return name + ", position: " + position;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + position.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof Teacher) {
            Teacher anobj = (Teacher)obj;
            return this.name.equals(anobj.name)
                    & this.position.equals(anobj.position);
        }
        return false;
    }
}
