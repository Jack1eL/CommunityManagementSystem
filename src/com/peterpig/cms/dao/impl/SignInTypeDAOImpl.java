package com.peterpig.cms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.junit.Test;

import com.peterpig.cms.bean.SignIn;
import com.peterpig.cms.bean.SignInType;
import com.peterpig.cms.dao.SignInTypeDAO;
import com.peterpig.cms.util.OpenTransactionUtils;
/**
 * 签到类型
 * @author Evan
 *
 */
public class SignInTypeDAOImpl extends OpenTransactionUtils implements
		SignInTypeDAO {

	@Override
	public boolean doCreat(SignInType bean) {
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
	public boolean doUpdate(SignInType bean) {
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
			SignInType signinType=(SignInType) session.get(SignInType.class, id);
			session.delete(signinType);
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
	public List<SignInType> pageSelAll(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,
			Integer beanId) {
		List<SignInType> signinTypeList=null;
		super.openTransaction();
		try {
			//查询签到类型记录：1、分页
			String hql="from SignInType where typeName like ?";
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			query.setFirstResult((curPage-1)*pageSize);
			query.setMaxResults(pageSize);
			
			//执行查询并且保存到列表
			signinTypeList=query.list();
//			for(SignInType s:signinTypeList){
//				System.out.println(s.getTypeName());
//			}
			
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return signinTypeList;
	}

	@Override
	public SignInType findById(Integer id) {
		SignInType signinType=null;
		super.openTransaction();
		try {
			//通过编号查询签到类型
			String hql="from SignInType where typeId=?";
			Query query=session.createQuery(hql);
			query.setInteger(0, id);
			
			//执行查询
			signinType=(SignInType) query.uniqueResult();
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}

		//System.out.println(signinType.getTypeName());
		return signinType;
	}


	@Override
	public Long getAllCount(String keyWord, Integer beanId) {
		Long count=0L;
		super.openTransaction();
		try {
			//通过关键字查询所有记录条数
			String hql="select count(typeId) from SignInType where typeName like ?";
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			
			//执行查询
			count=(Long)query.uniqueResult();
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		//System.out.println(count);
		return count;
	}

	@Override
	public SignInType findByBean(SignInType bean) {
		//该对象不需要此方法
		return null;
	}

	
	/**
	 * 测试
	 */
	@Test
	public void t(){
		
		//pageSelAll("",1,2,"asc","signinTime");
		//findById(1);
		//getAllCount("签到");
	}



}
