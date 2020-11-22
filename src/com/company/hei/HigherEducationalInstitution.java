package com.company.hei;

import java.util.ArrayList;
import java.util.List;

public class HigherEducationalInstitution extends Institution {
    private List<Faculty> faculties = new ArrayList<>();

    public HigherEducationalInstitution() {
        this.name = this.enterName();
    }
    public HigherEducationalInstitution(String n) {
        this.name = n;
    }

    private boolean lookUp(final String obName) {
        return faculties.stream().anyMatch(o -> o.getName().equals(obName));
    }

    public void addFaculty() {
        Faculty faculty = new Faculty();
        while ( lookUp(faculty.getName()) ) {
            System.out.println("This institution already has this faculty ");
            faculty = new Faculty();
        }
        faculties.add(faculty);
    }

    public void addDepartment() {
        if(getFacList()) {
            System.out.println("\nWhere do you want to put new department? (pick the faculty)");
            int num = in.inputInt("Please enter the number from the list (-1 to cancel):",
                    1,
                    faculties.size()) - 1;
            if(num == -1) return;
            faculties.get(num).addDepartment();
        } else {
            System.out.println("\nFirst, you need to add faculties.");
        }
    }

    public boolean getFacList() {
        return getList(faculties, "faculties");
    }

    public Faculty getFaculty(int i) {
        //TODO 5 ("Object") do stuff
        Object obj = getOne(faculties, "faculties", i);
//        try {
//            if (!(obj instanceof Faculty)) throw new RuntimeException("Wrong object type!");
            return (Faculty) obj;
//        } catch (RuntimeException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return null;
//        return (Faculty) obj;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + faculties.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj instanceof HigherEducationalInstitution) {
            HigherEducationalInstitution anobj = (HigherEducationalInstitution)obj;
            return this.name.equals(anobj.name) & this.faculties.equals(anobj.faculties);
        }
        return false;
    }
}
