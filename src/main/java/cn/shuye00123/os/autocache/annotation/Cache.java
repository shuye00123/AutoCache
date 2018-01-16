package cn.shuye00123.os.autocache.annotation;

import cn.shuye00123.os.autocache.constant.CacheOperation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by shuye on 2018/1/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cache {
    CacheOperation value() default CacheOperation.GET;
}
