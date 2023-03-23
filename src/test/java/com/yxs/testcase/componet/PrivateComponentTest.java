package com.yxs.testcase.componet;

import com.yxs.testcase.component.PrivateComponent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Method;

/**
 * @author 洋小松
 * @date 2023/3/23
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PrivateComponent.class)
public class PrivateComponentTest {

    @InjectMocks
    private PrivateComponent privateComponent;

    /**
     * 测试复杂的方法，跳过方法内部的私有方法：1、该私有方法没有返回值
     * @throws Exception
     */
    @Test
    public void jumpPrivateMethodTest()throws Exception{
        PrivateComponent component = PowerMockito.spy(privateComponent);
        PowerMockito.doNothing().when(component,"methodA",1);
        Integer i = component.entranceMethod(1);
        System.out.println(i);
        Assert.assertTrue(i == 3);
    }

    /**
     * 测试复杂的方法，跳过方法内部的私有方法：2、该私有方法有返回值
     * @throws Exception
     */
    @Test
    public void jumpPrivateMethodTest2()throws Exception{
        PrivateComponent component = PowerMockito.spy(privateComponent);
        PowerMockito.doReturn(5).when(component,"methodB", Mockito.any());
        Integer i = component.entranceMethod(1);
        System.out.println(i);
        Assert.assertTrue(i == 6);
    }

    /**
     * 测试复杂方法，单独测试方法内部的私有方法
     * @throws Exception
     */
    @Test
    public void privateMethodTest()throws Exception{
        PrivateComponent component = PowerMockito.spy(privateComponent);
        Method method = PowerMockito.method(PrivateComponent.class,"methodB",Integer.class);
        Integer i = (Integer) method.invoke(component,1);
        System.out.println("result i = " + i);
        Assert.assertTrue(i == 2);
    }
}
