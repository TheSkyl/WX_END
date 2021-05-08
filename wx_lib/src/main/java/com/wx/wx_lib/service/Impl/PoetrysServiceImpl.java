package com.wx.wx_lib.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.wx_lib.dao.PoetrysDao;
import com.wx.wx_lib.model.Poetrys;
import com.wx.wx_lib.service.PoetrysService;
import org.springframework.stereotype.Service;

@Service
public class PoetrysServiceImpl extends ServiceImpl<PoetrysDao, Poetrys> implements PoetrysService {
}
