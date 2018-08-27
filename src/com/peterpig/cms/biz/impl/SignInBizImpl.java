package com.peterpig.cms.biz.impl;

import java.util.List;

import com.peterpig.cms.bean.SignIn;
import com.peterpig.cms.biz.SignInBiz;
import com.peterpig.cms.dao.SignInDAO;
import com.peterpig.cms.dao.impl.SignInDAOImpl;

public class SignInBizImpl implements SignInBiz {
	private SignInDAO dao;
	
	public SignInBizImpl(){
		dao=new SignInDAOImpl();
	}
	
	@Override
	public boolean addSignIn(SignIn signin) {
		boolean flag=false;
		try {
			flag=this.dao.doCreat(signin);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateSignIn(SignIn signin) {
		boolean flag=false;
		try {
			flag=this.dao.doUpdate(signin);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteSignIn(Integer id) {
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
	public List<SignIn> findAllSignIn(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField) {
		List<SignIn> signinList=null;
		try {
			signinList=this.dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, null);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return signinList;
	}

	@Override
	public List<SignIn> findAllSignInByActivityId(String keyWord,
			Integer curPage, Integer pageSize, String orderType,
			String orderField, Integer activityId) {
		List<SignIn> signinList=null;
		try {
			signinList=this.dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, activityId);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return signinList;
	}

	@Override
	public SignIn findById(Integer signinId) {
		SignIn signin=null;
		try {
			signin=this.dao.findById(signinId);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return signin;
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

	@Override
	public Long getAllCount(String keyWord, Integer activityId) {
		Long count=0L;
		try {
			count=this.dao.getAllCount(keyWord, activityId);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return count;
	}

}
