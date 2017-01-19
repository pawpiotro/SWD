package Data;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;

public class ImportData {

    CaseHolder data;
    public ImportData(CaseHolder data1){
        data = data1;
    }

    public void importDataFromFile(String path){
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
            Case tmp1 = new Case();
            int sprzedaz = 0;
            for(int r = 0; r < rows; r++) {
                row = sheet.getRow(r);
                if(row != null) {
                    for(int c = 0; c < cols; c++) {
                        cell = row.getCell((short)c);
                        if(cell != null) {
                            switch (cell.getCellTypeEnum()) {
                                case STRING:
                                    //System.out.print(cell.getStringCellValue() + "\t");
                                    break;
                                case NUMERIC:
                                    if(c == 1){
                                        switch(r){
                                            case 4: tmp1.setGotowka((float)cell.getNumericCellValue());
                                                break;
                                            case 5: tmp1.setWolumen((int)cell.getNumericCellValue());
                                                break;
                                            case 6: tmp1.setJakosc((int)cell.getNumericCellValue());
                                                break;
                                            case 7: tmp1.setCena((float)cell.getNumericCellValue());
                                                break;
                                            case 8: tmp1.setReklamaInt((float)cell.getNumericCellValue());
                                                break;
                                            case 9: tmp1.setReklamaTV((float)cell.getNumericCellValue());
                                                break;
                                            case 10: tmp1.setReklamaMag((float)cell.getNumericCellValue());
                                            default:
                                        }
                                    }
                                    if(c == 2){
                                        switch(r){
                                            case 3: tmp1.setZysk((float)cell.getNumericCellValue());
                                                break;
                                            case 1: sprzedaz = (int)cell.getNumericCellValue();
                                                break;
                                            default:
                                        }
                                    }
                                    //System.out.print(cell.getNumericCellValue() + "\t");
                                    break;
                                case BOOLEAN:
                                    //System.out.print(cell.getBooleanCellValue() + "\t");
                                    break;
                                default:
                            }
                        }
                        //if(c%3 == 2)
                            //System.out.println("\n");
                    }
                }
            }
            tmp1.setRyzyko((float)(tmp1.getWolumen()-sprzedaz)/tmp1.getWolumen());
            data.getCases().add(tmp1);
        } catch(Exception ioe) {
            ioe.printStackTrace();
        }
    }

    public void importFilesFromFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                importFilesFromFolder(fileEntry);
            } else {
                //System.out.println(fileEntry.getName());
                importDataFromFile(fileEntry.getAbsolutePath());
            }
        }
    }
}