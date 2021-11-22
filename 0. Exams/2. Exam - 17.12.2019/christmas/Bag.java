package Exam_17_12_2019.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getColor() {
        return color;
    }

    public  int count(){
        return this.data.size();
    }

    public void add(Present present) {
        if (this.getCapacity() > this.data.size()){
            this.data.add(present);
        }
    }
    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Present heaviestPresent(){
        Present present2 = this.data.stream()
                .max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
        return present2;
    }
    public Present getPresent(String name){
        Present present2 = this.data.stream().filter(e-> e.getName().equals(name)).findFirst().orElse(null);
        return present2;
    }

    public String report() {
        StringBuilder out = new StringBuilder();

        out.append(this.getColor()).append(" bag contains:").append(System.lineSeparator());

        for (Present present : data) {

            out.append(present.toString())
                    .append(System.lineSeparator());

        }

        return  out.toString().trim();
    }
}
