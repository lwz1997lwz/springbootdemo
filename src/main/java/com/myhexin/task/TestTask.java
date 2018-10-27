package com.myhexin.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @program: springbootdemo
 * @description: 测试定时任务
 * @author: Linweizhe
 * @create: 2018-10-27 17:17
 **/
public class TestTask {

    //日志对象
    private static final Logger logger = LogManager.getLogger(TestTask.class);

    public void run() {
        logger.info("任务执行了!!");
    }
}
