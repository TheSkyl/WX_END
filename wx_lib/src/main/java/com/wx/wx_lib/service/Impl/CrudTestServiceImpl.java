package com.wx.wx_lib.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.wx_lib.dao.CrudTestDao;
import com.wx.wx_lib.model.CrudTest;
import com.wx.wx_lib.service.CrudTestService;
import org.springframework.stereotype.Service;

@Service
public class CrudTestServiceImpl extends ServiceImpl<CrudTestDao, CrudTest> implements CrudTestService {
}
