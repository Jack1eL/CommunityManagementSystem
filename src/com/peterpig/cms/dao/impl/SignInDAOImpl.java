package com.peterpig.cms.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;


import com.peterpig.cms.bean.AssociationActivity;
import com.peterpig.cms.bean.SignIn;
import com.peterpig.cms.bean.SignInType;
import com.peterpig.cms.bean.Student;
import com.peterpig.cms.dao.SignInDAO;
import com.peterpig.cms.util.OpenTransactionUtils;

public class SignInDAOImpl extends OpenTransactionUtils implements SignInDAO {

	@Override
	public boolean doCreat(SignIn bean) {
		boolean flag=false;
		super.openTransaction();
		try {
			
			session.save(bean);
			transaction.commit();
			flag=true;
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(SignIn bean) {
		boolean flag=false;
		super.openTransaction();
		try {
			
			session.save(bean);
			transaction.commit();
			flag=true;
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag=false;
		super.openTransaction();
		try {
			SignIn signin=(SignIn) session.get(SignIn.class, id);
			session.delete(signin);
			transaction.commit();
			flag=true;
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<SignIn> pageSelAll(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField) {
		List<SignIn> signinList=null;
		super.openTransaction();
		try {
			//查询签到记录：1、活动名模糊查询 2、通过某一字段进行排序 3、分页
			String hql="from SignIn where title like ? order by "+orderField+" "+orderType;
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			query.setFirstResult((curPage-1)*pageSize);
			query.setMaxResults(pageSize);
			
			//执行查询并且保存到列表
			signinList=query.list();
			for(SignIn s:signinList){
				System.out.println(s.getTitle()+"\n"+s.getSigninTime());
			}
			
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return signinList;
	}

	@Override
	public SignIn findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SignIn findByBean(SignIn bean) {
		
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 测试
	 */
	@Test
	public void t(){
		
		//pageSelAll("",1,2,"asc","signinTime");
		//findById(1);
		//getAllCount("");
		//AssociationActivity aa=new AssociationActivity();
		//aa.setActivityName("篮球社常规训练");
		//findByBean(aa);
	}
}
