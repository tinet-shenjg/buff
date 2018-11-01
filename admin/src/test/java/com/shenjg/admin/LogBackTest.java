package com.shenjg.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试日志
 *
 * @author shenjg
 * @date 2018/11/01
 */
public class LogBackTest {

    private final static Logger logger = LoggerFactory.getLogger(LogBackTest.class);
    /**
     * @param args
     */
    public static void main(String[] args) {
        logger.info("打印日志");
    }
}