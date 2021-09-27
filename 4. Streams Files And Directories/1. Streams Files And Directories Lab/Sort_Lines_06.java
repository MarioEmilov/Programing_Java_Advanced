import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Sort_Lines_06 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\mar_e\\Desktop\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        List<String> lines = Files.readAllLines(path)
                        .stream()
                                .sorted().collect(Collectors.toList());

        Files.write(Paths.get("C:\\Users\\mar_e\\Desktop\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Sort_Lines.txt"), lines);
    }
}
