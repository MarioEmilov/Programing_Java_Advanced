package GenericSwap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
//        T temp = values.get(firstIndex);
//        values.set(firstIndex, values.get(secondIndex));
//        values.set(secondIndex, temp);
        Collections.swap(values, firstIndex, secondIndex);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : values) {
            sb.append(String.format("%s: %s", element.getClass().getName(), element.toString()))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
