package com.avalon.excelplan.constant;

/**
 * 字典表常量值
 *
 * @author yinfufan
 * @date 2022/8/10
 */
public interface SysDictConst {

    //数据字典分组本身也是字典数据，所在分组为根分组
    String ROOT_GROUP = "sys-dict-group";

    //字典编码数据类型，S:字符 B:布尔 I:整数
    String DICT_TYPE_STRING = "S";
    String DICT_TYPE_BOOLEAN = "B";
    String DICT_TYPE_INT = "I";

    //数据字典缓存key格式
    String CACHE_KEY_FMT = "ump_dict_cache_%s";

}
