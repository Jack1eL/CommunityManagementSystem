package com.peterpig.cms.biz.impl;

import java.util.List;

import com.peterpig.cms.bean.Admin;
import com.peterpig.cms.biz.AdminBiz;
import com.peterpig.cms.dao.AdminDAO;
import com.peterpig.cms.dao.impl.AdminDAOImpl;

public class AdminBizImpl implements AdminBiz {
	private AdminDAO dao;
	public AdminBizImpl(){
		dao = new AdminDAOImpl();
	}
	@Override
	public boolean addAdmin(Admin admin) {
		boolean flag = false;
		try{
			flag = dao.doCreat(admin);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		boolean flag = false;
		try{
			flag = dao.doUpdate(admin);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean removeAdmin(Integer adminId) {
		boolean flag = false;
		try{
			flag = dao.doRemove(adminId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Admin> findAllAdmin(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,
			Integer adminId) {
		List<Admin> list = null;
		try{
			list = dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, adminId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Admin findById(Integer adminId) {
		Admin admin = null;
		try{
			admin = dao.findById(adminId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public Long getAllCount(String keyWord, Integer adminId) {
		Long count = 0l;
		try{
			count = dao.getAllCount(keyWord, adminId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	public Admin login(Admin bean){
		Admin admin= null;
		try{
			admin = dao.findAllInfo(bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return admin;
	}

}
