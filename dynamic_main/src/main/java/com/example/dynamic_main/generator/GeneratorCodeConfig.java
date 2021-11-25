package com.example.dynamic_main.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.*;

/**
 * @ProjectName: sysxy
 * @Package: com.sysam.sysxymain.config
 * @ClassName: GeneratorCodeConfig
 * @Author: jibl
 * @Description:
 * @Date: 2021/1/19 9:39
 * @Version: 1.0
 */
public class GeneratorCodeConfig {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        String DRIVER = "com.mysql.cj.jdbc.Driver";
//        String DATA_URL = "jdbc:mysql://127.0.0.1:3306/cas?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true";
        String DATA_URL = "jdbc:mysql://localhost:3306/el_authority?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
        String USERNAME = "root";
        String PASSWORD = "123456";
        String AUTHOR = "jibl";
        //MOUDLENAME 模块名称  sysam_task
        //自定义模块名称
        String MOUDLENAME = (scanner("模块名"));
        //得到当前项目的路径
        String projectPath = System.getProperty("user.dir");
        //生成文件输出根目录
        String ROOT_DIR = projectPath + "/" + MOUDLENAME + "/src/main/java";

        // 创建代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        gc.setOpen(false);//生成完成后不弹出文件框
        gc.setOutputDir(ROOT_DIR);//生成文件输出根目录
        gc.setFileOverride(true);//每次生成覆盖之间的
        gc.setActiveRecord(true);//模型类对应关系型数据库中的一个表
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columnList
        gc.setDateType(DateType.ONLY_DATE);//指定时间类型Date
        gc.setAuthor(AUTHOR);//生成人
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(DRIVER);
        dsc.setUrl(DATA_URL);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);

        //包配置
        PackageConfig pc = new PackageConfig();
//        pc.setParent("com.example." + MOUDLENAME);
        pc.setParent( scanner("包名"));
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setEntity("entity");
        pc.setMapper("dao");

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setControllerMappingHyphenStyle(true);// 驼峰转连字符
        strategy.setEntityTableFieldAnnotationEnable(true);// @TableField:注解用于标识非主键的字段。将数据库列与 JavaBean 中的属性进行映射
        //trategy.setTablePrefix("sys" + "_"); //绑定表名前缀
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));

        //xml生成路径
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/" + MOUDLENAME + "/src/main/resources/" + "/mybatis/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        InjectionConfig cfg = injectionConfig();
        cfg.setFileOutConfigList(focList);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);

        mpg.setDataSource(dsc);         //数据源配置
        mpg.setGlobalConfig(gc);        //全局配置
        mpg.setStrategy(strategy);      //生成策略配置
        mpg.setPackageInfo(pc);         //包配置
        mpg.setCfg(cfg);                //xml配置
        mpg.setTemplate(tc);
        // 执行生成
        mpg.execute();
    }

    /**
     * 自定义配置
     *
     * @param fileTypeEnum 文件类型
     * @return InjectionConfig
     */
    private static InjectionConfig injectionConfig(FileType... fileTypeEnum) {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        injectionConfig.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                if (fileTypeEnum.length == 0) {
                    //无参情况下，先检查.java file是否存在：
                    //如果不存在，创建；如果存在，判断是否是entity.java：如果是，创建（覆盖）；否则，不创建。
                    checkDir(filePath);
                    File file = new File(filePath);
                    boolean exist = file.exists();
                    if (exist) {
                        if (FileType.ENTITY == fileType) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    return true;
                } else {
                    //有参情况下，只创建传入的.java，无论存在都直接覆盖。
                    boolean isType = false;
                    for (int i = 0; i < fileTypeEnum.length; i++) {
                        if (fileTypeEnum[i] == fileType) {
                            isType = true;
                            break;
                        }
                    }
                    if (!isType) {
                        return false;
                    }
                    checkDir(filePath);
                    return true;
                }
            }
        });
        return injectionConfig;
    }
}
