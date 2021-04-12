package com.test.wx_lib.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.wx_lib.dao.BannerDao;
import com.test.wx_lib.model.Banner;
import com.test.wx_lib.service.BannerService;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerDao, Banner> implements BannerService {
}
