package com.nowcoder.community.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义注解，标识作用
@Target(ElementType.METHOD)   // 作用于方法上
@Retention(RetentionPolicy.RUNTIME)  // 运行时有效
public @interface LoginRequired {  // 注解表示是否需要登录，标识作用
}
