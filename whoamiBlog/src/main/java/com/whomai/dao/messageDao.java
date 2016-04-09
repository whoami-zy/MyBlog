package com.whomai.dao;

import java.util.List;

import com.whoami.po.message;

public interface messageDao {
	public boolean addMessage(message mess);
	public boolean delecttMessage(int id);
	public List<message> viewByLanguage(String hql,int offset, int pageSize );
	public int leaveAllCoubt(String hql);
	public List<message> newInsert();
}
