package com.yxs.testcase.dao;

import com.yxs.testcase.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    UserInfo getById(Integer id);
    int updateUserInfo(UserInfo userInfo);
}
