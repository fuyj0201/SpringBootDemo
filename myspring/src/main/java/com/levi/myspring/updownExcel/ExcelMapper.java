package com.levi.myspring.updownExcel;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface ExcelMapper {

    List<user> getList();

}
