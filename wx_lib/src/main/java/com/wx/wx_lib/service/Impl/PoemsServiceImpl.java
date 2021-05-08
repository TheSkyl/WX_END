package com.wx.wx_lib.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.wx_lib.dao.PoemsDao;
import com.wx.wx_lib.model.Poems;
import com.wx.wx_lib.service.PoemsService;
import org.springframework.stereotype.Service;

@Service
public class PoemsServiceImpl extends ServiceImpl<PoemsDao, Poems> implements PoemsService {
}
