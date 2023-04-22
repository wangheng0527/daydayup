package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootMybatisFlexApplicationTests {

    @Test
    void mybatisFlexCodeGenerator() {
        //配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("pg123456");

        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置只生成哪些表
        globalConfig.addGenerateTable("t_user");

        //设置 entity 的包名
        globalConfig.setEntityPackage("com.example.demo.entity");

        //设置表前缀
        globalConfig.setTablePrefix("t_");

        //设置 entity 是否使用 Lombok
        globalConfig.setEntityWithLombok(true);

        //是否生成 mapper 类，默认为 false
        globalConfig.setMapperGenerateEnable(true);

        //设置 mapper 类的包名
        globalConfig.setMapperPackage("com.example.demo.mapper");

        //可以单独配置某个列
//        ColumnConfig columnConfig = new ColumnConfig();
//        columnConfig.setColumnName("tenant_id");
//        columnConfig.setLarge(true);
//        columnConfig.setVersion(true);
//        globalConfig.addColumnConfig("account", columnConfig);

        //通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig);

        //生成代码
        generator.generate();
    }

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.selectAll());
    }

}
