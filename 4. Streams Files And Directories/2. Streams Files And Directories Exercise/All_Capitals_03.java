import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class All_Capitals_03 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\mar_e\\Desktop\\Java Advanced\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        // Files.readAllLines(Path.of(path))
        //      .forEach(str -> System.out.println(str.toUpperCase()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\mar_e\\Desktop\\Java Advanced\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));
        // FileOutputStream outputStream = new FileOutputStream("output.txt");
        Files.readAllLines(Path.of(path))
                .forEach(str -> {
                    try {
                        writer.write(str.toUpperCase());
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        writer.close();
    }
}
