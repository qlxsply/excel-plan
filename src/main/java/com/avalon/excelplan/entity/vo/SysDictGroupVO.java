package com.avalon.excelplan.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yinfufan
 * @date 2022/8/10
 */
@Data
@ApiModel(value = "SysDictGroupVO", description = "字典分组")
public class SysDictGroupVO {

    @ApiModelProperty(value = "字典分组编码")
    private String dictCode;

    @ApiModelProperty(value = "字典分组描述")
    private String dictDesc;

}
