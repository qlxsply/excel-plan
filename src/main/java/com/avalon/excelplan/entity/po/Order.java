package com.avalon.excelplan.entity.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("order")
@ApiModel(value="Order对象", description="")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.NONE)
    private Integer id;

    @ApiModelProperty(value = "订单号")
    @TableField("order_code")
    private String orderCode;

    @ApiModelProperty(value = "订单类型")
    @TableField("order_type")
    private String orderType;

    @ApiModelProperty(value = "买方")
    @TableField("buy_user")
    private Integer buyUser;

    @ApiModelProperty(value = "支付方式")
    @TableField("pay_type")
    private String payType;

    @ApiModelProperty(value = "支付状态")
    @TableField("pay_status")
    private String payStatus;

    @ApiModelProperty(value = "订单金额")
    @TableField("amount")
    private BigDecimal amount;

    @ApiModelProperty(value = "订单状态")
    @TableField("order_status")
    private String orderStatus;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "支付时间")
    @TableField("pay_time")
    private LocalDateTime payTime;


}
