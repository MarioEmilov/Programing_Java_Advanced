package CatLady;

public class Siamese extends CatImpl{

    private static final String CAT_BREED = "Siamese";

    private double earSize;

    public Siamese(String name, int earSize) {
        super(name, CAT_BREED);
        this.setEarSize(earSize);
    }

    public double getEarSize() {
        return earSize;
    }

    private void setEarSize(int earSize) {
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.getEarSize());
    }
}
