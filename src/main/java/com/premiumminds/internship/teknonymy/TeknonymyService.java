package com.premiumminds.internship.teknonymy;

import java.util.ArrayDeque;
import java.util.Deque;

class TeknonymyService implements ITeknonymyService {

    private static class PersonInfo {
        Person person;
        int level;

        PersonInfo(Person person, int level) {
            this.person = person;
            this.level = level;
        }
    }

    private static final int genWhereUStartToBeGreat = 3;

    /**
     * Method to get a Person Teknonymy Name
     *
     * @param person Person
     * @return String which is the Teknonymy Name
     */
    public String getTeknonymy(Person person) {
        if (person == null) {
            return null;
        }
        if(person.children() == null){
            return "";
        }

        Deque<PersonInfo> stack = new ArrayDeque<>();
        stack.push(new PersonInfo(person, 0));

        PersonInfo oldest = null;

        while (!stack.isEmpty()) {
            PersonInfo currentPersonInfo = stack.pop();
            Person currentPerson = currentPersonInfo.person;
            Person[] children = currentPerson.children();
            int currGen = currentPersonInfo.level;

            if (children != null) {
                for (Person currChild : children) {
                    PersonInfo currentChildGen = new PersonInfo(currChild, currGen + 1);
                    stack.push(currentChildGen);
                }
            } else {
                if (oldest == null || currGen > oldest.level ||
                        (currGen == oldest.level && currentPerson.dateOfBirth().isBefore(oldest.person.dateOfBirth()))) {
                    oldest = new PersonInfo(currentPerson, currGen);
                }
            }
        }
        if (oldest == null) return ""; else return getCorrectTeknonymy(person, oldest);
    }

    /**
     * From a given person and its generation calculates the teknonymy for this person
     *
     * @param mainPerson   person at the top of tree
     * @param personAndGen pair of the person and its generation to compare
     * @return correct teknonymy of the person
     */
    private String getCorrectTeknonymy(Person mainPerson, PersonInfo personAndGen) {
        int currGen = personAndGen.level;
        Person currPerson = personAndGen.person;
        String newTeknonymy = (currGen >= genWhereUStartToBeGreat) ?
                "great-".repeat(currGen - genWhereUStartToBeGreat + 1) :
                "";
        switch (mainPerson.sex()) {
            case 'M':
                newTeknonymy += (currGen == 1) ? "father of " : "grandfather of ";
                break;
            case 'F':
                newTeknonymy += (currGen == 1) ? "mother of " : "grandmother of ";
                break;
        }
        return newTeknonymy + currPerson.name();
    }
}
