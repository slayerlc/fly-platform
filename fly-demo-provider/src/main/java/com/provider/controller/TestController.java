package com.provider.controller;

import com.common.domain.ResultMap;
import com.provider.domain.DemoUser;
import com.provider.service.TestService;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("test")
    public ResultMap<String> test(){
        return ResultMap.ok("hello provider","demo");
    }

    @RequestMapping("createDemo/{tap}")
    public ResultMap<Integer> createDemo(@PathVariable("tap") String tap ){
        return ResultMap.ok(testService.createDemo(tap));
    }

    @RequestMapping("readDemo/{tap}")
    public ResultMap<List> readDemo(@PathVariable("tap") String tap){
        return ResultMap.ok(testService.readDemo(tap));
    }

    @RequestMapping("delDemo/{id}")
    public ResultMap<Integer> delDemo(@PathVariable("id") Long id){
        return ResultMap.ok(testService.delDemo(id));
    }

    @RequestMapping("updDemo")
    public ResultMap<Integer> updDemo(@RequestBody DemoUser demoUser){
        return ResultMap.ok(testService.updDemo(demoUser));
    }

}
