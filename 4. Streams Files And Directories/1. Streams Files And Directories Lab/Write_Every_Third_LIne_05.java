import java.io.*;

public class Write_Every_Third_LIne_05 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\mar_e\\Desktop\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = reader.readLine();

        BufferedWriter writer = new BufferedWriter(new PrintWriter("C:\\Users\\mar_e\\Desktop\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Write_Every_Third_Line.txt"));

        int counter = 1;
        while (line != null) {
            if (counter % 3 == 0) {
                writer.write(line + System.lineSeparator());
            }
            line = reader.readLine();
            counter++;
        }
        writer.close();
    }
}
