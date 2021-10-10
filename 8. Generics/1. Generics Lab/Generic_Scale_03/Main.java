package Generic_Scale_03;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(13, 42);
        System.out.println(scale.getHeavier());
        System.out.println(new Scale<>("A", "Z").getHeavier());
        System.out.println(new Scale<>( 13, 42).getHeavier());
        System.out.println(new Scale<>( 13.5, 14.5).getHeavier());
        System.out.println(new Scale<>( 14.5, 14.5).getHeavier());
    }

    public static <T extends Comparable<T>> T getGreater(T first, T second) {
        int result = first.compareTo(second);
        return result >= 0 ? first : second;
    }
}
