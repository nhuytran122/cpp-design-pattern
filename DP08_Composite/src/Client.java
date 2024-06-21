import java.util.ArrayList;
import java.util.Arrays;

public class Client {
 
    public static void main(String[] args) {
        FileComponent file1 = new FileLeaf("file 1", 10);
        FileComponent file2 = new FileLeaf("file 2", 5);
        FileComponent file3 = new FileLeaf("file 3", 12);
 
        ArrayList<FileComponent> files = new ArrayList<>(Arrays.asList(file1, file2, file3));
        FileComponent folder = new FolderComposite(files);
        folder.showProperty();
        System.out.println("Total Size: " + folder.totalSize());
    }
}