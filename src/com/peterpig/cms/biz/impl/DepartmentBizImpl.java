package com.peterpig.cms.biz.impl;

import java.util.List;

import com.peterpig.cms.bean.Admin;
import com.peterpig.cms.bean.Department;
import com.peterpig.cms.biz.DepartmentBiz;
import com.peterpig.cms.dao.DepartmentDAO;
import com.peterpig.cms.dao.impl.DepartmentDAOImpl;

public class DepartmentBizImpl implements DepartmentBiz {
	private DepartmentDAO dao;
	public DepartmentBizImpl(){
		dao = new DepartmentDAOImpl();
	}

	@Override
	public boolean addDepartment(Department department) {
		boolean flag = false;
		try{
			flag = dao.doCreat(department);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateDepartment(Department department) {
		boolean flag = false;
		try{
			flag = dao.doUpdate(department);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean removeDepartment(Integer departmentId) {
		boolean flag = false;
		try{
			flag = dao.doRemove(departmentId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Department> findAllDepartment(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,
			Integer departmentId) {
		List<Department> list = null;
		try{
			list = dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, departmentId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Department findById(Integer departmentId) {
		Department department = null;
		try{
			department = dao.findById(departmentId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return department;
	}

	@Override
	public Long getAllCount(String keyWord, Integer departmentId) {
		Long count = 0l;
		try{
			count = dao.getAllCount(keyWord, departmentId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

}
