package com.shenjg.core.data;

import java.util.List;

/*
 * @author shenjg
 *
 */
public class Zip {

    /**
     * 存储下载对象的Redis key
     */
    public static final String REDIS_KEY_PREFIX = "zip:";

    /**
     * 下载对象的过期时间（秒）
     */
    public static final int REDIS_KEY_EXPIRE = 300;

    private String fileName;
    private String bucket;
    private List<String> keys;

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getBucket() {
        return bucket;
    }
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
    public List<String> getKeys() {
        return keys;
    }
    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

}