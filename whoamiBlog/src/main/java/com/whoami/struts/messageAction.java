package com.whoami.struts;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ModelDriven;
import com.whoami.SpringHelper.messageSpringDoHelper;
import com.whoami.po.PageBean;
import com.whoami.po.message;

public class messageAction extends supperAction implements ModelDriven<message> {

	private static final long serialVersionUID = 1L;
	message mess = new message();
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "messageDo.xml" });
	messageSpringDoHelper springDo = (messageSpringDoHelper) context.getBean("messageDoHelp");

	public String addMessage() {
		String time =new java.text.SimpleDateFormat("YYYY/MM/dd HH:mm:ss").format(new Date()).toString();
		mess.setData_time(time);
		String context =request.getParameter("context");
		mess.setContext(context);
		System.out.println(mess.getContext()+"----------context----------");
		springDo.setMess(mess);
		if (springDo.addMessage()) {
			return "addMessageSuccess";
		}
		return null;

	}

	public String deleteMessage() {
		int id = Integer.parseInt(request.getParameter("key"));
		if (springDo.delete(id)) {
			return "deleteSuccess";
		}
		return "deleteFalse";
	}
	public String viewById(){
		String id = request.getParameter("id");
		String hql = "select * from message where m_id = "+id+"";
		PageBean pageBean = springDo.view(hql, 5, page);
		//HttpServletRequest request =ServletActionContext.getRequest();
		request.setAttribute("listById", pageBean);
		return "viewById";
	}
	public String viewByLeaveTime() {
		String hql = "select * from message where data_time like '%" + mess.getData_time() + "%' ";
		PageBean pageBean = springDo.view(hql, 5, page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listByAll", pageBean);
		return "viewByNameOrTimeSuccess";
	}
public String viewAll(){
	String hql = "select * from message where see=1";
	PageBean pageBean = springDo.view(hql, 6, page);
	request.setAttribute("listByAll", pageBean);
	return "viewByAll";
}
	public message getModel() {

		return mess;
	}
}
