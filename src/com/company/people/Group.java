package com.company.people;

import com.company.ClassWithName;
import com.company.Input;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group extends ClassWithName {
    private List<Student> students = new ArrayList<>();
    private int year;

    public Group() {
        this.name = this.enterName("Please enter group name (example: \"XX-11\"):", "\\p{Alpha}+-\\d+");
        this.year = Input.inputInt("Please enter group year (from 1 to 6):", 1, 6);
    }

    public Group(String n, int y) {
        this.name = n;
        this.year = y;
    }

    public boolean addStudent() {
        Student student = new Student(name, year);
        if(students.contains(student)) {
            System.out.println("This group already has this student ");
            return false;
        } else {
            students.add(student);
            return true;
        }
    }

    public boolean getStudentsList() {
        students.sort(this.NameComparator);
        if(students.isEmpty()) {
            System.out.println("The list of students is empty.");
            return false;
        } else {
            System.out.println("The list of students:");
            Iterator<Student> iter = students.iterator();
            for(int i = 1; iter.hasNext(); i++){
                System.out.println(i + ". " + iter.next().getName());
            }
            return true;
        }
    }

    public Student getStudent(int i) {
        if (students.isEmpty()) {
            System.out.println("The list of students is empty.");
            return null;
        } else if (i < 0 || i > students.size()) {
            System.out.println("You've entered wrong number.");
            return null;
        }
        return students.get(i);
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return name + ", year: " + year;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + year + students.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof Group) {
            Group anobj = (Group)obj;
            return this.year == anobj.year
                    & this.name.equals(anobj.name)
                    & this.students.equals(anobj.students);
        }
        return false;
    }
}
