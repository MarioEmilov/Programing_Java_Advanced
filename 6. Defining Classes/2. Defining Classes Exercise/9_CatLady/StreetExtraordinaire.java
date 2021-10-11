package CatLady;

public class StreetExtraordinaire extends CatImpl{

    private static final String CAT_BREED = "StreetExtraordinaire";

    private double decibels;

    public StreetExtraordinaire(String name, int decibels) {
        super(name, CAT_BREED);
        this.setDecibels(decibels);
    }

    public double getDecibels() {
        return decibels;
    }

    private void setDecibels(int decibels) {
        this.decibels = decibels;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.getDecibels());
    }
}
