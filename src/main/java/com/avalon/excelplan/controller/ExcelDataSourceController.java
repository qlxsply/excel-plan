package com.avalon.excelplan.controller;

import com.avalon.excelplan.entity.po.ColumnInfo;
import com.avalon.excelplan.entity.po.TableInfo;
import com.avalon.excelplan.mapper.ExcelDateSourceMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "数据源管理")
@RestController
@RequestMapping("/data-source")
public class ExcelDataSourceController {

    @Resource
    private ExcelDateSourceMapper sourceMapper;

    @ApiOperation(value = "表列表")
    @GetMapping(value = "tableList")
    public Object tableList() {
        List<TableInfo> tableInfos = sourceMapper.tableList("excel_plan");
        for (TableInfo tableInfo : tableInfos) {
            String tableName = tableInfo.getTableName();
            List<ColumnInfo> columnInfos = sourceMapper.columnList("excel_plan", tableName);
            tableInfo.getColumnList().addAll(columnInfos);
        }
        return tableInfos;
    }

}
