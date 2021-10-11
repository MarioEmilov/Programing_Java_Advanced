package CatLady;

class CatImpl implements Cat{

    private String breed;

    private String name;

    public CatImpl(String name, String breed) {
        this.setName(name);
        this.setBreed(breed);
    }

    @Override
    public String getBreed() {
        return breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getBreed(), this.getName());
    }
}
