package com.whoami.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.opensymphony.xwork2.ModelDriven;
import com.whoami.SpringHelper.userSpringDoHelp;
import com.whoami.po.user;

public class userAction extends supperAction implements  ModelDriven<user> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	user user = new user();
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "userDo.xml" });
	userSpringDoHelp springDo = (userSpringDoHelp) context.getBean("userDoHelp");
	/**
	public String userRegister() {
		HttpServletRequest request = ServletActionContext.getRequest();
		 String name=request.getParameter("u_name");
		 HttpSession session = request.getSession(true);
		 session.setAttribute("SessionName", name);
		springDo.setU(user);
		String result=springDo.resgin();
		
		if("success".equals(result)){
			return "userRegisterSuccess";
		}else{
			return "userRegisterFalse";

		}
	}
	
	public String userRegister2() {

		springDo.setU(user);
		String result=springDo.resgin();
		
		if("success".equals(result)){
			return "userRegisterSuccess2";
		}else{
			return "userRegisterFalse2";

		}
	}
	**/
	public String userLogin() {
		springDo.setU(user);
		boolean result = springDo.userLogin();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session =request.getSession(true);
		if (result) {
			session.setAttribute("SessionName", user.getU_name());
			return "userLoginSuccess";
		} else {
			return "userLoginFalse";

		}
	}
	/**
	public String updateUser(){
	springDo.setU(user);
	boolean result=springDo.userUpdata();
	if(result){
		return "userUpdataSuccess";
	}else{
		return "userUpdataFalse";
	}
		
	}
	**/
	public String loginOut(){
		if(session.getAttribute("SessionName")!=null){
			session.removeAttribute("SessionName");
			return "loginOutSuccess";
		}
		else{
			this.addFieldError("name", "请先登录，再注销");
			return "loginOutFalse";
			
		}
	}
	public user getModel() {

		return user;
	}

}
