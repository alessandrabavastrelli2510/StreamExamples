package org.generation.italy.streamexamples.model;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.html.Option;

public class DataAnalysis {
    private List<Developer> developers;
    
    public DataAnalysis(List<Developer> developers){
        this.developers = developers;
    }
    public int countFemales(){
        int counter = 0;
        for(Developer d: developers){
            if(!d.isMale()){
                counter ++;
            }
        }
        return counter;
    }
    public int countFemalesWithStream(){
        // Predicate<Developer> pd1 = d -> d.isFemale();
        // Predicate<Developer> pd2 = d -> d.calculateAge() > 50;
        // var pd3 = pd1.and(pd2);
        // SexPredicate sp = new SexPredicate();
        // Stream<Developer> intermediate = developers.stream().filter(Developer::isFemale);
        // Stream<Developer> secondary = intermediate.limit(4);
        // List<Developer> result = secondary.collect(Collectors.toList());
        return (int) developers.stream().filter(Developer::isFemale).count();
    }
    public double averageSalaryWithStream(){
        OptionalDouble od = developers.stream().mapToDouble(Developer::getSalary).average();
        if (od.isEmpty()){
            return -1;
        }else {
            return od.getAsDouble();
        }
    }   
    public double getAverageSalaryForWomen(){
        Stream<String> ns = developers.stream().map(d -> d.getFullName());
        OptionalDouble od = developers.stream().filter(Developer::isFemale).mapToDouble(Developer::getSalary).average();
        if(od.isEmpty()){
            return -1;
        }else {
            return od.getAsDouble();
        }
    }
    public OptionalDouble getAvgSalaryForWomen(){
        return developers.stream().filter(Developer::isFemale).mapToDouble(Developer::getSalary).average();
    }
    public OptionalDouble getMaxSalaryForWomen(){
        return developers.stream().filter(Developer::isFemale).mapToDouble(Developer::getSalary).max();
    }
    public OptionalDouble getMinSalaryForMen(){
        return developers.stream().filter(Developer::isMale).mapToDouble(Developer::getSalary).min();
    }
    public boolean isPatriarcActive(){
        OptionalDouble odm = getMinSalaryForMen();
        OptionalDouble odw = getMaxSalaryForWomen();
        if(odm.isEmpty()){
            return false;
        }
        if(odw.isEmpty()){
            return false;
        }
        return odm.getAsDouble() > odw.getAsDouble();
    }
    public OptionalDouble maxSalaryForMaleUnder30(){
        return developers.stream().filter(Developer::isMale).filter(d -> d.calculateAge() < 30).mapToDouble(Developer::getSalary).max();
        // return developers.stream().filter(d -> d.isMale() && d.calculateAge() < 30).mapToDouble(Developer::getSalary).max();
    }
    public OptionalDouble maxSalaryForMaleOrUnder30(){
        return developers.stream().filter(d -> d.calculateAge() < 30 || d.isMale()).mapToDouble(Developer::getSalary).max();
    }
}
