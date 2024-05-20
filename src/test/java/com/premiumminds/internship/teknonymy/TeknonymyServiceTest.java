package com.premiumminds.internship.teknonymy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


@RunWith(JUnit4.class)
public class TeknonymyServiceTest {

    /**
     * The corresponding implementations to test.
     * <p>
     * If you want, you can make others :)
     */
    public TeknonymyServiceTest() {
    }

    ;

    @Test
    public void PersonNoChildrenTest() {
        Person person = new Person("John", 'M', null, LocalDateTime.of(1046, 1, 1, 0, 0));
        String result = new TeknonymyService().getTeknonymy(person);
        String expected = "";
        assertEquals(expected, result);
    }

    @Test
    public void PersonOneChildTest() {
        Person person = new Person(
                "John",
                'M',
                new Person[]{new Person("Holy", 'F', null, LocalDateTime.of(1046, 1, 1, 0, 0))},
                LocalDateTime.of(1046, 1, 1, 0, 0));
        String result = new TeknonymyService().getTeknonymy(person);
        String expected = "father of Holy";
        assertEquals(expected, result);
    }

    @Test
    public void PersonTwoChildTest() {
        Person person = new Person(
                "John",
                'M',
                new Person[]{
                        new Person("Holy", 'F', null, LocalDateTime.of(1046, 1, 1, 0, 0)),
                        new Person("Molly", 'F', null, LocalDateTime.of(1047, 1, 1, 0, 0))
                },
                LocalDateTime.of(1046, 1, 1, 0, 0));
        String result = new TeknonymyService().getTeknonymy(person);
        String expected = "father of Holy";
        assertEquals(expected, result);
    }

    @Test
    public void PersonThreeChildTest() {
        Person person = new Person(
                "John",
                'M',
                new Person[]{
                        new Person("Holy", 'F', null, LocalDateTime.of(1046, 1, 1, 0, 0)),
                        new Person("Molly", 'F', null, LocalDateTime.of(1047, 1, 1, 0, 0)),
                        new Person("Dolly", 'F', null, LocalDateTime.of(1048, 1, 1, 0, 0)),
                },
                LocalDateTime.of(1046, 1, 1, 0, 0));
        String result = new TeknonymyService().getTeknonymy(person);
        String expected = "father of Holy";
        assertEquals(expected, result);
    }

    @Test
    public void PersonThreeChildThreeGrandchildTest() {
        Person person = new Person(
                "John",
                'M',
                new Person[]{
                        new Person("Holy", 'F',
                                new Person[]{
                                        new Person("Hanz", 'F', null, LocalDateTime.of(1067, 1, 1, 0, 0)),
                                        new Person("Franz", 'F', null, LocalDateTime.of(1068, 1, 1, 0, 0)),
                                        new Person("Polibanz", 'F', null, LocalDateTime.of(1069, 1, 1, 0, 0))},
                                LocalDateTime.of(1046, 1, 1, 0, 0)),
                        new Person("Molly", 'F', null, LocalDateTime.of(1047, 1, 1, 0, 0)),
                        new Person("Dolly", 'F', null, LocalDateTime.of(1048, 1, 1, 0, 0)),
                },
                LocalDateTime.of(1046, 1, 1, 0, 0));
        String result = new TeknonymyService().getTeknonymy(person);
        String expected = "grandfather of Hanz";
        assertEquals(expected, result);
    }

    @Test
    public void PersonThreeChild6GrandchildTest() {
        Person person = new Person(
                "John",
                'M',
                new Person[]{
                        new Person("Holy", 'F',
                                new Person[]{
                                        new Person("Hanz", 'M', null, LocalDateTime.of(1067, 1, 1, 0, 0)),
                                        new Person("Franz", 'M', null, LocalDateTime.of(1068, 1, 1, 0, 0)),
                                        new Person("Polibanz", 'M', null, LocalDateTime.of(1069, 1, 1, 0, 0))},
                                LocalDateTime.of(1046, 1, 1, 0, 0)),
                        new Person("Molly", 'F',
                                new Person[]{
                                        new Person("Billy", 'F', null, LocalDateTime.of(1070, 1, 1, 0, 0)),
                                        new Person("Milly", 'F', null, LocalDateTime.of(1071, 1, 1, 0, 0)),
                                        new Person("Lilly", 'F', null, LocalDateTime.of(1072, 1, 1, 0, 0))},
                                LocalDateTime.of(1047, 1, 1, 0, 0)),
                        new Person("Dolly", 'F',
                                new Person[]{
                                        new Person("Rosie", 'F', null, LocalDateTime.of(1073, 1, 1, 0, 0)),
                                        new Person("Julie", 'F', null, LocalDateTime.of(1074, 1, 1, 0, 0)),
                                        new Person("Sophie", 'F', null, LocalDateTime.of(1075, 1, 1, 0, 0))},
                                LocalDateTime.of(1048, 1, 1, 0, 0)),
                },
                LocalDateTime.of(1046, 1, 1, 0, 0));
        String result = new TeknonymyService().getTeknonymy(person);
        String expected = "grandfather of Hanz";
        assertEquals(expected, result);
    }

