package Exam_26_06_2021.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        int index = findIndex(name);
        if (index != -1) {
            data.remove(index);
            return true;
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder build = new StringBuilder(" The grooming salon has the following clients:" + System.lineSeparator());
        for (Pet pet : data) {
            build.append(pet.getName() + " " + pet.getOwner() + System.lineSeparator());
        }
        return build.toString().trim();
    }

    private int findIndex(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
