package aop.dao;

import org.springframework.stereotype.Repository;

@Repository(value="userDao")
public class UserDaoImpl implements UserDao{


	public void addUser() {
		System.out.println("新增用户");
	}

	public void updateUser() {
		System.out.println("修改用户");
	}

	public String getUsername() {
		return "tony";
	}

}
