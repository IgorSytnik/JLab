package com.company.hei;

import com.company.people.Group;
import com.company.people.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Department extends Institution {
    private List<Group> groups = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public Department() {
        this.name = this.enterName();
    }
    public Department(String n) {
        this.name = n;
    }

    private boolean lookUp(final String obName, final int year) {
        return groups.stream().anyMatch(o -> o.getName().equals(obName)) &
                groups.stream().anyMatch(o -> o.getYear() == year);
    }

    public boolean addGroup() {
        Group group = new Group();
        if(lookUp(group.getName(), group.getYear())) {
            System.out.println("This department already has this group ");
            return false;
        } else {
            groups.add(group);
            return true;
        }
    }

    public boolean addTeacher() {
        Teacher teacher = new Teacher();
        if(teachers.contains(teacher)) {
            System.out.println("This department already has this Teacher ");
            return false;
        } else {
            teachers.add(teacher);
            return true;
        }
    }

    public boolean getGroupsList() {
        return getList(groups, "groups");
    }

    public boolean getTeachersList() {
        return getList(teachers, "teachers");
    }

    public Group getGroup(int i) {
        return (Group) getOne(groups, "groups", i);
    }

    public Teacher getTeacher(int i) {
        return (Teacher) getOne(teachers, "teachers", i);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + groups.hashCode() + teachers.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof Department) {
            Department anobj = (Department)obj;
            return this.name.equals(anobj.name)
                    & this.groups.equals(anobj.groups)
                    & this.teachers.equals(anobj.teachers);
        }
        return false;
    }
}

