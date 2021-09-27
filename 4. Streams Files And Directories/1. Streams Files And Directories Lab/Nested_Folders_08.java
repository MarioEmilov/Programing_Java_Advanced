import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

public class Nested_Folders_08 {
    public static void main(String[] args) {

        Path path = Paths.get("C:\\Users\\mar_e\\Desktop\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File root =path.toFile();

        Deque<File> deque = new ArrayDeque<>();
        deque.offer(root);

        int counter = 0;
        while (!deque.isEmpty()){
            // 1. poll file
            // 2. increase counter and print file name
            // 3. take the files from current directory
            // 4. check whether inner file is directory
            // 4.1 if it's directory add it into the deque

            File file = deque.poll();
            counter++;
            System.out.println(file.getName());

            File[] files = file.listFiles();

            for (File innerFile : files){
                if (innerFile.isDirectory()){
                    deque.offer(innerFile);
                }
            }
        }
        System.out.printf("%d folders", counter);
    }
}
