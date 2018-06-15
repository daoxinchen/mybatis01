package com.qfedu.mybatis.mapper;

import java.util.List;

import com.qfedu.mybatis.pojo.User;

public interface UserMapper {
	User selectUser(String id);
	User selectUser2(String id);
	List<User> selectUserByUserName(String userName);
	List<User> selectUserByUserName2(String userName);
}