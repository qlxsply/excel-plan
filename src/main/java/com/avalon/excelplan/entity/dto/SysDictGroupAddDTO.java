package com.avalon.excelplan.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author yinfufan
 * @date 2022/8/10
 */
@Data
@ApiModel(value = "SysDictGroupAddDTO", description = "增加字典分组")
public class SysDictGroupAddDTO {

    @ApiModelProperty(value = "字典分组编码", required = true)
    @NotBlank(message = "字典分组编码不能为空")
    @Length(max = 64, message = "字典分组编码不能超过64个字符")
    private String dictCode;

    @ApiModelProperty(value = "字典分组描述", required = true)
    @NotBlank(message = "字典分组描述不能为空")
    @Length(max = 20, message = "字典分组描述不能超过20个字符")
    private String dictDesc;

}
