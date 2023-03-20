package com.yxs.testcase.component;

import com.yxs.testcase.dao.UserInfoMapper;
import com.yxs.testcase.entity.ServiceEntity;
import com.yxs.testcase.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BComponent {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public void complicatedMethod(ServiceEntity serviceEntity, String name){
        //...
        System.out.println(serviceEntity.getCreatedTime());
        System.out.println(name);
    }

    public UserInfo exceptionMethod(Integer id){
        UserInfo userInfo = userInfoMapper.getById(id);
        if (userInfo == null){
            throw new IllegalArgumentException("user info is null");
        }
        return userInfo;
    }
}
