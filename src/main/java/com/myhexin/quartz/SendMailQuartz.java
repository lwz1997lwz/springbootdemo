package com.myhexin.quartz;

import com.myhexin.task.TestTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: springbootdemo
 * @description: 定时器类
 * @author: Linweizhe
 * @create: 2018-10-27 17:19
 **/
@Component
@Configurable
@EnableScheduling
public class SendMailQuartz {

    //日志对象
    private static final Logger logger = LogManager.getLogger(SendMailQuartz.class);

    //每5秒执行一次
    @Scheduled(cron = "*/5 * *  * * * ")
    public void reportCurrentByCron() {
        TestTask task = new TestTask();
        task.run();
    }

}
