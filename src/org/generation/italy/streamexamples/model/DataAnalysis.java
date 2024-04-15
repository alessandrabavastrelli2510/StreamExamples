package org.generation.italy.streamexamples.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        // SexPredicate sp = new SexPredicate();
        // Stream<Developer> intermediate = developers.stream().filter(Developer::isFemale);
        // Stream<Developer> secondary = intermediate.limit(4);
        // List<Developer> result = secondary.collect(Collectors.toList());
        return (int) developers.stream().filter(Developer::isFemale).count();
    }
        
}
