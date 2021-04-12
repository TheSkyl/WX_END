package com.test.wx_auth.controller;

import com.test.wx_auth.config.InterceptorConfig;
import com.test.wx_auth.config.TokenInterceptor;
import com.test.wx_lib.model.CrudTest;
import com.test.wx_lib.service.CrudTestService;
import com.test.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/crud")
public class CrudTestController {

    @Autowired
    CrudTestService crudTestService;

    @PostMapping("/add")
    public UnifyResult add(@RequestBody CrudTest crudTest){
        System.out.println(crudTest.getName());
//        TokenInterceptor.i;
//        crudTest.setId(1);
        crudTestService.save(crudTest);
        return UnifyResult.ok();
    }

    @GetMapping("/list")
    public UnifyResult list(){
        List<CrudTest> crudTest= crudTestService.list();
        return UnifyResult.ok().data("list",crudTest);
    }

}
