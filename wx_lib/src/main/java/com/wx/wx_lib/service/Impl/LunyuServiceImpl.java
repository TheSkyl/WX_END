package com.wx.wx_lib.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.wx_lib.dao.LunyuDao;
import com.wx.wx_lib.model.Lunyu;
import com.wx.wx_lib.service.LunyuService;
import org.springframework.stereotype.Service;

@Service
public class LunyuServiceImpl extends ServiceImpl<LunyuDao, Lunyu> implements LunyuService {
}
