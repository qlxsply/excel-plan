package com.avalon.excelplan.mapper;

import com.avalon.excelplan.entity.po.SysDictEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统字典表 Mapper 接口
 * </p>
 *
 * @author yinfufan
 * @since 2022-08-10
 */
public interface SysDictMapper extends BaseMapper<SysDictEntity> {

    List<SysDictEntity> selectForUpdateByGroup(@Param("dictGroup") String dictGroup);

}