    @Test
    public void BigFamily() {
        Person person = new Person(
                "John",
                'M',
                new Person[]{
                        new Person("Holy", 'F',
                                new Person[]{
                                        new Person("Hanz", 'M',
                                                new Person[]{
                                                        new Person("Daisy", 'F',
                                                                new Person[]{
                                                                        new Person("Maggie", 'F', null, LocalDateTime.of(1107, 1, 1, 1, 0)),
                                                                        new Person("Cassie", 'F', null, LocalDateTime.of(1107, 1, 1, 0, 0))},
                                                                LocalDateTime.of(1100, 1, 1, 0, 0)),
                                                        new Person("Lacy", 'F', null, LocalDateTime.of(1101, 1, 1, 0, 0)),
                                                        new Person("Macy", 'F', null, LocalDateTime.of(1102, 1, 1, 0, 0))},
                                                LocalDateTime.of(1067, 1, 1, 0, 0)),
                                        new Person("Franz", 'M',
                                                new Person[]{
                                                        new Person("Hattie", 'F', null, LocalDateTime.of(1106, 1, 1, 0, 0))},
                                                LocalDateTime.of(1068, 1, 1, 0, 0)),
                                        new Person("Polibanz", 'M',
                                                new Person[]{
                                                        new Person("Cindy", 'F', null, LocalDateTime.of(1103, 1, 1, 0, 0)),
                                                        new Person("Mindy", 'F', null, LocalDateTime.of(1104, 1, 1, 0, 0)),
                                                        new Person("Tiffany", 'F', null, LocalDateTime.of(1105, 1, 1, 0, 0))},
                                                LocalDateTime.of(1069, 1, 1, 0, 0))},
                                LocalDateTime.of(1046, 1, 1, 0, 0)),
                        new Person("Molly", 'F',
                                new Person[]{
                                        new Person("Billy", 'F',
                                                new Person[]{
                                                        new Person("Abby", 'F', null, LocalDateTime.of(1108, 1, 1, 0, 0)),
                                                        new Person("Fanny", 'F', null, LocalDateTime.of(1109, 1, 1, 0, 0)),
                                                        new Person("Brandy", 'F', null, LocalDateTime.of(1110, 1, 1, 0, 0))},
                                                LocalDateTime.of(1070, 1, 1, 0, 0)),
                                        new Person("Milly", 'F',
                                                new Person[]{
                                                        new Person("Emma", 'F', null, LocalDateTime.of(1111, 1, 1, 0, 0)),
                                                        new Person("Gemma", 'F', null, LocalDateTime.of(1112, 1, 1, 0, 0))},
                                                LocalDateTime.of(1071, 1, 1, 0, 0)),
                                        new Person("Lilly", 'F',
                                                new Person[]{
                                                        new Person("Giulia", 'F',
                                                                new Person[]{
                                                                        new Person("Rosie", 'F',
                                                                                new Person[]{
                                                                                        new Person("Julie", 'F',
                                                                                                new Person[]{
                                                                                                        new Person("Sophie", 'F', null, LocalDateTime.of(1075, 1, 1, 0, 0))}, LocalDateTime.of(1074, 1, 1, 0, 0)),
                                                                                        new Person("Mark", 'M', null, LocalDateTime.of(1075, 1, 1, 0, 0))}, LocalDateTime.of(1073, 1, 1, 0, 0)),},
                                                                LocalDateTime.of(1113, 1, 1, 0, 0)),
                                                        new Person("Livia", 'F', null, LocalDateTime.of(1114, 1, 1, 0, 0))},
                                                LocalDateTime.of(1072, 1, 1, 0, 0))},
                                LocalDateTime.of(1047, 1, 1, 0, 0)),
                        new Person("Dolly", 'F', null, LocalDateTime.of(1048, 1, 1, 0, 0)),
                },
                LocalDateTime.of(1046, 1, 1, 0, 0));
        String result = new TeknonymyService().getTeknonymy(person);
        String expected = "great-great-great-great-grandfather of Sophie";
        assertEquals(expected, result);
    }
}