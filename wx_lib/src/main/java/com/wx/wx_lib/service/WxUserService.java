package com.wx.wx_lib.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wx.wx_lib.model.WxUser;
import com.wx.wx_lib.vo.WxLoginVO;

public interface WxUserService extends IService<WxUser> {

    WxLoginVO login(String openid);

}
