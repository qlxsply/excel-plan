package com.avalon.excelplan.constant;

public enum DataTypeMap {
    //    1 = VARCHAR、2 = CHAR、3 = FIXBINARY、4 = BINARY、5 = BLOB、6 = INT、7 = SYS_CHILD、
//            8 = SYS、9 = FLOAT、10 = DOUBLE、11 = DECIMAL、12 = VARMYSQL、13 = MYSQL、14 = GEOMETRY
    VARCHAR(1, "VARCHAR", "String"),
    ;
    private int mType;
    private String mysqlType;
    private String javaType;

    DataTypeMap(int mType, String mysqlType, String javaType) {
        this.mType = mType;
        this.mysqlType = mysqlType;
        this.javaType = javaType;
    }
}
