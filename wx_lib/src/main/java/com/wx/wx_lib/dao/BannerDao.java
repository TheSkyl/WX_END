package com.wx.wx_lib.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wx.wx_lib.model.Banner;
import org.apache.ibatis.annotations.Mapper;

//@Component
@Mapper
public interface BannerDao extends BaseMapper<Banner> {
}
