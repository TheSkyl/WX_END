//package com.wx.wx_lib.aop;
//
//import com.wx.wx_lib.aop.testaop.testDaoAop;
//import com.wx.wx_lib.aop.testaop.testDaoAopImpl;
//import com.wx.wx_lib.dao.CyDao;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.util.Arrays;
//
///**
// * JDK进行接口代理
// */
//public class JDKProxy {
//
//    public static void main(String[] args) {
//        Class[] interfaces = {testDaoAop.class};
//
//        testDaoAopImpl testDaoAops = new testDaoAopImpl();
//        testDaoAop testsDaoAop = (testDaoAop) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),interfaces, new TestDao(testDaoAops));
//        int result = testsDaoAop.add(1,2);
//        System.out.println(result);
//    }
//}
//
//class TestDao implements InvocationHandler {
//
//    private Object object;
//
//    //创建who的代理对象，把who传递过来
//    public TestDao(Object o){
//        this.object = o;
//    }
//
//    //增强逻辑
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//        //方法前处理
//        System.out.println("方法前执行"+method.getName()+"参数"+ Arrays.toString(args));
//
//        //执行增强方法
//        Object res = method.invoke(object,args);
//
//        //方法后处理
//        System.out.println("方法后执行");
//        return res;
//    }
//}
