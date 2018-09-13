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
	public List<SignIn> pageSelAll(String keyWord, Integer curPage, Integer pageSize, String orderType, String orderField, Integer beanId) {
		List<SignIn> signinList=null;
		super.openTransaction();
		try {
			//查询签到记录：1、活动名模糊查询 2、通过某一字段进行排序 3、分页
			String hql="from SignIn where title like ? and activity.activityId like ? order by "+orderField+" "+orderType;
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			if(beanId==null){
				query.setString(1, "%%");
			}else{
				query.setInteger(1, beanId);
			}
			query.setFirstResult((curPage-1)*pageSize);
			query.setMaxResults(pageSize);
			
			//执行查询并且保存到列表
			signinList=query.list();
//			for(SignIn s:signinList){
//				System.out.println(s.getTitle()+"\n"+s.getSigninTime());
//			}
			
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return signinList;
	}

	@Override
	public SignIn findById(Integer id) {
		SignIn signin=null;
		super.openTransaction();
		try {
			//通过编号查询签到记录
			String hql="from SignIn where signinId=?";
			Query query=session.createQuery(hql);
			query.setInteger(0, id);
			
			//执行查询并保存到签到对象
			signin=(SignIn) query.uniqueResult();
			
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		//System.out.println(signin.getTitle());
		return signin;
	}

	@Override
	public Long getAllCount(String keyWord, Integer beanId) {
		Long count=0L;
		super.openTransaction();
		try {
			//通过关键字查询所有记录条数
			String hql="select count(signinId) from SignIn where title like ? and activity.activityId like ?";
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			if(beanId==null){
				query.setString(1, "");
			}else{
				query.setInteger(1, beanId);
			}
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
	public SignIn findByBean(SignIn bean) {
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
		//getAllCount("");
	}



}
