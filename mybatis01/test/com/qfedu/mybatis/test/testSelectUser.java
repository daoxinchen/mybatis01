package com.qfedu.mybatis.test;

import java.util.ArrayList;
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
		u.setAddress("");
		u.setUserName("");
		
		List<User> userList = userMapper.selectDeptUserByAddressOrName(u);
		for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println(user);
		}
	}
	
	@Test 
	public void testSelectUserByCondition() {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User u = new User();
		u.setUserName("");
		u.setAddress("%江%");
		u.setDeptId(1);
		
		List<User> userList = userMapper.selectUserByCondition(u);
		
		for (User user : userList) {
			System.out.println(user);
		}
		
	}
	
	@Test 
	public void testUpdateUserByCondition() {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User u = new User();
		u.setId("11");
		u.setAge(20);
		
		int count = userMapper.updateUserByCondition(u);
		
		session.commit();
		session.close();
		System.out.println(u);
		System.out.println("修改了"+count+"行");
	}
	
	
	
	@Test 
	public void testSelectUserByConditionTrim() {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User u = new User();
		u.setAddress("%江%");
		u.setDeptId(1);
		
		List<User> userList = userMapper.selectUserByConditionTrim(u);
		
		for (User user : userList) {
			System.out.println(user);
		}
		
	}
	
	@Test 
	public void testUpdateUserByConditionTrim() {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User u = new User();
		u.setId("11");
		u.setAge(20);
		
		int count = userMapper.updateUserByConditionTrim(u);
		
		session.commit();
		session.close();
		System.out.println(u);
		System.out.println("修改了"+count+"行");
	}
	
	@Test
	public void testDeleteUserList() {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<String> ids = new ArrayList<String>();
		ids.add("33");
		ids.add("2345");
		int count = userMapper.deleteUserList(ids);
		session.commit();
		session.close();
		System.out.println("删除了"+count+"条记录");
		
	}
	
	/**
	 * 测试一级缓存：
	 * 		从下面测试结果可以看到，查询语句一样的话，查询语句只打印了一次
	 * 		如果查询语句不同，会打印两次查询语句
	 */
	@Test
	public void testSelectUserCacheLevelOne1() {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User user1 = userMapper.selectUser("1");
		System.out.println("结果已查询");
		User user2 = userMapper.selectUser("1");
		System.out.println("结果已查询：从缓存中获取数据");
		
		session.close();
		
		System.out.println("session关闭");
	}
	
	@Test
	public void testSelectUserCacheLevelOne2() {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User user1 = userMapper.selectUser("1");
		System.out.println("结果已查询");
		
		user1.setDeptId(3);
		userMapper.updateUser(user1);
		System.out.println("刷新缓存");
		
		
		User user2 = userMapper.selectUser("1");
		System.out.println("重新执行缓存");
		
		session.commit();
		session.close();
		
		System.out.println("session关闭");
	}
}
