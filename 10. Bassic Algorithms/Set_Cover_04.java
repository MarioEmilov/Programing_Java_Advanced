import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Set_Cover_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = reader.readLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }
        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }
        List<int[]> chosenSets = chooseSets(sets, universe);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        for (int[] set : chosenSets) {
            sb.append("{ ");
            sb.append(Arrays.toString(set).replaceAll("\\[|]", ""));
            sb.append(" }").append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        // TODO
        List<int[]> chosenSets = new ArrayList<>();

        Set<Integer> universeSet = Arrays
                .stream(universe)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        Set<Integer> usedSets = new HashSet<>();

        while (!universeSet.isEmpty()) {
            int bestIndex = -1;
            int bestMatches = 0;

            for (int index = 0; index < sets.size(); index++) {
                if (usedSets.contains(index)) {
                    continue;
                }

                int currentMatches = 0;
                for (int number : sets.get(index)) {
                    if (universeSet.contains(number)) {
                        currentMatches++;
                    }
                }

                if (currentMatches > bestMatches) {
                    bestMatches = currentMatches;
                    bestIndex = index;
                }
            }

            if (bestIndex >= 0) {
                usedSets.add(bestIndex);

                int[] set = sets.get(bestIndex);

                chosenSets.add(set);

                for (int number : set) {
                    universeSet.remove(number);
                }
            } else {
                throw new IllegalArgumentException();
            }
        }

        return chosenSets;
    }
}
