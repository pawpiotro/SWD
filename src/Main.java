import java.io.File;
import Data.*;
import DecisionSupport.*;

import javax.swing.*;

/**
 * Created by blank on 1/18/2017.
 */
public class Main {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }

        CaseHolder data = new CaseHolder();
        ImportData imp = new ImportData(data);
        String path = chooser.getSelectedFile().getAbsolutePath();
        final File folder = new File(path);
        imp.importFilesFromFolder(folder);
        data.printAll();
        System.out.println("-------------------------------");
        DecisionSupport decision = new DecisionSupport(data);
        decision.makeDecision(0.1f, 500000);
    }
}