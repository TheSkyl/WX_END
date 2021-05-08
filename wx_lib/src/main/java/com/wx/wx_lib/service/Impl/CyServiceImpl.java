package com.wx.wx_lib.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.wx_lib.dao.CyDao;
import com.wx.wx_lib.model.Cy;
import com.wx.wx_lib.service.CyService;
import org.springframework.stereotype.Service;

@Service
public class CyServiceImpl extends ServiceImpl<CyDao, Cy> implements CyService {
}
