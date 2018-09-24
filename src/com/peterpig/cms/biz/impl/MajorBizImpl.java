package com.peterpig.cms.biz.impl;

import java.util.List;

import com.peterpig.cms.bean.Department;
import com.peterpig.cms.bean.Major;
import com.peterpig.cms.biz.MajorBiz;
import com.peterpig.cms.dao.MajorDAO;
import com.peterpig.cms.dao.impl.MajorDAOImpl;

public class MajorBizImpl implements MajorBiz {
	private MajorDAO dao;
	public MajorBizImpl(){
		dao = new MajorDAOImpl();
	}
	@Override
	public boolean addMajor(Major major) {
		boolean flag = false;
		try{
			flag = dao.doCreat(major);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateMajor(Major major) {
		boolean flag = false;
		try{
			flag = dao.doUpdate(major);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean removeMajor(Integer majorId) {
		boolean flag = false;
		try{
			flag = dao.doRemove(majorId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Major> findAllMajor(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,
			Integer majorId) {
		List<Major> list = null;
		try{
			list = dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, majorId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Major findById(Integer majorId) {
		Major major = null;
		try{
			major = dao.findById(majorId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return major;
	}

	@Override
	public Long getAllCount(String keyWord, Integer majorId) {
		Long count = 0l;
		try{
			count = dao.getAllCount(keyWord, majorId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

}
