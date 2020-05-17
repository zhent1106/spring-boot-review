package com.soft1851.springboot.task.util;

import com.soft1851.springboot.task.model.T_Student;
import com.soft1851.springboot.task.repository.StudentRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FileUtil
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/17
 **/
@Component
public class FileUtil {
    @Resource
    private StudentRepository studentRepository;

    public  void getMessage(){

        //开始获取数据
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
                    if (j==1){
                        TStudentList.add(T_Student.builder().username(cell.toString()).build());
                        System.out.println(cell.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        studentRepository.saveAll(TStudentList);
    }

}