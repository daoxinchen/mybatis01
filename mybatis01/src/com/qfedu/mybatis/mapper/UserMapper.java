package com.qfedu.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.qfedu.mybatis.pojo.User;

public interface UserMapper {
	User selectUser(String id);
	User selectUser2(String id);
	List<User> selectUserByUserName(String userName);
	List<User> selectUserByUserName2(String userName);
	List<User> selectUserByPage(int offset,int pagesize);
	List<User> selectUserByPage2(@Param(value="offset")int offset,@Param(value="pagesize")int pagesize);
	List<User> selectUserByPage3(Map<String,Object> map);
	int insertUser(User user);
	int insertUserMysql(User user);
	int updateUser(User user);
	int deleteUserById(String id);
	
	/* 动态sql */
	List<User> selectDeptUserByAddress(String address);
	
	List<User> selectDeptUserByAddressOrName(User user);
	
	List<User> selectUserByCondition(User user);
	
	int updateUserByCondition(User user);
	
	List<User> selectUserByConditionTrim(User user);
	
	int updateUserByConditionTrim(User user);
	
	int deleteUserList(List<String> ids);
}