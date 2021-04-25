package com.test.wx_auth.controller;

import com.wx.wx_lib.model.Novel;
import com.wx.wx_lib.service.INovelService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("nov")
public class NovelController {

    @Autowired
    INovelService novelService;

    @GetMapping("/novel")
    public UnifyResult getAll(){
        List<Novel> novelList = novelService.list(null);
        return UnifyResult.ok().data("novel",novelList);
    }

}
