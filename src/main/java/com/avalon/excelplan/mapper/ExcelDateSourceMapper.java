package com.avalon.excelplan.mapper;

import com.avalon.excelplan.entity.po.ColumnInfo;
import com.avalon.excelplan.entity.po.TableInfo;

import java.util.List;

public interface ExcelDateSourceMapper {

    List<TableInfo> tableList(String schemeName);

    List<ColumnInfo> columnList(String schemeName, String tableName);

}
