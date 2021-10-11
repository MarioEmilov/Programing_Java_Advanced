package CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr =  new BufferedReader(new InputStreamReader(System.in));

        List<Cat> cats = new ArrayList<>();

        String[] input = bfr.readLine().split(" ");

        while (!input[0].equals("End")){
            if (input[0].equals("Siamese")){
                cats.add(new Siamese(input[1], Integer.parseInt(input[2])));
            } else if (input[0].equals("Cymric")){
                cats.add(new Cymric(input[1], Integer.parseInt(input[2])));
            } else {
                cats.add(new StreetExtraordinaire(input[1], Integer.parseInt(input[2])));
            }

            input = bfr.readLine().split(" ");
        }

        String catName = bfr.readLine();

        for (Cat cat : cats) {
            if (cat.getName().equals(catName)){
                System.out.println(cat.toString());
                break;
            }
        }
    }
}
