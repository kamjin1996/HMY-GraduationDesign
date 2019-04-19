package com.zxx.hmy520.graduationdesign.automatic.code;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.zxx.hmy520.graduationdesign.automatic.config.QueryFileOutConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kam
 * @Description: 代码生成启动类
 * @date 2018/5/9 15:20
 */

@SpringBootApplication
public class AutoMaticCode {

    public static void main(String[] args) {
        AutoMaticCode generator = new AutoMaticCode();
        generator.generateCode();
    }

    public void generateCode() {
        String packageName = "com.zxx.hym520.hmygraduationdesign";
        String outputDir = "D:\\NewWorkSpace\\hmy-graduation-design\\src\\main\\java";
        String dbUrl = "jdbc:mysql://localhost:3306";
        String userName = "root";
        String password = "123456";
        String[] tableNames = {
                "adjust_dictionary"
        };
        generateByTables(userName, password, dbUrl, outputDir, packageName, tableNames);
    }

    private void generateByTables(String userName, String passowrd, String dbUrl, String outputDir, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername(userName)
                .setPassword(passowrd)
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames)//修改替换成你需要的表名，多个表名传数组
                .entityTableFieldAnnotationEnable(true)
                .setEntityLombokModel(true)
                .setSuperControllerClass("com.zxx.hym520.hmygraduationdesign.base.controller.BaseController")
                .setSuperEntityClass("com.zxx.hym520.hmygraduationdesign.base.mysql.model.BaseModel")
                .setSuperEntityColumns("id")
                .setSuperServiceClass("com.hzxdpx.xdpx.common.mysql.service.BaseService")
                .setSuperServiceImplClass("com.hzxdpx.xdpx.common.mysql.service.BaseServiceImpl")
                .setRestControllerStyle(true);

        config.setActiveRecord(false)
                .setAuthor("kam")
                .setOutputDir(outputDir)
                .setOpen(false)
                .setFileOverride(true)
                .setEnableCache(false);
        config.setServiceName("%sService");

        //自定义配置增加
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("queryPackage", packageName + ".domain.query");
                this.setMap(map);
            }
        };

        // 自定生成模板
        List<FileOutConfig> focList = new ArrayList<>();
        String path = outputDir + File.separator + packageName.replaceAll("\\.", "\\\\") + File.separator + "domain" + File.separator + "query" + File.separator;
        focList.add(new QueryFileOutConfig("/templ/query.java.vm", path));
        cfg.setFileOutConfigList(focList);

        new AutoGenerator()
                .setGlobalConfig(config)
                .setCfg(cfg)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setTemplate(
                        new TemplateConfig()
                                .setEntity("/templ/entity.java")
                                .setController("/templ/controller.java")
                                .setService("/templ/service.java")
                                .setServiceImpl("/templ/serviceImpl.java")
                )
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller.open.api")
                                .setEntity("domain.model")
                                .setService("service.open")
                                .setServiceImpl("service.open.impl")
                ).execute();
    }


}
