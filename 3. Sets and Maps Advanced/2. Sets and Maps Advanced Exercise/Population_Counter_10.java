import java.util.LinkedHashMap;
import java.util.Scanner;

public class Population_Counter_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> demographicData = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"report".equals(input)) {
            String[] tokens = input.split("[\\|]");
            String country = tokens[1];
            String city = tokens[0];
            long population = Long.parseLong(tokens[2]);

            demographicData.putIfAbsent(country, new LinkedHashMap<>());
            demographicData.get(country).put(city, population);

            input = scanner.nextLine();
        }

        demographicData.entrySet()
                .stream()
                .sorted((a, b) -> {
                    long sumA = a.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    long sumB = b.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    return Long.compare(sumB, sumA);
                })
                .forEach(country -> {
                    long totalPopulation = country.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    System.out.printf("%s (total population: %d)%n", country.getKey(), totalPopulation);
                    country.getValue()
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                            .forEach(city -> {
                                System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
                            });
                });
    }
}
