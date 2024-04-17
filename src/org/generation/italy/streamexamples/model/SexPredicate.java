package org.generation.italy.streamexamples.model;

import java.util.function.Predicate;

public class SexPredicate implements Predicate<Developer>{

    @Override
    public boolean test(Developer t) {
        return !t.isMale();
    }
    public int t(Developer t){
        return t.calculateAge(null, null);
    }
}
