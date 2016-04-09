package com.whoami.daodo;

import java.sql.*;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.whoami.po.leavelanguage;
import com.whoami.sessionHelper.ConnectionHelper;
import com.whoami.sessionHelper.SessionConnection;
import com.whomai.dao.leaveLanguageDao;

/**
 * 留言需要的具体实现方法
 * 
 * @author ZYong
 *
 */
public class LeaveLanguageDaoDo implements leaveLanguageDao {
	/**
	 * @author ZYong 添加留言
	 */
	public boolean addLeaveLanguage(leavelanguage lLanguage) {
	
		/**
		  Session session = new SessionConnection().getSession();
		 
		try {
			Transaction tx = session.beginTransaction();
			session.save(lLanguage);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("事务提交错误");
			session.close();
			return false;
		}
		*/
		/**
		 * 数据库mysql语句
		 * 
		 */
		
		Connection conn = new ConnectionHelper().getConnection();
		PreparedStatement pst =null;
		int rs ;
		//String sql = "INSERT INTO leavelanguage(`m_id`, `email`, `leavemessage`,`leavename`) VALUES ('" + lLanguage.getM_id() + "','" + lLanguage.getEmail() + "','" + lLanguage.getLeavemessage() + "','" + lLanguage.getLeavename() + "')"; 
		//String sql ="insert into leavelanguage values('','" + lLanguage.getM_id() + "','" + lLanguage.getEmail() + "','" + lLanguage.getLeavemessage() + "','" + lLanguage.getLeavetime() + "','" + lLanguage.getLeavename() + "')";
		//System.out.println(sql+"===============================================sql");
		String sql = "insert into leavelanguage (`m_id`, `email`, `leavemessage`,`leavetime`,`leavename`) values (?,?,?,?,?)";
		try {
			pst=conn.prepareStatement(sql);
			
			System.out.println(lLanguage.getId()+"-----------------------------id");
			pst.setInt(1,lLanguage.getM_id());
			System.out.println(lLanguage.getM_id()+"-----------------------------mid");
			pst.setString(2, lLanguage.getEmail());
			System.out.println(lLanguage.getEmail()+"----------------------------email-mid");
			pst.setString(3,lLanguage.getLeavemessage());
			pst.setString(4, lLanguage.getLeavetime());
			System.out.println(lLanguage.getLeavetime()+"---------------time");
			pst.setString(5,lLanguage.getLeavename());
			
			rs= pst.executeUpdate();
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

	/**
	 * 查找留言
	 */
	public List<leavelanguage> viewByLanguage(String hql, int offset, int pageSize) {
		Session session = new SessionConnection().getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
			tx.commit();
			@SuppressWarnings("unchecked")
			List<leavelanguage> list = query.list();
			session.close();
			return list;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			return null;
		}
	}

	/**
	 * 返回查询条数
	 */
	public int leaveAllCoubt(String hql) {
		Session session =new SessionConnection().getSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<leavelanguage> list = query.list();
		return list.size();
	}

	/**
	 * 删除留言
	 */
	public boolean deleteLanguage(int id) {
		Session session = new SessionConnection().getSession();
		Transaction tx = null;
		try {
			tx  =session.beginTransaction();
			String hql = "delete leavelanguage lge where lge.leaveLanguageID=? ";
			Query query = session.createQuery(hql);
			query.setInteger(0, id);
			
			int i = query.executeUpdate();
			tx.commit();
			if(i>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			System.out.println("事务创建连接失败");
			return false;
		}
		
	}

}
