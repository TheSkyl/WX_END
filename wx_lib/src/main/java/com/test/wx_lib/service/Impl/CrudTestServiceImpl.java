package com.test.wx_lib.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.wx_lib.dao.CrudTestDao;
import com.test.wx_lib.model.CrudTest;
import com.test.wx_lib.service.CrudTestService;
import org.springframework.stereotype.Service;

@Service
public class CrudTestServiceImpl extends ServiceImpl<CrudTestDao, CrudTest> implements CrudTestService {
}
