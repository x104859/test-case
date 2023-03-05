package com.yxs.testcase.componet;

import com.yxs.testcase.component.AComponent;
import com.yxs.testcase.dao.UserInfoMapper;
import com.yxs.testcase.entity.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class AComponentTest_Other {
    @Mock
    private UserInfoMapper userInfoMapper;

    AComponent aComponent = new AComponent();

    @Before
    public void init(){
        aComponent = new AComponent();
        ReflectionTestUtils.setField(aComponent,"userInfoMapper",userInfoMapper);
    }

    @Test
    public void normalTest(){
        Integer id = 1;
        Mockito.when(userInfoMapper.getById(id)).thenReturn(getUserInfo());
        aComponent.normalMethod(id);

        Mockito.verify(userInfoMapper).getById(id);
    }

    private UserInfo getUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUserName("zhansan");
        userInfo.setAge(12);
        userInfo.setSex("M");
        return userInfo;
    }

}
