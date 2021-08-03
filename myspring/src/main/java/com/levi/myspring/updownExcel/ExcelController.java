package com.levi.myspring.updownExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private ExcelServiceImpl excelServiceImpl;

    @RequestMapping(value = "/downloadExcel")
    public void download (HttpServletRequest req, HttpServletResponse res){
        //获取实体对象列表
        List<user> excelList = excelServiceImpl.getExcelList();
        //告诉浏览器导出的是xlsx文件
        res.setContentType("application/x-excel");
        res.setCharacterEncoding("UTF-8");

        try{
            /*设置响应头中文件传输属性：
            attachment: 附件形式 filename 设置附件文件名
            inline: 在线打开
             */
            res.setHeader("Content-disposition", "attachment; filename=" + java.net.URLEncoder.encode("导出Excel", "UTF-8") + ".xlsx");

            int serialNumber = 0;
            int rowMaxCache = 100;
            SXSSFWorkbook wb = new SXSSFWorkbook(rowMaxCache);
            Sheet sheet = wb.createSheet();
            int index = 0;
            int total = 0;
            Row row = sheet.createRow(index++);
            Cell cell = null;
            int i = 0;
            //设置表头
            cell = row.createCell(i++);
            cell.setCellValue("serialNumber");
            cell = row.createCell(i++);
            cell.setCellValue("name");
            cell = row.createCell(i++);
            cell.setCellValue("sex");
            cell = row.createCell(i++);
            cell.setCellValue("age");
            cell = row.createCell(i++);
            cell.setCellValue("password");
            //逐行插入数据
            for (com.levi.myspring.updownExcel.user user : excelList) {
                int y = 0;
                total++;
                serialNumber++;
                row = sheet.createRow(index++);
                cell = row.createCell(y++);
                cell.setCellValue(serialNumber);
                cell = row.createCell(y++);
                cell.setCellValue(user.getName());
                cell = row.createCell(y++);
                //考虑添性别字典项
                cell.setCellValue(user.getSex());
                cell = row.createCell(y++);
                cell.setCellValue(user.getAge());
                cell = row.createCell(y++);
                cell.setCellValue(user.getPsw());
                //行数达到缓存数量时存入硬盘
                if (total % rowMaxCache == 0) {
                    ((SXSSFSheet) sheet).flushRows();
                }
            }
            //通过输出流输出
            wb.write(res.getOutputStream());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/getAll")
    public List<user> getAll (){
        List<user> userL = excelServiceImpl.getExcelList();
        return userL;
    }
}
