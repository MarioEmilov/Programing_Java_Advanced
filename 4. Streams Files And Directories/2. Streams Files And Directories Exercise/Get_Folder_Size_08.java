import java.io.File;

public class Get_Folder_Size_08 {
    public static void main(String[] args) {
        String path = "C:\\Users\\mar_e\\Desktop\\Java Advanced\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);

        int folderSize = 0;
        for (File file : folder.listFiles()) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);

    }
}
