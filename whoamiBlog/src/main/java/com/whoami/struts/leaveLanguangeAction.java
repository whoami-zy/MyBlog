package com.whoami.struts;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ModelDriven;
import com.whoami.SpringHelper.leaveLanguageSpringDoHelp;
import com.whoami.po.PageBean;
import com.whoami.po.leavelanguage;
/**
 * 
 * @author ZYong
 *Struts的Action,实现jsp与后台的交互
 */
public class leaveLanguangeAction extends supperAction  implements ModelDriven<leavelanguage>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	leavelanguage lLanguage = new leavelanguage();
	/**
	 * 实现spring的xml导入。实现spring的控制注入（相当于new）
	 */
	ApplicationContext context = new ClassPathXmlApplicationContext(new  String []{"leaveLanguageDo.xml"});
	leaveLanguageSpringDoHelp lLanguageSpringDo = (leaveLanguageSpringDoHelp) context.getBean("leaveLanguageDoHelp");
	/**
	 *需要的参数，定义
	 */
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	//实现添加方法
	public String addLeaveLanguage(){
		String time =new java.text.SimpleDateFormat("YYYY/MM/dd HH:mm:ss").format(new Date()).toString();
		lLanguage.setLeavetime(time);
		lLanguageSpringDo.setlLanguage(lLanguage);
		if(lLanguageSpringDo.add()){
			return "addSuccess";
		}
		return "addFalse";
	}
	//实现删除方法
	public String deleteLeaveLanguage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id =Integer.parseInt(request.getParameter("key"));
		if(lLanguageSpringDo.delete(id)){
			return "deleteSuccess";
		}
		return "deleteFalse";
	}
	//按姓名或者时间进行查找
	/**
	 
	 
	public String viewByNameOrLeaveTime(){
		String hql = "from leavelanguage lag where lag.u_id like '%"+lLanguage.getLeaveLanguageContext()+"%' or lag.LeaveTime like '%"+lLanguage.getLeaveLanguageContext()+"%' ";
		PageBean pageBean = lLanguageSpringDo.view(hql, 5, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listByAll", pageBean);
		HttpSession session = request.getSession();
		session.setAttribute("method", "viewByNameOrLeaveTime");
		return "viewByNameOrTimeSuccess";
	}
	*/
	//查看全部
	public String viewByAll(){
		String hql = "from leavelanguage";
		PageBean pageBean = lLanguageSpringDo.view(hql, 5, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listByAll", pageBean);
		HttpSession session = request.getSession();
		session.setAttribute("method", "viewByAll");
		return "viewByAllSuccess";
	}
	/**
	 * 接收前台传来的leavelanguage值
	 */
	public leavelanguage getModel() {
		// TODO Auto-generated method stub
		return lLanguage;
	}

}
