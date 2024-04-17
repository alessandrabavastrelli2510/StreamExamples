package org.generation.italy.streamexamples.model;

import java.util.function.Predicate;

public class SexFilter implements Predicate<Developer> {

    @Override
    public boolean test(Developer d) {
        return d.isFemale();
    }

}
