package com.provider.service;

import com.provider.domain.DemoUser;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TestService {

    Integer createDemo(String tap);

    List<DemoUser> readDemo(String tap);

    Integer delDemo(Long id);

    Integer updDemo(DemoUser demoUser);
}
