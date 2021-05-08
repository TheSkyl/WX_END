package com.wx.wx_lib.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.wx_lib.dao.PoemsAuthorDao;
import com.wx.wx_lib.model.PoemsAuthor;
import com.wx.wx_lib.service.PoemsAuthorService;
import org.springframework.stereotype.Service;

@Service
public class PoemsAuthorServiceImpl extends ServiceImpl<PoemsAuthorDao, PoemsAuthor> implements PoemsAuthorService {
}
