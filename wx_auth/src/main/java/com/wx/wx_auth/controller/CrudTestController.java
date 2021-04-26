package com.wx.wx_auth.controller;

import com.wx.wx_lib.model.CrudTest;
import com.wx.wx_lib.service.CrudTestService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
