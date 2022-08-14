package com.avalon.excelplan.controller;

import com.avalon.excelplan.entity.dto.SysDictEditDTO;
import com.avalon.excelplan.entity.dto.SysDictGroupAddDTO;
import com.avalon.excelplan.entity.vo.SysDictGroupVO;
import com.avalon.excelplan.entity.vo.SysDictVO;
import com.avalon.excelplan.service.ISysDictService;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统字典表 前端控制器
 * </p>
 *
 * @author yinfufan
 * @since 2022-08-10
 */
@Api(tags = "数据字典")
@RestController
@RequestMapping("/sys-dict")
public class SysDictController {

    @Resource
    private ISysDictService dictService;

    @ApiOperation(value = "增加字典组")
    @PostMapping(value = "addGroup")
    public Boolean addGroup(@RequestBody @Validated SysDictGroupAddDTO param) {
        dictService.addGroup(param);
        return true;
    }

    @ApiOperation(value = "删除字典组")
    @ApiImplicitParams({@ApiImplicitParam(name = "dictGroup", value = "字典组编码", required = true, paramType = "query", dataType = "String")})
    @DeleteMapping(value = "deleteGroup")
    public Boolean deleteGroup(String dictGroup) {
        Assert.isTrue(StringUtils.isNotBlank(dictGroup), "字典组编码不能为空");
        dictService.deleteGroup(dictGroup);
        return true;
    }

    @ApiOperation(value = "编辑字典")
    @PutMapping(value = "edit")
    public Boolean edit(@RequestBody @Validated SysDictEditDTO param) {
        dictService.edit(param);
        return true;
    }

    @ApiOperation(value = "查询字典组列表")
    @GetMapping(value = "getAllDictGroup")
    public List<SysDictGroupVO> getAllDictGroup() {
        List<SysDictGroupVO> list = dictService.getAllDictGroup();
        return list;
    }

    @ApiOperation(value = "查询字典")
    @ApiImplicitParams({@ApiImplicitParam(name = "dictGroup", value = "字典组编码", required = true, paramType = "query", dataType = "String")})
    @GetMapping(value = "getDictList")
    public List<SysDictVO> getDictList(String dictGroup) {
        Assert.isTrue(StringUtils.isNotBlank(dictGroup), "字典组编码不能为空");
        List<SysDictVO> list = dictService.getDictList(dictGroup);
        return list;
    }

}

