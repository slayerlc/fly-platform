package com.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.provider.domain.DemoUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestMapper extends BaseMapper<DemoUser> {

     List<DemoUser> readDemo(@Param("tap") String tap);
}
