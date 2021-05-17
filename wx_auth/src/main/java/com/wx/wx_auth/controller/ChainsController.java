package com.wx.wx_auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wx.wx_lib.model.Chains;
import com.wx.wx_lib.service.ChainsService;
import com.wx.wx_lib.utils.UnifyResult;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chains")
public class ChainsController {

    @Autowired
    private ChainsService service;

    @GetMapping("/getAll")
    public UnifyResult getAll(){
        return UnifyResult.ok().data("cy",service.list(new QueryWrapper<Chains>().orderByDesc("id")));
    }

    @GetMapping("/getEnd")
    public UnifyResult getEnd(){
        return UnifyResult.ok().data("end",service.getEnd());
    }

    @PostMapping("/add")
    public UnifyResult add(@RequestBody String chains) throws BadHanyuPinyinOutputFormatCombination {

        String v = chains.replace("\"","");
        Boolean result = service.add(v);
        if (result == null){
            return UnifyResult.ok().data("msg","接龙失败");
        }else if (result == false){
            return UnifyResult.ok().data("msg","接龙失败");
        }
        return UnifyResult.ok().data("msg","接龙成功");
    }
}
