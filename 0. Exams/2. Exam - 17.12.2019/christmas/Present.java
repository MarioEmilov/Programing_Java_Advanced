package Exam_17_12_2019.christmas;

public class Present {
    private String name;
    private String gender;
    private double weight;

    public Present(String name, double weight, String gender) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Present " + this.getName() + " (" + String.format("%.2f",this.getWeight()) + ") for a " +this.getGender().trim();
    }
}
