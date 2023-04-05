package com.yxs.testcase.componet;

import com.yxs.testcase.component.AComponent;
import com.yxs.testcase.component.BComponent;
import com.yxs.testcase.dao.UserInfoMapper;
import com.yxs.testcase.entity.UserInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class SimpleTest {
    @Mock
    private UserInfoMapper userInfoMapper;
    @Mock
    private BComponent bComponent;

    /**
     * 创建一个实例，简单的说是这个Mock可以调用真实代码的方法，其余用@Mock注解创建的mock将被注入到用该实例中
     */
    @InjectMocks
    AComponent aComponent;

    @Before
    public void intit(){
        // 为aComponent注入对象
        ReflectionTestUtils.setField(aComponent,"key","abcdefg");
    }

    /**
     * 最常见的测试用例，mock返回值
     */
    @Test
    public void normalTest(){
        Integer id = 1;
        Mockito.when(userInfoMapper.getById(id)).thenReturn(getManUserInfo());
        aComponent.normalMethod(id);
        Mockito.verify(userInfoMapper).getById(id);
    }

    /**
     * 测试同一个方法，入参不同的，返回值也不相同
     */
    @Test
    public void differentParamTest(){
        Integer user1 = 1;
        Integer user2 = 2;
        Mockito.when(userInfoMapper.getById(user1)).thenReturn(getManUserInfo());
        Mockito.when(userInfoMapper.getById(user2)).thenReturn(getFemaleUserInfo());
        boolean result = aComponent.compareUser(user1,user2);
        Assert.assertFalse(result);
    }

    /**
     * 入参比较复杂的时候可以使用Mockito.any，入参也是可以mock的
     * Mockito.any()可以有多种类型，比如：
     *      Mockito.any(ServiceEntity.class);
     *      Mockito.anyString();
     *      Mockito.anyCollection();
     *      Mockito.anyList();
     */
    @Test
    public void paramComplicated(){
        aComponent.complicatedService(Mockito.any(),Mockito.anyString());
        Mockito.verify(bComponent).complicatedMethod(Mockito.any(),Mockito.anyString());
    }

    /**
     * 当方法中出现异常的时候，可以使用doThrow方法自己制造异常
     */
    @Test
    public void exceptionTest(){
        Integer id = 1;
        Mockito.doThrow(new IllegalArgumentException()).when(bComponent).exceptionMethod(id);
        UserInfo userInfo = aComponent.exceptionService(id);
        Assert.assertTrue(userInfo == null);
    }

    @Test
    public void keyTest(){
        String key = aComponent.getKey();
        Assert.assertTrue("abcdefg".endsWith(key));
    }

    private UserInfo getManUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUserName("zhansan");
        userInfo.setAge(12);
        userInfo.setSex("M");
        return userInfo;
    }

    private UserInfo getFemaleUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2);
        userInfo.setUserName("李四");
        userInfo.setAge(12);
        userInfo.setSex("F");
        return userInfo;
    }

}
