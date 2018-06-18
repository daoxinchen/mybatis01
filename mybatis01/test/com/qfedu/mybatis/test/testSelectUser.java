package com.qfedu.mybatis.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.qfedu.mybatis.mapper.UserMapper;
import com.qfedu.mybatis.pojo.User;
import com.qfedu.mybatis.utils.MyBatisUtil;

public class testSelectUser {

	@Test
	public void testSelectUser2() {
		try {
			SqlSession session = MyBatisUtil.getSqlSession();

			UserMapper userMapper = session.getMapper(UserMapper.class);

			User user = userMapper.selectUser("1");

			session.close();

			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testSelectUserNoInterface() {
		SqlSession session = MyBatisUtil.getSqlSession();

		User user = (User) session.selectOne("com.qfedu.mybatis.mapper.UserMapper.selectUser", "1");
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
		for (User u : userList) {
			System.out.println(u);
		}
	}

	@Test
	public void testSelectUserByUserName2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		List<User> userList = userMapper.selectUserByUserName2("三");
		sqlSession.close();
		for (User u : userList) {
			System.out.println(u);
		}
	}

	@Test
	public void testSelectUserByPage() {
		try {
			SqlSession sqlSession = MyBatisUtil.getSqlSession();

			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			List<User> userList = userMapper.selectUserByPage(2, 2);
			
			sqlSession.close();
			
			for (User u : userList) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testSelectUserByPage2() {
		try {
			SqlSession sqlSession = MyBatisUtil.getSqlSession();

			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			List<User> userList = userMapper.selectUserByPage(2, 2);
			
			sqlSession.close();
			
			for (User u : userList) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testSelectUserByPage3() {
		try {
			SqlSession sqlSession = MyBatisUtil.getSqlSession();

			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			Map<String,Object> map = new HashMap<String,Object>();
			
			map.put("offset", 2);
			map.put("pagesize", 2);
			
			List<User> userList = userMapper.selectUserByPage3(map);
			
			sqlSession.close();
			
			for (User u : userList) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void insertUser() {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User user = new User();
		
		int count = userMapper.insertUser(user);
		
		session.commit();
		
		session.close();
		
		System.out.println("插入"+count+"条记录");
		
	}
	
	@Test
	public void testInsertUserMysql() {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User user = new User();
		
		int count = userMapper.insertUserMysql(user);
		
		session.commit();
		
		session.close();
		
		System.out.println("插入"+count+"条记录");
		
	}
	
	@Test
	public void testUpdateUser() {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User user = new User();
		user.setId("6");//要修改的id数据库已存在
		user.setUserName("张四丰");
		int count = userMapper.updateUser(user);
		
		session.commit();
		
		session.close();
		
		System.out.println("插入"+count+"条记录");
		
	}
	
	@Test//只修改某一个字段
	public void testUpdateUser2() {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User user = userMapper.selectUser("1");
		
		user.setUserName(user.getUserName()+"(修改后)");
		
		int count = userMapper.updateUser(user);
		
		session.commit();
		
		session.close();
		
		System.out.println("插入"+count+"条记录");
	}
	
	@Test
	public void testDeleteUserById() {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int count = userMapper.deleteUserById("63.0");
		session.commit();
		System.out.println("删除了"+count+"条记录");
	}
	
	/* 动态sql */
	@Test
	public void testSelectDeptUserByAddress() {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> userList = userMapper.selectDeptUserByAddress(null);
		for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println(user);
		}
	}
	
	@Test
	public void testSelectDeptUserByAddressOrName() {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User u = new User();
		u.setAddress("%州%");
		u.setUserName("张居正");
		
		List<User> userList = userMapper.selectDeptUserByAddressOrName(u);
		for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println(user);
		}
	}
	
}
