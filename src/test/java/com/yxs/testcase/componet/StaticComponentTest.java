package com.yxs.testcase.componet;

import com.yxs.testcase.component.StaticComponent;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @author 洋小松
 * @date 2023/3/21
 * 静态mock测试用例
 */

/**
 * 静态Mock需要使用PowerMockRunner
 * 并使用PrepareForTest，该测试代表不会实际执行ThreadContext这个类
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ThreadContext.class})
public class StaticComponentTest {

    @InjectMocks
    StaticComponent staticComponent;

    @Test
    public void getUserId(){
        String userId = "12345";
        PowerMockito.mockStatic(ThreadContext.class);
        Subject localSubject = PowerMockito.mock(Subject.class);
        when(ThreadContext.getSubject()).thenReturn(localSubject);

        PrincipalCollection principalCollection = PowerMockito.mock(PrincipalCollection.class);
        when(localSubject.getPrincipals()).thenReturn(principalCollection);
        when(principalCollection.getPrimaryPrincipal()).thenReturn("12345");

        String resultUserId = staticComponent.getUserId();

        Assert.assertTrue(userId.equals(resultUserId));
    }
}
