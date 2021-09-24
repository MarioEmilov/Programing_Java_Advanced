import java.util.*;

public class Cities_by_Continent_and_Country_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> countries = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            countries.putIfAbsent(tokens[0], new LinkedHashMap<>());
            countries.get(tokens[0]).putIfAbsent(tokens[1], new ArrayList<>());
            countries.get(tokens[0]).get(tokens[1]).add(tokens[2]);
        }

        countries.forEach((key, value) ->{
            System.out.println(key + ":");
            value.forEach((innerKey, innerValue) -> {
                System.out.println("  " + innerKey + " -> "
                        + String.join(", ", innerValue));
            });
        });
    }
}
