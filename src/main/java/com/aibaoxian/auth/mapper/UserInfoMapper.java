package com.aibaoxian.auth.mapper;

import com.aibaoxian.auth.entity.UserInfo;

public interface UserInfoMapper {

    UserInfo selectByPrimaryKey(Integer id);

    int insert(UserInfo userInfo);

}