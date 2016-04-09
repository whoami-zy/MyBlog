package com.whoami.daodo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.whoami.po.message;
import com.whoami.sessionHelper.ConnectionHelper;
import com.whoami.sessionHelper.SessionConnection;
import com.whomai.dao.messageDao;

public class messageDaoDo implements messageDao {

	public boolean addMessage(message mess) {
		/**
		Session session = new SessionConnection().getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(mess);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("事务提交错误");
			session.close();
			return false;
		}
		*/
		Connection conn = new ConnectionHelper().getConnection();
		PreparedStatement pst =null;
		String sql = "INSERT INTO message (`title`, `context`, `data_time`,`see`) VALUES (?,?,?,?);";
		int rs;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, mess.getTitle());
			pst.setString(2, mess.getContext());
			pst.setString(3, mess.getData_time());
			pst.setInt(4, mess.getSee());
			rs = pst.executeUpdate();
			if(rs>0){
				pst.close();
				conn.close();
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			try {
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	}

	public boolean delecttMessage(int id) {
		Session session = new SessionConnection().getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			String hql = "delete message  mess where mess.m_id=?";
			Query query = session.createQuery(hql);
			query.setInteger(0, id);
			int i = query.executeUpdate();
			tx.commit();
			if (i > 0) {
				session.close();
				return true;
			} else {
				session.close();
				return false;
			}
		} catch (Exception e) {
			session.close();
			return false;
		}

	}

	public List<message> viewByLanguage(String hql, int offset, int pageSize) {
		/**
		Session session = new SessionConnection().getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
			tx.commit();
			@SuppressWarnings("unchecked")
			List<message> list = query.list();
			session.close();
			return list;
		} catch (Exception e) {
			session.close();
			return null;
		}
	*/
			Connection conn =new ConnectionHelper().getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = hql+" limit ?,?";
			System.out.println(sql+"-------------------------------sql");
			List<message> list = new ArrayList<message>();
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, offset);
				pst.setInt(2, pageSize);
				rs = pst.executeQuery();
				while(rs.next()){
					message mess = new message();
					mess.setM_id(rs.getInt("m_id"));
					mess.setTitle(rs.getString("title"));
					mess.setContext(rs.getString("context"));
					mess.setU_id(rs.getInt("u_id"));
					mess.setData_time(rs.getString("data_time"));
					mess.setSee(rs.getInt("see"));
					list.add(mess);
				}
				pst.close();
				rs.close();
				conn.close();
				return list;
			} catch (Exception e) {
				try {
					if(pst!=null){
						pst.close();
					}
					if(conn!=null){
						conn.close();
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
	}

	public int leaveAllCoubt(String hql) {
		/**
		Session session = new SessionConnection().getSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<message> list = query.list();
		session.close();
		return list.size();
		*/
		Connection conn =new ConnectionHelper().getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<message> list = new ArrayList<message>();
		try {
			pst = conn.prepareStatement(hql);
			rs = pst.executeQuery();
			while(rs.next()){
				message mess = new message();
				mess.setM_id(rs.getInt("m_id"));
				mess.setTitle(rs.getString("title"));
				mess.setContext(rs.getString("context"));
				mess.setU_id(rs.getInt("u_id"));
				mess.setData_time(rs.getString("data_time"));
				mess.setSee(rs.getInt("see"));
				list.add(mess);
			}
			pst.close();
			rs.close();
			conn.close();
			return list.size();
		} catch (Exception e) {
			try {
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return 0;
		}
		
	}

	public List<message> newInsert() {
		/**
		Session session = new SessionConnection().getSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			String hql = "from message mess where mess.see=? order by mess.data_time desc";
			Query  query = session.createQuery(hql).setFirstResult(0).setMaxResults(4);
			query.setInteger(0, 1);
			tx.commit();
			@SuppressWarnings("unchecked")
			List<message> list = query.list();
			session.close();
			return list;
		} catch (Exception e) {
			session.close();
			return null;
		}
	*/
		Connection conn  = new ConnectionHelper().getConnection();
		List<message> list = new ArrayList<message>();
		PreparedStatement pst =null;
		ResultSet rs =null;
		String sql = "select * from message where see=? order by m_id desc limit 4";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 1);
			rs = pst.executeQuery();
			while(rs.next()){
				message mess = new message();
				mess.setM_id(rs.getInt("m_id"));
				mess.setTitle(rs.getString("title"));
				mess.setContext(rs.getString("context"));
				mess.setU_id(rs.getInt("u_id"));
				mess.setData_time(rs.getString("data_time"));
				mess.setSee(rs.getInt("see"));
				list.add(mess);
			}
			pst.close();
			rs.close();
			conn.close();
			return list;
		} catch (Exception e) {
			try {
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
		
		
	}
	
}
