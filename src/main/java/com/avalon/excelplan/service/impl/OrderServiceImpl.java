package com.avalon.excelplan.service.impl;

import com.avalon.excelplan.entity.po.Order;
import com.avalon.excelplan.mapper.OrderMapper;
import com.avalon.excelplan.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yinfufan
 * @since 2022-08-14
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
