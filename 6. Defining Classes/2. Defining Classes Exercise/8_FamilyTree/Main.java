package FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String personId = reader.readLine();

        List<Person> people = new ArrayList<>();
        Map<String, List<String>> parentChildren = new LinkedHashMap<>();

        reader.lines()
                .takeWhile(line -> !"End".equals(line))
                .forEach(line -> {
                    if (line.contains(" - ")) {
                        String[] tokens = line.split(" - ");
                        String parentId = tokens[0];
                        String childId = tokens[1];
                        parentChildren.putIfAbsent(parentId, new ArrayList<>());
                        parentChildren.get(parentId).add(childId);
                    } else {
                        String[] tokens = line.split("\\s+");
                        String name = tokens[0] + " " + tokens[1];
                        String birthDate = tokens[2];
                        people.add(new Person(name, birthDate));
                    }
                });

        parentChildren.forEach((parentId, children) -> {
            Person parent = findPerson(people, parentId);

            children.stream()
                    .map(childId -> findPerson(people, childId))
                    .forEach(parent::addChild);
        });

        Person forPerson = findPerson(people, personId);

        System.out.println(getFamilyTreeFor(forPerson));
    }

    private static Person findPerson(List<Person> people, String personId) {
        return people.stream()
                .filter(person -> person.getBirthDate().equals(personId) || person.getName().equals(personId))
                .findFirst()
                .orElseThrow();
    }

    public static String getFamilyTreeFor(Person person) {
        return new StringBuilder()
                .append(person.toString()).append(System.lineSeparator())
                .append("Parents:").append(System.lineSeparator())
                .append(person.getParents().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .append(person.getParents().isEmpty() ? "" : System.lineSeparator())
                .append("Children:").append(System.lineSeparator())
                .append(person.getChildren().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .toString();
    }
}
