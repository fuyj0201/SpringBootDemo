package com.levi.myspring.updownExcel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelServiceImpl {

    @Autowired
    private ExcelMapper excelMapper;

    public List<user> getExcelList(){
        List<user> userList = excelMapper.getList();
        return userList;
    }
}
