package com.yxs.testcase.componet;

import com.yxs.testcase.component.AComponent;
import com.yxs.testcase.dao.UserInfoMapper;
import com.yxs.testcase.entity.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

public class AComponentTest {
    @Mock
    private UserInfoMapper userInfoMapper;

    AComponent aComponent;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
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
