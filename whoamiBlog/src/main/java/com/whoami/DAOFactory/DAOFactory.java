package com.whoami.DAOFactory;

import com.whoami.daodo.messageDaoDo;
import com.whomai.dao.messageDao;

public class DAOFactory {
	public static messageDao getMessageDAOInstance()
	{
		return new messageDaoDo() ;
	}
}
