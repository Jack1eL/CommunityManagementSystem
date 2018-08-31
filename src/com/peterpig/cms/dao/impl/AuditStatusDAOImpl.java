package com.peterpig.cms.dao.impl;

import java.util.List;

import com.peterpig.cms.bean.AuditStatus;
import com.peterpig.cms.dao.AuditStatusDAO;
import com.peterpig.cms.util.OpenTransactionUtils;

public class AuditStatusDAOImpl extends OpenTransactionUtils implements
		AuditStatusDAO {

	@Override
	public boolean doCreat(AuditStatus bean) {
		boolean flag=false;
		super.openTransaction();  //开启事务
		try{
			AuditStatus as=new AuditStatus();
			as.setStatusName(bean.getStatusName());   //增加
			session.save(as);
			transaction.commit();  //提交
			flag=true;
		}catch(Exception e){
			System.out.println("----------------daoImpl出现问题！----------------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(AuditStatus bean) {
		boolean flag=false;
		super.openTransaction();
		try{
			AuditStatus as=(AuditStatus)session.get(AuditStatus.class, bean.getStatusId());
			as.setStatusName(as.getStatusName());   //修改状态的名字
			session.save(as);
			transaction.commit();
			flag=true;
		}catch(Exception e){
			System.out.println("----------------daoImpl出现问题！----------------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag=false;
		super.openTransaction();
		try{
			AuditStatus as=(AuditStatus) session.get(AuditStatus.class, id);
			session.delete(as);
			transaction.commit();
			flag=true;
		}catch(Exception e){
			System.out.println("----------------daoImpl出现问题！----------------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<AuditStatus> pageSelAll(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,
			Integer beanId) {
		String hql="from AuditStatus ";
		return null;
	}

	@Override
	public AuditStatus findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(String keyWord, Integer beanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuditStatus findByBean(AuditStatus bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
