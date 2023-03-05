package com.yxs.testcase.component;

import com.yxs.testcase.dao.UserInfoMapper;
import com.yxs.testcase.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AComponent {
    @Value("${test-case.key}")
    private String key;
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo normalMethod(Integer id){
        return userInfoMapper.getById(id);
    }
}
