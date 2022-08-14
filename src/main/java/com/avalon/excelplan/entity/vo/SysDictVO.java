package com.avalon.excelplan.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinfufan
 * @date 2022/8/10
 */
@Data
@ApiModel(value = "SysDictVO", description = "字典")
public class SysDictVO {

    @JsonIgnore
    private Integer id;

    @JsonIgnore
    private Integer parentId;

    @ApiModelProperty(value = "编码")
    private String dictCode;

    @ApiModelProperty(value = "类型 S:字符 B:布尔 I:整形")
    private String dictType;

    @ApiModelProperty(value = "描述")
    private String dictDesc;

    @ApiModelProperty(value = "下级字典列表")
    private final List<SysDictVO> childList = new ArrayList<>();

}
