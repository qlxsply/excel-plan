package com.avalon.excelplan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 代码生成器工具类
 *
 * @author yinfufan
 * @date 2022/8/2
 */
public class Generator {
    //数据库url
    private static final String URL = "jdbc:mysql://192.168.3.201:8001/excel_plan?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowMultiQueries=true";
    //账号
    private static final String ACCOUNT = "root";
    //密码
    private static final String PASSWD = "asdfasdf";
    //项目路径
    private static final String modulePath = "./";
    //所在包路径
    private static final String packagePath = "com.avalon.excelplan";
    //实体类生成
    private static final Boolean generateEntity = true;
    private static final String entityPackagePath = "entity.po";
    //service类生成
    private static final Boolean generateService = true;
    private static final String servicePackagePath = "service";
    //serviceImpl类生成
    private static final Boolean generateImpl = true;
    private static final String serviceImplPackagePath = "service.impl";
    //mapper类生成
    private static final Boolean generateMapper = true;
    private static final String mapperPackagePath = "mapper";
    //mapper xml文件生成
    private static final Boolean generateXml = true;
    private static final String xmlPackagePath = "mapper";
    //controller类生成
    private static final Boolean generateController = true;
    private static final String controllerPackagePath = "controller";
    //表前缀设置
    private static final boolean ifDeleteTablePreFix = false;
    private static final String tablePreFix = "t";

    public static void main(String[] args) {
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/" + modulePath + "/src/main/java");
        //是否覆盖已有文件 默认值：false
        gc.setFileOverride(false);
        //是否在xml中添加二级缓存配置
        gc.setEnableCache(false);
        //是否在xml中添加BaseResultMap
        gc.setBaseResultMap(true);
        //是否在xml中添加BaseColumnList
        gc.setBaseColumnList(true);
        //Mapper 命名方式
        gc.setMapperName("%sMapper");
        //Mapper.xml 命名方式
        gc.setXmlName("%sMapper");
        //实体命名方式
        gc.setEntityName("%s");
        //Service 命名方式
        gc.setServiceName("I%sService");
        //ServiceImpl 命名方式
        gc.setServiceImplName("%sServiceImpl");
        //ServiceImpl 命名方式
        gc.setControllerName("%sController");
        //指定生成的主键的ID类型
        gc.setIdType(IdType.NONE);
        //开发人员
        gc.setAuthor("yinfufan");
        //是否打开输出目录
        gc.setOpen(false);
        //swagger
        gc.setSwagger2(true);

        //生成包相关配置
        PackageConfig packageConfig = new PackageConfig();
        //父包名
        packageConfig.setParent(packagePath);
        //父包模块名
//        packageConfig.setModuleName(scanner("模块名"));
        //包名
        packageConfig.setEntity(entityPackagePath);
        packageConfig.setService(servicePackagePath);
        packageConfig.setServiceImpl(serviceImplPackagePath);
        packageConfig.setMapper(mapperPackagePath);
        packageConfig.setXml(xmlPackagePath);
        packageConfig.setController(controllerPackagePath);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(ACCOUNT);
        dsc.setPassword(PASSWD);

        //数据库表配置
        StrategyConfig strategy = new StrategyConfig();
        //是否大写命名
        strategy.setCapitalMode(false);
        //是否跳过视图
        strategy.setSkipView(true);
        //数据库表映射到实体的命名策略 NamingStrategy
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略，未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //表前缀，生成实体类的时候如果设置了前缀命名会去掉前缀
        if (ifDeleteTablePreFix) {
            strategy.setTablePrefix(tablePreFix + "_");
        }
        //字段前缀 生成实体类的时候如果设置了前缀命名会去掉前缀
//        strategy.setFieldPrefix();
        //自定义基础的Entity类，公共字段
//        strategy.setSuperEntityColumns()
        //自定义继承的类全称，带包名
//        strategy.setSuperEntityClass();
//        strategy.setSuperMapperClass();
//        strategy.setSuperServiceClass();
//        strategy.setSuperServiceImplClass();
//        strategy.setSuperControllerClass();
        /*
         * 默认激活进行sql模糊表名匹配
         * 关闭之后likeTable与notLikeTable将失效，include和exclude将使用内存过滤
         * 如果有sql语法兼容性问题的话，请手动设置为false
         */
//        strategy.setEnableSqlFilter(true);
        //需要包含的表名，当enableSqlFilter为false时，允许正则表达式（与exclude二选一配置）
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
//        strategy.setExclude();
        //自3.3.0起，模糊匹配表名（与notLikeTable二选一）
//        strategy.setLikeTable()
//        strategy.setNotLikeTable()
        //是否生成字段常量（默认 false）
        strategy.setEntityColumnConstant(false);
        //是否为lombok模型（默认 false）3.3.2以下版本默认生成了链式模型，3.3.2以后，默认不生成，如有需要，请开启 chainModel
        strategy.setEntityLombokModel(true);
        //是否为链式模型（默认 false）
//        strategy.setChainModel(true);
        //Boolean类型字段是否移除is前缀（默认 false）
//        strategy.setEntityBooleanColumnRemoveIsPrefix();
        //生成 @RestController 控制器
//        strategy.setRestControllerStyle(true);
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        //是否生成实体时，生成字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);
        //逻辑删除属性名称
//        strategy.setLogicDeleteFieldName()

        /*
         * 自定义文件模板
         * 指定自定义模板路径, 位置：/resources/templates/entity2.java.ftl(或者是.vm)
         * 注意不要带上.ftl(或者是.vm), 会根据使用的模板引擎自动识别
         */
        TemplateConfig templateConfig = new TemplateConfig();
        if (!generateEntity) {
            templateConfig.setEntity("");
        }
        if (!generateController) {
            templateConfig.setController("");
        }
        if (!generateService) {
            templateConfig.setService("");
        }
        if (!generateImpl) {
            templateConfig.setServiceImpl("");
        }
        if (!generateXml) {
            templateConfig.setXml("");
        }
        if (!generateMapper) {
            templateConfig.setMapper("");
        }
//        templateConfig.setXml();
//        templateConfig.setEntity();
//        templateConfig.setController("templates/generator/controller.java");
//        templateConfig.setMapper();
//        templateConfig.setService();
//        templateConfig.setServiceImpl();
        /* Kotin 实体类模板 **/
//        templateConfig.setEntityKt();

        /*
          注入配置，通过该配置，可注入模板自定义参数等操作以实现个性化操作
          entity2.java.ftl
          自定义属性注入abc=${cfg.abc}
          entity2.java.vm
          自定义属性注入abc=$!{cfg.abc}
         */
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                /* 注入自定义 Map 对象(注意需要setMap放进去) **/
                Map<String, Object> map = new HashMap<>();
                map.put("serviceInstance", captureName(gc.getServiceName()));
                this.setMap(map);
            }
        };

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(gc);
        mpg.setPackageInfo(packageConfig);
        mpg.setDataSource(dsc);
        mpg.setStrategy(strategy);
        mpg.setTemplate(templateConfig);
        mpg.setCfg(injectionConfig);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }

    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    private static String captureName(String name) {
        char[] cs = name.toCharArray();
        cs[0] += 32;
        return String.valueOf(cs);
    }
}
