package com.premiumminds.internship.teknonymy;

import java.util.ArrayDeque;
import java.util.Deque;

import org.apache.commons.lang3.tuple.Pair;

class TeknonymyService implements ITeknonymyService {

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

        StringBuilder teknonymy = new StringBuilder();

        Deque<Pair<Person, Integer>> stack = new ArrayDeque<>();
        stack.push(Pair.of(person,0));

        while (!stack.isEmpty()) {
            Pair<Person,Integer> currentPerson = stack.pop();
            Person[] children = currentPerson.getKey().children();

            if (children != null) {
                for (Person currChild : children) {
                    Pair<Person,Integer> currentChildGen = Pair.of(currChild, currentPerson.getValue()+1);
                    stack.addLast(currentChildGen);
                    teknonymy.append(person.getCorrectTeknonymy(currentChildGen));
                }
            }
        }

        return teknonymy.toString();
    }
}
