package com.premiumminds.internship.teknonymy;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class PersonTest {

    private final Pair<Person,Integer> greatGreatGreatGrandson = Pair.of(new Person("Markie Junior the second the first", 'M', null, LocalDateTime.of(1160, 1, 1, 0, 0)),5);
    private final Pair<Person,Integer> greatGreatGrandson = Pair.of(new Person("Markie Junior the second", 'M', null, LocalDateTime.of(1120, 1, 1, 0, 0)),4);
    private final Pair<Person,Integer> greatGrandson = Pair.of(new Person("Markie Junior", 'M', new Person[]{greatGreatGrandson.getKey()}, LocalDateTime.of(1099, 1, 1, 0, 0)),3);
    private final Pair<Person,Integer> grandson = Pair.of(new Person("Markie", 'M', new Person[]{greatGrandson.getKey()}, LocalDateTime.of(1076, 1, 1, 0, 0)),2);
    private final Pair<Person,Integer> child = Pair.of(new Person("Mark", 'M', new Person[]{grandson.getKey()}, LocalDateTime.of(1046, 1, 1, 0, 0)),1);
    private final Person father = new Person("Lemur", 'M', new Person[]{child.getKey()}, LocalDateTime.of(1016, 1, 1, 0, 0));
    private final  Person mother = new Person("Lemura", 'F', new Person[]{child.getKey()}, LocalDateTime.of(1016, 1, 1, 0, 0));

    @Test
    public void fatherTest() {
        assertEquals("father of Mark; ", father.getCorrectTeknonymy(child));
    }

    @Test
    public void grandfatherTest() {
        assertEquals("grandfather of Markie; ", father.getCorrectTeknonymy(grandson));
    }

    @Test
    public void greatGrandfatherTest() {
        assertEquals("great-grandfather of Markie Junior; ", father.getCorrectTeknonymy(greatGrandson));
    }

    @Test
    public void greatGreatGrandfatherTest() {
        assertEquals("great-great-grandfather of Markie Junior the second; ", father.getCorrectTeknonymy(greatGreatGrandson));
    }

    @Test
    public void greatGreatGreatGrandfatherTest() {
        assertEquals("great-great-great-grandfather of Markie Junior the second the first; ", father.getCorrectTeknonymy(greatGreatGreatGrandson));
    }

    @Test
    public void greatGreatGreatGrandmotherTest() {
        assertEquals("great-great-great-grandmother of Markie Junior the second the first; ", mother.getCorrectTeknonymy(greatGreatGreatGrandson));
    }
}
