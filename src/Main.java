import java.io.File;
import Data.*;
/**
 * Created by blank on 1/18/2017.
 */
public class Main {



    public static void main(String[] args) {
        CaseHolder data = new CaseHolder();
        ImportData imp = new ImportData(data);
        String path = "D:\\Users\\Pawel\\Downloads\\WDEC_symulacja\\DANE\\";
        final File folder = new File(path);
        imp.importFilesFromFolder(folder);
        data.printAll();
    }
}