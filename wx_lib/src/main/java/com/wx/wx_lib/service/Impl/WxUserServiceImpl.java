package com.wx.wx_lib.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wx.wx_lib.dao.WxUserDao;
import com.wx.wx_lib.model.WxUser;
import com.wx.wx_lib.service.WxUserService;
import com.wx.wx_lib.utils.IDUtil;
import com.wx.wx_lib.utils.JwtUtils;
import com.wx.wx_lib.vo.WxLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class WxUserServiceImpl extends ServiceImpl<WxUserDao, WxUser> implements WxUserService {

    @Autowired
    private WxUserDao wxUserDao;

    @Autowired
    private WxUserService service;

    //默认头像
    private static final String AVATAR = "http://localhost:8989/img/avaturl.jpg";

    public Optional<WxUser> checkUserIsExist(String openid) {
        QueryWrapper<WxUser> wxUserQueryWrapper = new QueryWrapper<>();
        wxUserQueryWrapper.eq("openid",openid);
        return wxUserDao.selectByOne(wxUserQueryWrapper);
    }

    @Override
    public WxLoginVO login(String openid) {
        Optional<WxUser> userOptional = this.checkUserIsExist(openid);
        WxUser wxUser = userOptional.orElseGet(()-> this.register(openid,"ttjkperson"+123,null,AVATAR));
        String token = JwtUtils.createToken(wxUser.getId(), wxUser.getName(), wxUser.getAvatar());
        return new WxLoginVO(token,wxUser.getName(),wxUser.getAvatar(),wxUser.getMobile());
    }

    public WxUser register(String openid, String name, String mobile, String avatar){
        WxUser wxUser = new WxUser(IDUtil.UUID(),mobile,openid,"passtest",avatar,name, LocalDateTime.now());
        service.save(wxUser);
        QueryWrapper<WxUser> wxUserQueryWrapper = new QueryWrapper<>();
        wxUserQueryWrapper.eq("openid",openid);
        return wxUserDao.selectOne(wxUserQueryWrapper);
    }
}
