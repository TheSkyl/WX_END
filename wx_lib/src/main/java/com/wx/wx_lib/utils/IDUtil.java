package com.wx.wx_lib.utils;

import java.util.UUID;

/**
 * UUID 工具类
 */
public class IDUtil {

    public static String UUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
