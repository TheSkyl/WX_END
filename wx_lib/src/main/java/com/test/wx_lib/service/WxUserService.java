package com.test.wx_lib.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.wx_lib.model.WxUser;
import com.test.wx_lib.vo.WxLoginVO;

public interface WxUserService extends IService<WxUser> {

    WxLoginVO login(String openid);

}
