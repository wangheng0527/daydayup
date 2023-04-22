# MybatisFlex

0、`https://mybatis-flex.com/`

1、开发环境：`SpringBoot3、JDK19、Maven3.9.1`

## SpringBoot + MybatisFlex

1、新建`SpringBoot`项目，添加相关依赖：

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>3.0.6</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.26</version>
    <scope>provided</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.6.0</version>
</dependency>

<!-- https://mvnrepository.com/artifact/com.mybatis-flex/mybatis-flex-spring-boot-starter -->
<dependency>
    <groupId>com.mybatis-flex</groupId>
    <artifactId>mybatis-flex-spring-boot-starter</artifactId>
    <version>1.1.7</version>
    <exclusions>
        <exclusion>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>3.0.1</version>
</dependency>

<dependency>
    <groupId>com.mybatis-flex</groupId>
    <artifactId>mybatis-flex-codegen</artifactId>
    <version>1.1.8</version>
</dependency>

<!-- https://mvnrepository.com/artifact/com.zaxxer/HikariCP -->
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>5.0.1</version>
</dependency>
```

2、代码生成：

```Java
package com.example.demo;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;
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

}
```

生成的`entity、mapper`：

![image-20230422223427238](D:\my-development\my-picture\typora\image-20230422223427238.png)

在主启动类上添加注解`@MapperScan("com.example.demo.mapper")`：

```java 
package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangheng
 */
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class SpringBootMybatisFlexApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisFlexApplication.class, args);
    }

}
```

3、简单使用：

```Java
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

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.selectAll());
    }

}
```

![image-20230422223616528](D:\my-development\my-picture\typora\image-20230422223616528.png)

# Git

## 安装

0、下载地址：`https://git-scm.com/downloads`；

1、下载安装完成后右击鼠标选择`Git Bash Here`进行配置，分别执行：

` git config --global user.name "wangheng"`

`git config --global user.email "2812490576@qq.com"`

![image-20230412204608295](D:\my-development\my-picture\typora\image-20230412204608295.png)

## 连接GitHub

1、在本地新建一个文件夹，要上传到`GitHub`的文件都放到该文件夹下，进入文件夹右键选择`Git Bash Here`将其初始化为一个`Git`可管理的仓库，执行命令`git init`：

![image-20230412205436153](D:\my-development\my-picture\typora\image-20230412205436153.png)

注：查看不到隐藏文件`.git`的话按照顺序执行`1、2`；

2、在该文件下创建文件，并提交到`Git`本地仓库（参考`Git`常用命令`1、2、3`）；

3、创建`SSH Key`，打开`Git Bash Here`，执行命令`ssh-keygen -t rsa -C "2812490576@qq.com"`，一直回车即可：

 ![image-20230412212348244](D:\my-development\my-picture\typora\image-20230412212348244.png)

然后在`C`会生成一个文件夹（该文件夹的存放地址根据上一步中自己选择的文件存放位置决定）：

![image-20230412212512411](D:\my-development\my-picture\typora\image-20230412212512411.png)

接着登录自己的`GitHub`找到如图所示，将`id_rsa.pub`里的全部内容`copy`到`Key`对应的框中：

![image-20230412212759848](D:\my-development\my-picture\typora\image-20230412212759848.png)

验证（执行命令：`ssh -T git@github.com`）：

![image-20230412214455477](D:\my-development\my-picture\typora\image-20230412214455477.png)

4、在`GitHub`上创建一个新的仓库：

![image-20230412215337538](D:\my-development\my-picture\typora\image-20230412215337538.png)

5、本地`Git`关联`GitHub`上新创建的仓库，执行命令：`git remote add origin https://github.com/wangheng0527/daydayup.git`：

![image-20230412215450863](D:\my-development\my-picture\typora\image-20230412215450863.png)

6、上传文件，执行命令后会登录`GitHub`：

6.1 第一次上传由于`GitHub`仓库内容为空，所以要加上参数`-u`：`git push -u origin master`

6.2 第二次开始上传都不需要加参数`-u`：`git push origin master`

![image-20230412215922999](D:\my-development\my-picture\typora\image-20230412215922999.png)

刷新仓库即可看到新上传的文件：

![image-20230412220029222](D:\my-development\my-picture\typora\image-20230412220029222.png)

## Git常用命令

1、`git status`：查看当前状态（红色代表还未`add`到`Git`本地仓库的文件，绿色代表已`add`过的文件）：

![image-20230412210523506](D:\my-development\my-picture\typora\image-20230412210523506.png)

2、`git add .`：把当前目录下所有文件`add`到`Git`本地仓库中：

![image-20230412211109031](D:\my-development\my-picture\typora\image-20230412211109031.png)

3、`git commit -m "commit comment"`：将所有已`add`的文件提交到本地仓库：

![image-20230412211409719](D:\my-development\my-picture\typora\image-20230412211409719.png)

![image-20230422224458166](D:\my-development\my-github\README.assets\image-20230422224458166.png)