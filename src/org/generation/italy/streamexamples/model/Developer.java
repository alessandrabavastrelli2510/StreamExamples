package org.generation.italy.streamexamples.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Developer {
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private boolean male;
    private Map<String, Skill> skills;
    private double salary;

    public Developer(String firstname, String lastname, LocalDate birthDate, boolean male, double salary){
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.male = male;
        this.salary = salary;
        this.skills = new HashMap<>();
    }
    public int addSkill(Skill s){
        skills.put(s.getName(), s);
        return skills.size();
    }
    public boolean removeSkill(String skillName){
        // return skills.remove(skillName) != null;
        if(skills.remove(skillName) != null){
            return true;
        }
        return false;
    }
    public boolean isMale(){
        return male;
    }
    public boolean isFemale(){
        return !male;
    }
    public double getSalary(){
        return salary;
    }
    public String getFullName(){
        return firstname +" "+ lastname;
    }

}
