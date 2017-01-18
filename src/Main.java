import java.io.File;

/**
 * Created by blank on 1/18/2017.
 */
public class Main {



    public static void main(String[] args) {
        ImportData imp = new ImportData();
        String path = "";
        final File folder = new File(path);
        imp.listFilesForFolder(folder);
    }
}