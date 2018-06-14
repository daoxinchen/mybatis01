package com.qfedu.mybatis.mapper;

import com.qfedu.mybatis.pojo.User;

public interface UserMapper {
	User selectUser(String id);
}