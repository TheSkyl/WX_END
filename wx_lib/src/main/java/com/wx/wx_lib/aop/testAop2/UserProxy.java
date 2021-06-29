//package com.wx.wx_lib.aop.testAop2;
//
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect//生成代理对象
//@Component
//public class UserProxy {
//
//    /**
//     * 定义切点
//     */
//    @Pointcut(value = "execution(* com.wx.wx_lib.aop.testAop2.User.*(..)) ")
//    public void cutOffpoint(){
//
//    }
//
//    //前置方法
//    @Before(value = "execution(* com.wx.wx_lib.aop.testAop2.User.add(..))") //指定那个方法进行前置
//    public void before(){
//        System.out.println("before................");
//    }
//
//}
