package com.whoami.po;

/**
 * 
 * @author ZYong
 *为了方便，将留言表和评论表放在同一个表中
 *为了区分，留言表不存在m_id，评论表存在。
 *
 */
public class leavelanguage {
		private int id;
		private int m_id;
		private String email;
		private String leavemessage;
		private String leavetime;
		private String leavename;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getM_id() {
			return m_id;
		}
		public void setM_id(int m_id) {
			this.m_id = m_id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getLeavemessage() {
			return leavemessage;
		}
		public void setLeavemessage(String leavemessage) {
			this.leavemessage = leavemessage;
		}
		public String getLeavetime() {
			return leavetime;
		}
		public void setLeavetime(String leavetime) {
			this.leavetime = leavetime;
		}
		public String getLeavename() {
			return leavename;
		}
		public void setLeavename(String leavename) {
			this.leavename = leavename;
		}
		
}
