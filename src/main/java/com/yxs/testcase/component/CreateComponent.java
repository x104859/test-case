package com.yxs.testcase.component;

import com.alibaba.fastjson2.JSONObject;
import com.yxs.testcase.entity.MethodResult;
import com.yxs.testcase.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
@Service
public class CreateComponent {

    @Autowired
    private RestTemplate restTemplate;

    public MethodResult addUser(UserInfo user)throws Exception{
        Map<String,String> map = new HashMap<>();
        map.put("name",String.valueOf(user.getId()));
        map.put("email",user.getEmail());
        map.put("nickname",user.getNickname());
        MultiValueMap<String, String> header = new LinkedMultiValueMap();
        header.put(HttpHeaders.CONTENT_TYPE, Collections.singletonList(MediaType.APPLICATION_JSON_VALUE));
        HttpEntity request = new HttpEntity(JSONObject.toJSONString(map), header);
        String url = "http://127.0.0.1:8088/add/user";
        try{
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            MethodResult result = JSONObject.parseObject(response.getBody(), MethodResult.class);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
