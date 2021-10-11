package CatLady;

public class Cymric extends CatImpl{

    private static final String CAT_BREED = "Cymric";

    private double furLength;

    public Cymric(String name, int furlenght) {
        super(name, CAT_BREED);
        this.setFurLength(furlenght);
    }

    public double getFurLength() {
        return furLength;
    }

    private void setFurLength(double furLength) {
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.getFurLength());
    }
}
