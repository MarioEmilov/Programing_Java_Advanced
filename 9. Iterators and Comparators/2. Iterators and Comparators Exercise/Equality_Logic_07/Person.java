package Equality_Logic_07;

import java.util.Objects;

public final class Person implements Comparable<Person> {
    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

    @Override
    public boolean equals(Object o) {
//            return true; // all objects with the same hash are considered the same (in HashSet)
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
//            return 1; // All objects have the same hash (in HashSet)
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person person) {
//            return 0; // all objects are considered equal for ordering (in TreeSet)
        int cmp = name.compareTo(person.name);
        return cmp != 0
                ? cmp
                : Integer.compare(age, person.age);
    }
}

