package com.soft1851.springboot.task.util;

import com.soft1851.springboot.task.model.T_Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

class FileUtilTest {
    public static void main(String[] args) {
        List<T_Student> TStudentList = new ArrayList<>();
        Workbook wb =null;
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\test.xlsx");
            wb = new XSSFWorkbook(fileInputStream);
            Sheet sheet = wb.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for (int i = 0; i <= rowNum; i++) {
                Row row = sheet.getRow(i);
                int colNum = row.getLastCellNum();
                for (int j = 0; j < colNum; j++) {
                    Cell cell = row.getCell(j);
                    if (j==3){
                        TStudentList.add(T_Student.builder().username(cell.toString()).build());
                        System.out.println(cell.toString());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}