package com.peterpig.cms.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.peterpig.cms.bean.Admin;
import com.peterpig.cms.bean.Department;
import com.peterpig.cms.dao.DepartmentDAO;
import com.peterpig.cms.util.OpenTransactionUtils;

public class DepartmentDAOImpl extends OpenTransactionUtils implements DepartmentDAO {

	@Override
	public boolean doCreat(Department bean) {
		boolean flag = false;
		super.openTransaction();
		try{
			Department department = new Department();
			department.setDepartmentName(bean.getDepartmentName());
			session.save(department);
			transaction.commit();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Department bean) {
		boolean flag = false;
		super.openTransaction();
		try{
			Department department = (Department)session.get(Department.class, bean.getDepartmentId());
			department.setDepartmentName(bean.getDepartmentName());
			session.save(department);
			transaction.commit();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag = false;
		super.openTransaction();
		try{
			Department department = (Department)session.get(Department.class, id);
			session.delete(department);
			transaction.commit();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return flag;
	}

	@Override
	public List<Department> pageSelAll(String keyWord, Integer curPage,Integer pageSize, String orderType, String orderField) {
		List<Department> list = null;
		super.openTransaction();
		try{
			String hql="from Department";
			Query query=session.createQuery(hql);
			query.setFirstResult((curPage-1)*pageSize);
			query.setMaxResults(pageSize);
			list=query.list(); //将查询出的内容保存到列表中
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Department findById(Integer id) {
		Department department = null;
		super.openTransaction();
		try{
			department = (Department) session.get(Admin.class, id);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return department;
	}

	@Override
	public Long getAllCount(String keyWord) {
		Long count=0l;
		super.openTransaction();
		try{
			String hql="select count(id) from Department";
			Query query=session.createQuery(hql);
			count=(Long)query.uniqueResult();
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Department findByBean(Department bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
