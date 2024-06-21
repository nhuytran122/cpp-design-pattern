import java.util.ArrayList;

public class FolderComposite implements FileComponent {
 
    private ArrayList<FileComponent> files = new ArrayList<>();
 
    public FolderComposite(ArrayList<FileComponent> files) {
        this.files = files;
    }
 
    @Override
    public void showProperty() {
        for (FileComponent file : files) {
            file.showProperty();
        }
    }
 
    @Override
    public long totalSize() {
        long total = 0;
        for (FileComponent file : files) {
            total += file.totalSize();
        }
        return total;
    }
}