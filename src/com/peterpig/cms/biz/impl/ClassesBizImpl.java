package com.peterpig.cms.biz.impl;

import java.util.List;

import com.peterpig.cms.bean.Classes;
import com.peterpig.cms.bean.StudentInfo;
import com.peterpig.cms.biz.ClassesBiz;
import com.peterpig.cms.dao.ClassesDAO;
import com.peterpig.cms.dao.impl.ClassesDAOImpl;

public class ClassesBizImpl implements ClassesBiz {
	private ClassesDAO  dao;
	public ClassesBizImpl(){
		dao = new ClassesDAOImpl();
	}
	@Override
	public boolean addClasses(Classes classes) {
		boolean flag = false;
		try{
			flag = dao.doCreat(classes);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateClasses(Classes classes) {
		boolean flag = false;
		try{
			flag = dao.doUpdate(classes);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean removeClasses(Integer classesId) {
		boolean flag = false;
		try{
			flag = dao.doRemove(classesId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Classes> findAllClasses(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,
			Integer classesId) {
		List<Classes> list = null;
		try{
			list = dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, classesId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Classes findById(Integer classesId) {
		Classes classes = null;
		try{
			classes = dao.findById(classesId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return classes;
	}

	@Override
	public Long getAllCount(String keyWord, Integer classesId) {
		Long count = 0l;
		try{
			count = dao.getAllCount(keyWord, classesId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

}
