import java.io.*;

public class Copy_Bytes_03 {
    public static void main(String[] args) throws IOException {

        InputStream inputStream = new FileInputStream("C:\\Users\\mar_e\\Desktop\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        OutputStream outputStream = new FileOutputStream("C:\\Users\\mar_e\\Desktop\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputAsBytes.txt");

        PrintStream out = new PrintStream(outputStream);
        int value = inputStream.read();

        while (value != -1) {
            if (value != 10 && value != 32) {
                out.print(value);
            } else {
                out.print((char) value);
            }
            value = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
