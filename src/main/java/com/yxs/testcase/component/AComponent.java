package com.yxs.testcase.component;

import com.yxs.testcase.dao.UserInfoMapper;
import com.yxs.testcase.entity.ServiceEntity;
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
    @Autowired
    private BComponent bComponent;

    public UserInfo normalMethod(Integer id){
        UserInfo userInfo = userInfoMapper.getById(id);
        System.out.println(userInfo.getSex());
        return userInfo;
    }

    public boolean compareUser(Integer originId,Integer targetId){
        UserInfo originUser = userInfoMapper.getById(originId);
        UserInfo targetUser = userInfoMapper.getById(targetId);
        return originUser.getSex().equals(targetUser.getSex());
    }


    public void complicatedService(ServiceEntity serviceEntity, String name){
        //...
        bComponent.complicatedMethod(serviceEntity,name);
        //...
    }

    public UserInfo exceptionService(Integer id){
        UserInfo userInfo = null;
        try {
            userInfo = bComponent.exceptionMethod(id);
        }catch (Exception e){
            return null;
        }
        return userInfo;
    }

    public void updateUserInfo(UserInfo userInfo){
        userInfoMapper.updateUserInfo(userInfo);
    }

    public String getKey(){
        return key;
    }
}
