//package com.wx.wx_auth.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//@Order(1)  //此注解判断执行优先级,值小的先执行，值越小，优先级就越高
//@Aspect
//@Configuration
//public class TestAopProxy {
//
//    @Pointcut(value = "execution(* com.wx.wx_auth.controller.*.*(..))")
//    public void pointcut(){
//        System.out.println("公共切入点");
//    }
//
//    @Before(value = "pointcut()")
//    public void before(){
//        System.out.println("test_before");
//    }
//
//    @After(value = "execution(* com.wx.wx_auth.controller.*.*(..))")
//    public void after(){
//        System.out.println("test_after");
//    }
//
//    @Around(value = "execution(* com.wx.wx_auth.controller.*.*(..))")
//    public void Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        System.out.println("test_Around");
//
//        proceedingJoinPoint.proceed();
//
//        System.out.println("test_Around_atrer");
//    }
//
//    @AfterReturning(value = "execution(* com.wx.wx_auth.controller.*.*(..))")
//    public void AfterReturning(){
//        System.out.println("test_AfterReturning");
//    }
//}
