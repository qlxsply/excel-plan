package com.avalon.excelplan.service.impl;

import com.avalon.excelplan.entity.dto.SysDictEditDTO;
import com.avalon.excelplan.entity.dto.SysDictGroupAddDTO;
import com.avalon.excelplan.entity.po.SysDictEntity;
import com.avalon.excelplan.entity.vo.SysDictGroupVO;
import com.avalon.excelplan.entity.vo.SysDictVO;
import com.avalon.excelplan.mapper.SysDictMapper;
import com.avalon.excelplan.service.ISysDictService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统字典表 服务实现类
 * </p>
 *
 * @author yinfufan
 * @since 2022-08-10
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDictEntity> implements ISysDictService {

    @Override
    @Transactional
    public void addGroup(SysDictGroupAddDTO param) {
        int seq = 1;
        List<SysDictEntity> sysDictEntities = this.baseMapper.selectForUpdateByGroup(ROOT_GROUP);
        if (sysDictEntities != null && !sysDictEntities.isEmpty()) {
            for (SysDictEntity sysDictEntity : sysDictEntities) {
                if (StringUtils.equals(param.getDictCode(), sysDictEntity.getDictCode())) {
                    throw new RuntimeException("组重复");
                }
                if (sysDictEntity.getSeq() >= seq) {
                    seq = sysDictEntity.getSeq() + 1;
                }
            }
        }
        SysDictEntity sysDictEntity = new SysDictEntity();
        sysDictEntity.setDictGroup(ROOT_GROUP);
        sysDictEntity.setDictCode(param.getDictCode());
        sysDictEntity.setDictType(DICT_TYPE_STRING);
        sysDictEntity.setDictDesc(param.getDictDesc());
        sysDictEntity.setSeq(seq);
        super.save(sysDictEntity);
    }

    @Override
    @Transactional
    public void deleteGroup(String dictGroup) {
        //删除分组及其下属全部字典数据
        LambdaQueryWrapper<SysDictEntity> delGroup = Wrappers.lambdaQuery();
        delGroup.eq(SysDictEntity::getDictGroup, ROOT_GROUP);
        delGroup.eq(SysDictEntity::getDictCode, dictGroup);
        super.remove(delGroup);

        LambdaQueryWrapper<SysDictEntity> delDict = Wrappers.lambdaQuery();
        delDict.eq(SysDictEntity::getDictGroup, dictGroup);
        super.remove(delDict);
    }

    @Override
    @Transactional
    public void edit(SysDictEditDTO param) {
        LambdaQueryWrapper<SysDictEntity> groupQuery = Wrappers.lambdaQuery();
        groupQuery.eq(SysDictEntity::getDictGroup, ROOT_GROUP);
        groupQuery.eq(SysDictEntity::getDictCode, param.getDictGroup());
        SysDictEntity group = super.getOne(groupQuery);
        if (group == null) {
            throw new RuntimeException("组不存在");
        }
        //删除原有数据分组下的全部字典列表
        List<SysDictEntity> removeList = super.baseMapper.selectForUpdateByGroup(param.getDictGroup());
        if (removeList != null && !removeList.isEmpty()) {
            List<Integer> ids = removeList.stream().map(SysDictEntity::getId).collect(Collectors.toList());
            super.removeByIds(ids);
        }
        //保存数据分组下的字典列表
        this.saveDict(param.getDictList(), 0, null, param.getDictGroup(), new AtomicInteger(1));
    }

    @Override
    public List<SysDictGroupVO> getAllDictGroup() {
        LambdaQueryWrapper<SysDictEntity> groupQuery = Wrappers.lambdaQuery();
        groupQuery.eq(SysDictEntity::getDictGroup, ROOT_GROUP);
        List<SysDictEntity> groupList = super.list(groupQuery);
        if (groupList == null || groupList.isEmpty()) {
            return new ArrayList<>();
        }
        return groupList.stream().map(a -> {
            SysDictGroupVO vo = new SysDictGroupVO();
            vo.setDictCode(a.getDictCode());
            vo.setDictDesc(a.getDictDesc());
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public List<SysDictVO> getDictList(String dictGroup) {
        //先查询缓存，如果缓存不存在，再查询数据库，没有处理缓存穿透问题
        LambdaQueryWrapper<SysDictEntity> dictQuery = Wrappers.lambdaQuery();
        dictQuery.eq(SysDictEntity::getDictGroup, dictGroup);
        dictQuery.orderByAsc(SysDictEntity::getSeq);
        List<SysDictEntity> dictList = super.list(dictQuery);
        if (dictList == null || dictList.isEmpty()) {
            return new ArrayList<>();
        }
        //
        List<SysDictVO> allDictList = dictList.stream().map(a -> {
            SysDictVO sysDictVO = new SysDictVO();
            sysDictVO.setId(a.getId());
            sysDictVO.setParentId(a.getParentId());
            sysDictVO.setDictCode(a.getDictCode());
            sysDictVO.setDictType(a.getDictType());
            sysDictVO.setDictDesc(a.getDictDesc());
            return sysDictVO;
        }).collect(Collectors.toList());

        List<SysDictVO> level1 = allDictList.stream().filter(a -> a.getParentId() == null || a.getParentId() == 0)
                .collect(Collectors.toList());

        Map<Integer, SysDictVO> id2Obj = allDictList.stream().collect(Collectors.toMap(SysDictVO::getId, a -> a));

        Map<Integer, List<SysDictVO>> groupByPid = allDictList.stream()
                .collect(Collectors.groupingBy(SysDictVO::getParentId));

        for (Map.Entry<Integer, List<SysDictVO>> entry : groupByPid.entrySet()) {
            Integer pid = entry.getKey();
            if (pid == 0) {
                continue;
            }
            List<SysDictVO> childList = entry.getValue();
            SysDictVO parentDict = id2Obj.get(pid);
            parentDict.getChildList().addAll(childList);
        }

        return level1;
    }

    private void saveDict(List<SysDictEditDTO.SysDictAddEleDTO> addList, int pid, String pDesc, String group, AtomicInteger seq) {
        this.checkDictCodeDuplicate(addList, pDesc);
        for (SysDictEditDTO.SysDictAddEleDTO dictEle : addList) {
            SysDictEntity sysDictEntity = new SysDictEntity();
            sysDictEntity.setParentId(pid);
            sysDictEntity.setDictGroup(group);
            sysDictEntity.setDictCode(dictEle.getDictCode());
            sysDictEntity.setDictType(dictEle.getDictType());
            sysDictEntity.setDictDesc(dictEle.getDictDesc());
            sysDictEntity.setSeq(seq.getAndIncrement());
            super.save(sysDictEntity);
            if (dictEle.getChildList() == null || dictEle.getChildList().isEmpty()) {
                continue;
            }
            saveDict(dictEle.getChildList(), sysDictEntity.getId(), dictEle.getDictDesc(), group, seq);
        }
    }

    private void checkDictCodeDuplicate(List<SysDictEditDTO.SysDictAddEleDTO> addList, String pDesc) {
        if (addList == null || addList.isEmpty()) {
            return;
        }
        Set<String> temp = new HashSet<>();
        List<String> dup = new ArrayList<>();
        for (SysDictEditDTO.SysDictAddEleDTO ele : addList) {
            String dictCode = ele.getDictCode();
            if (temp.contains(dictCode)) {
                dup.add(dictCode);
            } else {
                temp.add(dictCode);
            }
        }
        if (dup.isEmpty()) {
            return;
        }
        String dupCodes = Joiner.on(",").join(dup);
        String pDescStr = pDesc == null ? "" : String.format("[%s]下级字典", pDesc);
        throw new RuntimeException(String.format("%s编码[%s]重复", pDescStr, dupCodes));
    }

}
