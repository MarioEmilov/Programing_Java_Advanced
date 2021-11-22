package Exam_12_10_2021.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        return roster.removeIf(person -> person.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : this.roster) {
            if (person.getName().equals(name) && person.getHometown(hometown).equals(hometown)) {
                return person;
            }
        }
        return null;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("The people in the hotel ").append(this.name).append(" are:").append(System.lineSeparator());
        for (Person person : this.roster) {
            builder.append(person.toString()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
