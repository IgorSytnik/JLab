package com.company.people;

import com.company.ClassWithName;

public class Student extends ClassWithName {
    private String group;
    private int year;
    public Student(String g, int y) {
        this.group = g;
        this.year = y;
        this.name = this.enterName();
    }
    public Student(String n, String g, int y) {
        this.group = g;
        this.year = y;
        this.name = n;
    }
    @Override
    //TODO 11 ("+")
    public String toString() {
        return name + ", group: " + group + ", year: " + year;
    }

    //TODO 15 ("equals hashCode")
    @Override
    public int hashCode() {
        return name.hashCode() + year + group.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof Student) {
            Student anobj = (Student)obj;
            return this.year == anobj.year
                    & this.name.equals(anobj.name)
                    & this.group.equals(anobj.group);
        }
        return false;
    }
}
