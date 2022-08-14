package com.avalon.excelplan.entity.dto;

import com.avalon.excelplan.constant.SysDictConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author yinfufan
 * @date 2022/8/10
 */
@Data
@ApiModel(value = "SysDictEditDTO", description = "编辑数据字典参数")
public class SysDictEditDTO {

    @ApiModelProperty(value = "字典分组，用于区分不同的字典记录", required = true)
    @NotBlank(message = "字典分组不能为空")
    private String dictGroup;

    @ApiModelProperty(value = "字典列表", required = true)
    @NotEmpty(message = "字典列表不能为空")
    private List<SysDictAddEleDTO> dictList;

    @Data
    @ApiModel(value = "SysDictAddEleDTO", description = "数据字典元素")
    public static class SysDictAddEleDTO {
        @ApiModelProperty(value = "编码，同一组字典记录内，编码不应该重复", required = true)
        @NotBlank(message = "编码不能为空")
        @Length(max = 64, message = "编码不能超过64个字符")
        private String dictCode;

        @ApiModelProperty(value = "类型，S:字符 B:布尔 I:整数", required = true, allowableValues = "S,B,I")
        private String dictType = SysDictConst.DICT_TYPE_STRING;

        @ApiModelProperty(value = "描述", required = true)
        @NotBlank(message = "描述不能为空")
        @Length(max = 255, message = "编码不能超过255个字符")
        private String dictDesc;

        @ApiModelProperty(value = "下级字典列表")
        private List<SysDictAddEleDTO> childList;
    }

}
