package com.provider.service.impl;

import com.provider.domain.DemoUser;
import com.provider.mapper.TestMapper;
import com.provider.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public Integer createDemo(String tap) {
        DemoUser demoUser = new DemoUser();
        demoUser.setGender(1);
        demoUser.setName("lvchao"+tap);
        return testMapper.insert(demoUser);
    }

    @Override
    public List<DemoUser> readDemo(String tap) {
        return testMapper.readDemo(tap);
    }

    @Override
    public Integer delDemo(Long id) {
        return testMapper.deleteById(id);
    }

    @Override
    public Integer updDemo(DemoUser demoUser) {
        return  testMapper.updateById(demoUser);
    }


}
