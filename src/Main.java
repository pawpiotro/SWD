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
        String path = chooser.getSelectedFile().getAbsolutePath();

        SWD okno = new SWD();

        CaseHolder data = new CaseHolder();
        ImportData imp = new ImportData(data);

        final File folder = new File(path);
        imp.importFilesFromFolder(folder);
        data.printAll();
        System.out.println("-------------------------------");
        DecisionSupport decision = new DecisionSupport(data);
        int a = decision.makeDecision(0.5f, 500000, 0.01f);
        switch(a){
            case 0:
                System.out.println("Znaleziono.");
                break;
            case 1:
                System.out.println("Niepoprawne dane. (ryzyko)");
                break;
            case 2:
                System.out.println("Znaleziono, po zwiekszeniu ryzyka");
                break;
            default:
        }
    }
}