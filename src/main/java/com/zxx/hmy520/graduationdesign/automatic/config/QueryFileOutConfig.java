package com.zxx.hmy520.graduationdesign.automatic.config;

import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.io.File;

/**
 * @author kam
 * @Description: XML 输出
 * @date 2018/5/917:19
 */
public class QueryFileOutConfig extends FileOutConfig {

    /**
     * 输出路径
     */
    private String fileOutPath;

    public QueryFileOutConfig(String templatePath, String fileOutPath) {
        super(templatePath);
        this.fileOutPath = fileOutPath;
        File file = new File(fileOutPath);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
    }

    @Override
    public String outputFile(TableInfo tableInfo) {
        return this.fileOutPath + tableInfo.getEntityName() + "Query.java";
    }

    public String getFileOutPath() {
        return fileOutPath;
    }

    public void setFileOutPath(String fileOutPath) {
        this.fileOutPath = fileOutPath;
    }
}
