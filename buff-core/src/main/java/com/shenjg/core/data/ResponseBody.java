package com.shenjg.core.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * 接口统一响应对象封装
 *
 * @author shenjg
 * @date 2018/03/14
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBody {

    /**
     * 状态码
     */
    private int status;
    /**
     * 操作结果
     */
    private Object message;
    /**
     * 数据结果
     */
    private Object result;

    public ResponseBody(HttpStatus status, Object message, Object result) {
        this.status = status.value();
        this.message = message;
        this.result = result;
    }

    public ResponseBody(HttpStatus status, Object message) {
        this.status = status.value();
        this.message = message;
    }

    public ResponseBody(HttpStatus status) {
        this.status = status.value();
        this.message = status.name();
    }

    public ResponseBody(Object result) {
        this.status = HttpStatus.OK.value();
        this.message = HttpStatus.OK.name();
        this.result = result;
    }
}