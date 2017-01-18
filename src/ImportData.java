
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;

public class ImportData {


    public void writeOut(String path){
        try {
            File file = new File(path);
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;

            int rows;
            rows = sheet.getPhysicalNumberOfRows();

            int cols = 0;
            int tmp = 0;

            for(int i = 0; i < 10 || i < rows; i++) {
                row = sheet.getRow(i);
                if(row != null) {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if(tmp > cols) cols = tmp;
                }
            }

            for(int r = 0; r < rows; r++) {
                row = sheet.getRow(r);
                if(row != null) {
                    for(int c = 0; c < cols; c++) {
                        cell = row.getCell((short)c);
                        if(cell != null) {
                            switch (cell.getCellTypeEnum()) {
                                case STRING:
                                    System.out.print(cell.getStringCellValue() + "\t");
                                    break;
                                case NUMERIC:
                                    System.out.print(cell.getNumericCellValue() + "\t");
                                    break;
                                case BOOLEAN:
                                    System.out.print(cell.getBooleanCellValue() + "\t");
                                    break;
                                default:
                            }
                        }
                        if(c%3 == 2)
                            System.out.println("\n");
                    }
                }
            }
        } catch(Exception ioe) {
            ioe.printStackTrace();
        }
    }

    public void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
                writeOut(fileEntry.getAbsolutePath());
            }
        }
    }
}