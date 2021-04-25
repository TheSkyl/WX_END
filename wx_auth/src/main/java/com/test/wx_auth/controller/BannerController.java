package com.test.wx_auth.controller;

import com.wx.wx_lib.model.Banner;
import com.wx.wx_lib.service.BannerService;
import com.wx.wx_lib.utils.UnifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ban")
public class BannerController {

    @Autowired
    private BannerService service;

    @GetMapping("/Banner")
    public UnifyResult getAllBanner(){
        List<Banner> list = service.list();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            stringList.add(list.get(i).getLink());
        }
        System.out.println(stringList.toString());
        return UnifyResult.ok().data("banner",stringList);
    }
}
