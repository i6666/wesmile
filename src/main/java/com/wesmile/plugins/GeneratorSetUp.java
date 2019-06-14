package com.wesmile.plugins;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zma on 2019/05/29
 */
public class GeneratorSetUp {
    public static void main(String[] args) {
        // 执行中的异常信息会保存在warnings中
        List<String> warnings = new ArrayList<>();
        String configPath = "D:/workspace/private/wesmile/src/main/resources/generator/generatorConfig.xml";
        try {
            //读取配置,构造 Configuration 对象.
            File configFile = new File(configPath);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            //true:生成的文件覆盖之前的
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
