package com.wx.authserver.service;

import com.wx.authserver.entity.Permission;
import com.wx.authserver.entity.Users;
import com.wx.authserver.mapper.PermissionMapper;
import com.wx.authserver.mapper.UsersMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 自定义设置用户名密码和权限
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //注入
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 通过UserDetails 返回用户名密码进行验证
     * @param username 表单传过来的用户名
     * @return User对象
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //调用usersMapper方法查询数据库
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        // where username =?
        wrapper.eq("username",username);
        //语句相当于 select ？ ? ? where username = ?
        Users users = usersMapper.selectOne(wrapper);
        //判断用户是否存在
        if (users == null ) {   //不存在就会认证失败
            throw new UsernameNotFoundException("用户名不存在");
        }

        /**
         * SELECT p.`code` FROM `permission` p
         * LEFT JOIN role_permission rp ON rp.permission_id = p.id
         * LEFT JOIN role r on r.id = rp.role_id
         * LEFT JOIN user_role ur on ur.role_id= r.id
         * LEFT JOIN users u on u.id = ur.user_id
         * WHERE u.id=1
         */
        QueryWrapper<Permission> wrapper2 = new QueryWrapper<>();
        // where username =?
        wrapper.eq("u.id",users.getId());
        List<Permission> permissions = permissionMapper.selectByUserId(users.getId());

        String[] permissionArray = new String[permissions.size()];
        String str = "";
        for (int i = 0; i < permissions.size(); i++) {
            str+="ROLE_"+permissions.get(i).getCode()+",";
        }
        String value = str.substring(0,str.length()-1);
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(value);
        //从数据库返回user对象，得到用户名 和密码 以及权限
        return new User(users.getUsername(),users.getPassword(),authorities);
    }
}
