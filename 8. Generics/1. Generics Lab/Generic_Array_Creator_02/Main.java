package Generic_Array_Creator_02;

import Generic_Array_Creator_02.ArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer[] integers = ArrayCreator.<Integer>create(10, 13);

        String[] strings = ArrayCreator.<String>create(String.class, 3, "Java");

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
