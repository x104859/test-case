package com.yxs.testcase.controller;

import com.yxs.testcase.component.AComponent;
import com.yxs.testcase.entity.UserInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author 洋小松
 * @date 2023/3/20
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
    @InjectMocks
    private AController aController;
    @Mock
    private AComponent aComponent;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(aController).build();
    }

    /**
     * 使用http方法调用的方式来测试controller
     *
     * @throws Exception
     */
    @Test
    public void controllerMvcTest() throws Exception {
        Integer id = 1;
        Mockito.when(aComponent.normalMethod(id)).thenReturn(getManUserInfo());
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/user//info?id="+id))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertNotNull(content);
    }

    private UserInfo getManUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUserName("zhansan");
        userInfo.setAge(12);
        userInfo.setSex("M");
        return userInfo;
    }
}
