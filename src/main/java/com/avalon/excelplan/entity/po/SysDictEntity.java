package com.avalon.excelplan.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 系统字典表
 * </p>
 *
 * @author yinfufan
 * @since 2022-08-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dict")
@ApiModel(value = "SysDictEntity对象", description = "系统字典表")
public class SysDictEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父ID，根节点的父ID为0")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "字典分组，用于区分不同的字典记录")
    @TableField("dict_group")
    private String dictGroup;

    @ApiModelProperty(value = "编码，同一组字典记录内，编码不应该重复")
    @TableField("dict_code")
    private String dictCode;

    @ApiModelProperty(value = "类型，S:字符 B:布尔 I:整数")
    @TableField("dict_type")
    private String dictType;

    @ApiModelProperty(value = "描述")
    @TableField("dict_desc")
    private String dictDesc;

    @ApiModelProperty(value = "序号，用于同一组字典记录的排序")
    @TableField("seq")
    private Integer seq;

}
