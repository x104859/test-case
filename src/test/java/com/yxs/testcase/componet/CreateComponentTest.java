package com.yxs.testcase.componet;

import com.alibaba.fastjson2.JSONObject;
import com.yxs.testcase.component.CreateComponent;
import com.yxs.testcase.entity.MethodResult;
import com.yxs.testcase.entity.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 洋小松
 * @date 2023/3/27
 */
@RunWith(PowerMockRunner.class)
public class CreateComponentTest {

    @Mock
    private  RestTemplate restTemplate;
    @InjectMocks
    private CreateComponent component;

    @Test
    public void createTest()throws Exception{
        UserInfo param = new UserInfo();
        param.setNickname("zhangsan");
        param.setEmail("zhangsan@supermap.com");
        param.setId(123);

        Map<String,String> map = new HashMap<>();
        map.put("name",String.valueOf(param.getId()));
        map.put("email",param.getEmail());
        map.put("nickname",param.getNickname());
        MultiValueMap<String, String> header = new LinkedMultiValueMap();
        header.put(HttpHeaders.CONTENT_TYPE, Collections.singletonList(MediaType.APPLICATION_JSON_VALUE));
        HttpEntity request = new HttpEntity(JSONObject.toJSONString(map), header);
        PowerMockito.whenNew(HttpEntity.class).withAnyArguments().thenReturn(request);

        ResponseEntity responseEntity = PowerMockito.mock(ResponseEntity.class);
        Mockito.when(restTemplate.postForEntity("http://127.0.0.1:8088/add/user",request,String.class)).thenReturn(responseEntity);
        MethodResult result = new MethodResult();
        result.setSucceed(true);
        PowerMockito.when(responseEntity.getBody()).thenReturn(JSONObject.toJSONString(result));
        MethodResult methodResult = component.addUser(param);
        Assert.assertTrue(methodResult.isSucceed());
    }
}
