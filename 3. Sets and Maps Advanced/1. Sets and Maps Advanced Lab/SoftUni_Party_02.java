import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUni_Party_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> guests = new TreeSet<>();

        String guest = scanner.nextLine();

        while (!guest.equals("PARTY")) {
            guests.add(guest);
            guest = scanner.nextLine();
        }
        guest = scanner.nextLine();

        while (!guest.equals("END")) {
            guests.remove(guest);
            guest = scanner.nextLine();
        }
        System.out.println(guests.size());
        System.out.println(String.join(System.lineSeparator(), guests));
    }
}
