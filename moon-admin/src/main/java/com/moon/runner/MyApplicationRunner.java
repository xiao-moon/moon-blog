package com.moon.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 程序启动后通过ApplicationRunner处理一些事务
 *
 * @author wujiyue
 * @date 2018/6/6 16:07
 */

@Component
public class MyApplicationRunner implements ApplicationRunner {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(ApplicationArguments applicationArguments) {

            System.out.println("MyApplicationRunner    (♥◠‿◠)ﾉﾞ  MOON启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                    " ( ) ( )\n" +
                    " | |_| |   _ _  _ _    _ _    _   _\n" +
                    " |  _  | /'_` )( '_`\\ ( '_`\\ ( ) ( )\n" +
                    " | | | |( (_| || (_) )| (_) )| (_) |\n" +
                    " (_) (_)`\\__,_)| ,__/'| ,__/'`\\__, |\n" +
                    "               | |    | |    ( )_| |\n" +
                    "               (_)    (_)    `\\___/'");

    }
}
