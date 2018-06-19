package com.qfedu.mybatis.pojo;

public class User {
	private String id;
	private String userName;
	private Integer age;
	private String address;
	private Integer deptId;
	
	public User() {
		super();
		//this.id = (int)(Math.floor(Math.random()*100))+"";
		/*this.id="33";
		this.userName="默认";
		this.age=3;
		this.address="aaa";
		this.deptId=1;*/
		
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
		@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", age=" + age + ", address=" + address + ", deptId="
				+ deptId + "]";
	}
}