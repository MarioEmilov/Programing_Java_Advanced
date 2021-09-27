import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Extract_Integers_04 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\mar_e\\Desktop\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt"));

        PrintWriter output = new PrintWriter("C:\\Users\\mar_e\\Desktop\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\extract_integers.txt");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                output.println(scanner.nextInt());
            }
            scanner.next();
        }
        output.close();
    }
}
