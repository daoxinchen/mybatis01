package com.qfedu.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.qfedu.mybatis.mapper.UserMapper;
import com.qfedu.mybatis.pojo.User;
import com.qfedu.mybatis.utils.MyBatisUtil;

public class testSelectUser {

	@Test
	public void testSelectUser2() {
		SqlSession session = MyBatisUtil.getSqlSession();
		
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User user = userMapper.selectUser("1");
		
		session.close();
		
		System.out.println(user);
		
	}
	
	@Test
	public void testSelectUserNoInterface() {
		SqlSession session = MyBatisUtil.getSqlSession();
		
		User user = (User)session.selectOne("com.qfedu.mybatis.mapper.UserMapper.selectUser","1");
		System.out.println(user);
		session.close();
	}
	
	
	@Test
	public void testSelectUser() {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.selectUser("1");
		
		System.out.println(user);
		
		sqlSession.close();
	}
	
	@Test 
	public void testSelectUserByUserName() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> userList = userMapper.selectUserByUserName("%三%");
		sqlSession.close();
		for(User u : userList) {
			System.out.println(u);
		}
	}
	
	@Test 
	public void testSelectUserByUserName2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> userList = userMapper.selectUserByUserName2("三");
		sqlSession.close();
		for(User u : userList) {
			System.out.println(u);
		}
	}
	
}
