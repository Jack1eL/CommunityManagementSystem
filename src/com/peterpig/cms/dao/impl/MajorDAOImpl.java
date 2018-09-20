package com.peterpig.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.peterpig.cms.bean.Major;
import com.peterpig.cms.dao.MajorDAO;
import com.peterpig.cms.util.OpenTransactionUtils;

public class MajorDAOImpl extends OpenTransactionUtils implements MajorDAO {

	@Override
	public boolean doCreat(Major bean) {
		boolean flag = false;
		super.openTransaction();
		try{
			session.save(bean);
			transaction.commit();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Major bean) {
		boolean flag = false;
		super.openTransaction();
		try{
			session.save(bean);
			transaction.commit();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag = false;
		super.openTransaction();
		try{
			Major major = (Major) session.get(Major.class, id);
			session.delete(major);
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return flag;
	}

	@Override
	public List<Major> pageSelAll(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,
			Integer beanId) {
		List<Major> list = new ArrayList();
		super.openTransaction();
		try{
			String hql = "from major where majorName like ? and majorId like ? order by"+orderField+""+ orderType;
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			if(beanId==null){
				query.setString(1, "");
			}else{
				query.setInteger(1, beanId);
			}
			query.setFirstResult((curPage-1)*pageSize);
			query.setMaxResults(pageSize);
			list=query.list(); //将查询出的内容保存到列表中
			transaction.commit();
		}catch(Exception e){
			e.getStackTrace();
			transaction.rollback();
		}

		return list;
	}

	@Override
	public Major findById(Integer id) {
		Major major = new Major();
		super.openTransaction();
		try{
			major = (Major) session.get(Major.class, id);
			transaction.commit();
		}catch(Exception e){
			e.getStackTrace();
			transaction.rollback();
		}
		return major;
	}

	@Override
	public Long getAllCount(String keyWord, Integer beanId) {
		Long count = 0l;
		super.openTransaction();
		try{
			String hql = "select count(majorId) where majorName like ? and department.departmentId like ?";
			Query query = session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			if(beanId==null){
				query.setString(1,"" );
			}else
				query.setInteger(1, beanId);
			count=(Long)query.uniqueResult();
			transaction.commit();
		}catch(Exception e){
			e.getStackTrace();
			transaction.rollback();
		}
		return count;
	}

	@Override
	public Major findByBean(Major bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
