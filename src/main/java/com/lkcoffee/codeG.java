package com.lkcoffee;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

public class codeG {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/luckin_coffee?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC", "root", "qiuyue2525")
                .globalConfig(builder -> {
                    builder.author("qiuyue") // 设置作者
                            .outputDir("src/main/java/"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com") // 设置父包名
                            .moduleName("lkcoffee") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("menu_goods"); // 设置需要生成的表名
                })
                .execute();
    }
}
