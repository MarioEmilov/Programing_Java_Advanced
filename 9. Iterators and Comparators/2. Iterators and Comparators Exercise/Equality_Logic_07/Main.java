package Equality_Logic_07;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person theSetContractBreaker = new Person("Ivan", 22);

        List<Person> people = List.of(
                new Person("Ivan", 17),
                new Person("ivan", 17),
                new Person("Stoqn", 25),
                new Person("Ivan", 18),
                new Person("Ivan", 17),
                new Person("Stopn", 25),
                new Person("Stoqn", 25),
                theSetContractBreaker
        );

        Set<Person> treeSet = new TreeSet<>(people);
        Set<Person> hashSet = new HashSet<>(people);

        System.out.println(treeSet.size() + ": " + treeSet.stream()
                .map(Person::toString).collect(Collectors.joining(", ")));
        System.out.println(hashSet.size() + ": " + hashSet.stream()
                .map(Person::toString).collect(Collectors.joining(", ")));

//        Uncomment following lines of code to break set contract:
//        there will be 2 "Ivan 17" objects in each set
/*
        System.out.println("Changing \"Ivan 22\" to \"Ivan 17\"");

        theSetContractBreaker.age = 17;

        System.out.println(treeSet.size() + ": " + treeSet.stream()
                .map(Person::toString).collect(Collectors.joining(", ")));
        System.out.println(hashSet.size() + ": " + hashSet.stream()
                .map(Person::toString).collect(Collectors.joining(", ")));
*/
    }
}
