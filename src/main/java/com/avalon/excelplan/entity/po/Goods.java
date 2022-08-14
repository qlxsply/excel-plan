package com.avalon.excelplan.entity.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yinfufan
 * @since 2022-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("goods")
@ApiModel(value="Goods对象", description="")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.NONE)
    private Integer id;

    @ApiModelProperty(value = "商品编码")
    @TableField("good_code")
    private String goodCode;

    @ApiModelProperty(value = "商品名称")
    @TableField("good_name")
    private String goodName;

    @ApiModelProperty(value = "卖方")
    @TableField("sale_user")
    private Integer saleUser;

    @ApiModelProperty(value = "一级类目")
    @TableField("category_1")
    private String category1;

    @ApiModelProperty(value = "二级类目")
    @TableField("category_2")
    private String category2;

    @ApiModelProperty(value = "三级类目")
    @TableField("category_3")
    private String category3;

    @ApiModelProperty(value = "商品单价")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty(value = "商品数量")
    @TableField("quantity")
    private Integer quantity;

    @ApiModelProperty(value = "数量单位")
    @TableField("unit_code")
    private String unitCode;


}
