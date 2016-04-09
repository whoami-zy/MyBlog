package com.whomai.dao;

public interface UserDao {
	//public boolean resgion(user user);
	public boolean login(String name, String password);
	/**
	public List<user> selectById(int id);
	public List<user> selectByAll(int page);
	public int getmaxpagecount();
	public boolean delectUser(int id);
	
	public int selectByName(String name);
	**/
//	public boolean updateuser(user u);
}
