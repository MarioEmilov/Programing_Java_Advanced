import java.io.File;

public class List_Files_07 {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\mar_e\\Desktop\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File[] currentFile = file.listFiles();

        for (File f : currentFile) {
            if (!f.isDirectory()) {
                System.out.println(f.getName() + ": " + "[" + f.length() + "]");
            }
        }
    }
}
