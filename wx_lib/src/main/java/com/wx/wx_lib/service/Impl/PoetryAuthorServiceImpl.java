package com.wx.wx_lib.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.wx_lib.dao.PoetryAuthorDao;
import com.wx.wx_lib.model.PoetryAuthor;
import com.wx.wx_lib.service.PoetryAuthorService;
import org.springframework.stereotype.Service;

@Service
public class PoetryAuthorServiceImpl extends ServiceImpl<PoetryAuthorDao, PoetryAuthor> implements PoetryAuthorService {
}
