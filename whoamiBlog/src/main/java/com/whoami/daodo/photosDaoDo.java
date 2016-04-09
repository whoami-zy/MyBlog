package com.whoami.daodo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.whoami.po.photos;
import com.whoami.sessionHelper.ConnectionHelper;
import com.whoami.sessionHelper.SessionConnection;
import com.whomai.dao.photosDao;

public class photosDaoDo implements photosDao{

	public boolean addImage(photos photo) {
		/**
		Session session = new SessionConnection().getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(photo);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			session.close();
			return false;
		}
		*/
		Connection conn = new ConnectionHelper().getConnection();
		PreparedStatement pst =null;
		String sql = "INSERT INTO photos (`u_id`, `p_path`, `p_name`, `p_about`,`p_time`) VALUES (?,?,?,?,?);";
		int rs;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, photo.getU_id());
			pst.setString(2, photo.getP_path());
			pst.setString(3, photo.getP_name());
			pst.setString(4,photo.getP_about());
			pst.setString(5, photo.getP_time());
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

	public boolean deleteImage(int id) {
		Session session =new SessionConnection().getSession();
		Transaction tx = null;
		try{
			tx =session.beginTransaction();
			String hql = "delete photos photo where photo.id=?";
			Query query = session.createQuery(hql);
			query.setInteger(0, id);
			tx.commit();
			int i = query.executeUpdate();
			session.close();
			if(i>0){
				return true;
			}
			return false;
		}catch(Exception e){
			session.close();
			return false;
		}
	
	}

	public List<photos> viewImage() {
		/**
		Session session = new SessionConnection().getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql="from photos";
			Query query = session.createQuery(hql);
			tx.commit();
			@SuppressWarnings("unchecked")
			List<photos> list = query.list();
			session.close();
			return list;
		} catch (Exception e) {
			session.close();
			return null;
		}
		*/
		Connection conn = new ConnectionHelper().getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from photos";
		System.out.println(sql+"-------------------------------sql");
		List<photos> list = new ArrayList<photos>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				photos photo = new photos();
				photo.setId(rs.getInt("id"));
				photo.setU_id(rs.getInt("u_id"));
				photo.setP_path(rs.getString("p_path"));
				photo.setP_name(rs.getString("p_name"));
				System.out.println(rs.getString("p_path"));
				photo.setP_about(rs.getString("p_about"));
				photo.setP_time(rs.getString("p_time"));
				list.add(photo);
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
