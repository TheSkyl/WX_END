package com.test.wx_auth.controller;

import com.test.wx_lib.utils.UnifyResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class InTheEndTestController {

    @RequestMapping("/hello")
    @ResponseBody
    public Object hello(){

        Map<String,Object> map = new HashMap<>();
        map.put("name","漂亮妹妹");
        map.put("leg","贼长");

        return UnifyResult.ok().data(map);
    }

}
