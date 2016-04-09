package com.whoami.SpringHelper;

import java.util.List;

import com.whoami.po.PageBean;
import com.whoami.po.leavelanguage;
import com.whomai.dao.leaveLanguageDao;

public class leaveLanguageSpringDoHelp {
	leavelanguage lLanguage;
	leaveLanguageDao leaveSpringDo;

	public leavelanguage getlLanguage() {
		return lLanguage;
	}

	public void setlLanguage(leavelanguage lLanguage) {
		this.lLanguage = lLanguage;
	}

	public leaveLanguageDao getLeaveSpringDo() {
		return leaveSpringDo;
	}

	public void setLeaveSpringDo(leaveLanguageDao leaveSpringDo) {
		this.leaveSpringDo = leaveSpringDo;
	}

	public boolean add() {
		return leaveSpringDo.addLeaveLanguage(lLanguage);
	}

	public boolean delete(int key) {
		return leaveSpringDo.deleteLanguage(key);
	}

	/**
	 * 
	 * @param hql 需要的数据库语言
	 * @param pageSize 每页显示几条
	 * @param page 多少页
	 * @return
	 */
	public PageBean view(String hql, int pageSize, int page) {
		/**
		 * 1.实例化返回类型
		 * 2.自定义interest int 类型， 得到总条数，count
		 * 3.自定义interest int 类型， 得到总页数
		 * 4.自定义interest int 类型， 得到当前页
		 * 5.自定义interest int 类型， 当前页数显示的条数的查询的起始值
		 * 6.得到返回的数据list
		 * 7.将相应的数据添加到实例中
		 * 8.返回实例对象
		 */
		PageBean pageBean =new PageBean();
		int allRows=leaveSpringDo.leaveAllCoubt(hql);
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		int currentPage = pageBean.getCurPage(page);
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<leavelanguage> list = leaveSpringDo.viewByLanguage(hql, offset, pageSize);
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}
}
