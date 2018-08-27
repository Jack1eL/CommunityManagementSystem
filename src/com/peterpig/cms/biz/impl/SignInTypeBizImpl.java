package com.peterpig.cms.biz.impl;

import java.util.List;

import com.peterpig.cms.bean.SignInType;
import com.peterpig.cms.biz.SignInTypeBiz;
import com.peterpig.cms.dao.SignInTypeDAO;
import com.peterpig.cms.dao.impl.SignInTypeDAOImpl;

public class SignInTypeBizImpl implements SignInTypeBiz {
	private SignInTypeDAO dao;
	
	public SignInTypeBizImpl(){
		dao=new SignInTypeDAOImpl();
	}
	
	@Override
	public boolean addSignInType(SignInType type) {
		boolean flag=false;
		try {
			flag=this.dao.doCreat(type);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateSignInType(SignInType type) {
		boolean flag=false;
		try {
			flag=this.dao.doUpdate(type);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteSignInType(Integer id) {
		boolean flag=false;
		try {
			flag=this.dao.doRemove(id);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<SignInType> findAllSignInType(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField) {
		List<SignInType> signinTypeList=null;
		try {
			signinTypeList=this.dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, null);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		
		return signinTypeList;
	}

	@Override
	public SignInType findById(Integer signinTypeId) {
		SignInType type=null;
		try {
			type=this.dao.findById(signinTypeId);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public Long getAllCount(String keyWord) {
		Long count=0L;
		try {
			count=this.dao.getAllCount(keyWord, null);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return count;
	}

}
