package com.auth.authserver.mapper;

import com.auth.authserver.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UsersMapper extends BaseMapper<Users> {
}
