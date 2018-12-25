package com.shenjg.core.constant;

import java.util.UUID;

/**
 * @author shenjg
 * @date 2018/12/18
 **/
public class Constants {
    public static final String CLAIMS = "claims";
    /**
     * 删除
     */
    public static final Integer IS_DEL = 1;
    /**
     * 未删除
     */
    public static final Integer IS_NOT_DEL = 0;

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
