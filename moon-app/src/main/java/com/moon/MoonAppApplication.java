package com.moon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动程序
 * 
 * @author moon
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.moon.**.mapper")
public class MoonAppApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(MoonAppApplication.class, args);
        System.out.println("MoonAppApplication    (♥◠‿◠)ﾉﾞ  MOON启动成功   ლ(´ڡ`ლ)ﾞ  \n" );
    }
}