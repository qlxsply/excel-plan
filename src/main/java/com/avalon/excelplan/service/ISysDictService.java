package com.avalon.excelplan.service;

import com.avalon.excelplan.constant.SysDictConst;
import com.avalon.excelplan.entity.dto.SysDictEditDTO;
import com.avalon.excelplan.entity.dto.SysDictGroupAddDTO;
import com.avalon.excelplan.entity.vo.SysDictGroupVO;
import com.avalon.excelplan.entity.vo.SysDictVO;

import java.util.List;

/**
 * <p>
 * 系统字典表 服务类
 * </p>
 *
 * @author yinfufan
 * @since 2022-08-10
 */
public interface ISysDictService extends SysDictConst {

    void addGroup(SysDictGroupAddDTO param);

    void deleteGroup(String dictGroup);

    void edit(SysDictEditDTO param);

    List<SysDictGroupVO> getAllDictGroup();

    List<SysDictVO> getDictList(String dictGroup);

}
