package com.wx.wx_lib.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wx.wx_lib.model.Chains;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Map;

public interface ChainsService extends IService<Chains> {

    public Boolean add(String values) throws BadHanyuPinyinOutputFormatCombination;

    public char getEnd();
}
