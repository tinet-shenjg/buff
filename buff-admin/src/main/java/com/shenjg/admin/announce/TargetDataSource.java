package com.shenjg.admin.announce;

/**
 * @author shenjg
 * @date 2018/12/25
 **/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 目标数据源注解，注解在方法上指定数据源的名称
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TargetDataSource {
    String value();//此处接收的是数据源的名称
}
