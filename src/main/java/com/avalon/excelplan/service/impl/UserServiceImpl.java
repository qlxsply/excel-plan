package com.avalon.excelplan.service.impl;

import com.avalon.excelplan.entity.po.User;
import com.avalon.excelplan.mapper.UserMapper;
import com.avalon.excelplan.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
