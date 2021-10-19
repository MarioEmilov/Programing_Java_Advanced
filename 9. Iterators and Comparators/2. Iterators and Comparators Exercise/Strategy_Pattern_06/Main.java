package Strategy_Pattern_06;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<Person> comparedByName = new TreeSet<>(new PersonNameComparator());
        Set<Person> comparedByAge = new TreeSet<>(new PersonAgeComparator());

        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]));
            comparedByName.add(person);
            comparedByAge.add(person);

        }

        comparedByName.forEach(System.out::println);
        comparedByAge.forEach(System.out::println);
    }
}
