package com.whoami.daodo;

import java.sql.*;

import com.whoami.sessionHelper.ConnectionHelper;
import com.whomai.dao.UserDao;

public class UserDaoDO implements UserDao {
/**
	public boolean resgion(user user) {
		Session session = new SessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		Integer integer = (Integer) session.save(user);
		tx.commit();
		if (integer > 0) {
			return true;
		} else {
			return false;
		}

	}
**/
	public boolean login(String name, String password) {
		/**
		 * hibernate语句
		user u = null;
		Session session = new SessionConnection().getSession();
		String hql = "from user u where u.u_name=? and u.u_passwd=?";
		Query query = (Query) session.createQuery(hql);
		query.setParameter(0, name);
		query.setParameter(1, password);
		@SuppressWarnings("unchecked")
		List<user> list = (List<user>) query.list();
		Iterator<user> it = list.iterator();
		if (it.hasNext())
			u = it.next();
		if (u != null) {
			return true;
		} else {
			return false;
		}
		*/
		/**
		 * mysql语句
		 */
		Connection conn =new ConnectionHelper().getConnection();
		String sql ="Select * from user where u_name=? and u_passwd = ?";
		PreparedStatement pst =null;
		ResultSet rs=null;
		try {
			 pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()){
				rs.close();
				pst.close();
				conn.close();
				return true;
			}
			else{
				rs.close();
				pst.close();
				conn.close();
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	public List<user> selectById(int id) {
		Session s = new SessionConnection().getSession();
		String hql = "from user u where u.u_id=? ";
		Query query = s.createQuery(hql);
		query.setInteger(0, id);
		@SuppressWarnings("unchecked")
		List<user> list = query.list();
		return list;
	}
	public int selectByName(String name) {
		Session s = new SessionConnection().getSession();
		String hql = "from user u where u.u_name=? ";
		Query query = s.createQuery(hql);
		query.setString(0, name);
		@SuppressWarnings("unchecked")
		List<user> list = query.list();
		
		return list.get(0).getU_id();
	}
	public boolean delectUser(int id) {
		Session session = new SessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete user u where u.u_id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, id);
		int i = query.executeUpdate();
		tx.commit();
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<user> selectByAll(int page) {
		Session session = new SessionConnection().getSession();
		// NextAndUp page =new NextAndUp();
		String hql = "from user";
		Query query = (Query) session.createQuery(hql);
		query.setFirstResult((page - 1) * 5);
		query.setMaxResults(5);
		@SuppressWarnings("unchecked")
		List<user> list = (List<user>) query.list();
		return list;
	}

	public int getmaxpagecount() {

		Session session = new SessionConnection().getSession();
		// NextAndUp page =new NextAndUp();
		String hql = "from user";
		Query query = (Query) session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<user> list = (List<user>) query.list();
		return list.size();
	}

	public boolean updateuser(user u) {
		Session session = new SessionConnection().getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(u);
		tx.commit();
		if (u != null) {
			return true;
		} else {
			return false;
		}
	}
	**/
}
