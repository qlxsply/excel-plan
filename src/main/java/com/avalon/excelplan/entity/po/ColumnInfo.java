package com.avalon.excelplan.entity.po;

import lombok.Data;

@Data
public class ColumnInfo {

    private String tableName;
    private String columnName;
    private long ordinalPosition;
    private String columnDefault;
    private String isNullable;
    private String dataType;
    private long numericPrecision;
    private long numericScale;
    private String columnKey;
    private String columnComment;

}
