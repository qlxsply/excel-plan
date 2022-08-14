package com.avalon.excelplan.entity.po;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TableInfo {

    private String tableName;
    private String tableType;
    private String engine;
    private long version;
    private String rowFormat;
    private String tableComment;
    private List<ColumnInfo> columnList = new ArrayList<>();

}
