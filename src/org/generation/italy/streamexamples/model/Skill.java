package org.generation.italy.streamexamples.model;

public class Skill {
    private String name;
    private Level level;

    public Skill(String name, Level level){
        this.name = name;
        this.level = level;
    }
    public String getName(){
        return name;
    }
    public Level getLevel(){
        return level;
    }
}
