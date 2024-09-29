package com.wjy.backend.service.impl;

import com.wjy.backend.mapper.BlogMapper;
import com.wjy.backend.service.TestService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/29 19:07
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}
