package com.premiumminds.internship.teknonymy;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalDateTime;

public record Person(String name, Character sex, Person[] children, LocalDateTime dateOfBirth) {
    private static final int genWhereUStartToBeGreat = 3;

    /**
     * From a given person and its generation calculates the teknonymy for this person
     * @param personAndGen pair of the person to compare and its generation
     * @return correct teknonymy of the person
     */
    public String getCorrectTeknonymy(Pair<Person, Integer> personAndGen) {
        int currGen = personAndGen.getValue();
        Person currPerson = personAndGen.getKey();
        String newTeknonymy = (currGen >= genWhereUStartToBeGreat) ?
                "great-".repeat(currGen - genWhereUStartToBeGreat + 1) :
                "";
        switch (this.sex) {
            case 'M':
                newTeknonymy += (currGen == 1) ? "father of " : "grandfather of ";
                break;
            case 'F':
                newTeknonymy += (currGen == 1) ? "mother of " : "grandmother of ";
                break;
        }
        return newTeknonymy + currPerson.name + "; ";
    }
}
