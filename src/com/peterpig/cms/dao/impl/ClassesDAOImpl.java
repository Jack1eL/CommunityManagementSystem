package com.peterpig.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.peterpig.cms.bean.Classes;
import com.peterpig.cms.dao.ClassesDAO;
import com.peterpig.cms.util.OpenTransactionUtils;

public class ClassesDAOImpl extends OpenTransactionUtils implements ClassesDAO {

	@Override
	public boolean doCreat(Classes bean) {
		boolean flag = false;
		super.openTransaction();
		try{
			session.save(bean);
			transaction.commit();
			flag = true;
		}catch(Exception e){
			e.getStackTrace();
			transaction.rollback();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Classes bean) {
		boolean flag = false;
		super.openTransaction();
		try{
			session.save(bean);
			transaction.commit();
			flag=true;
		}catch(Exception e){
			e.getStackTrace();
			transaction.rollback();
		}
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag = false;
		super.openTransaction();
		try{
			Classes classes = (Classes) session.get(Classes.class, id);
			session.delete(classes);
			transaction.commit();
		}catch(Exception e){
			e.getStackTrace();
			transaction.rollback();
		}
		
		
		return flag;
	}

	@Override
	public List<Classes> pageSelAll(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,
			Integer beanId) {
		List<Classes> list = null;
		super.openTransaction();
		try{
			list = new ArrayList<Classes>();  
			String hql = "from classes where classesNumber like ? and classesId like ? order by"+orderField+""+ orderType;
			Query query = session.createQuery(hql);
			query.setString(0,"#"+keyWord+"%");
			if(beanId==null){
				query.setString(1,"" );
			}else
				query.setInteger(1, beanId);
		
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
	public Classes findById(Integer id) {
		Classes classes = new Classes();
		super.openTransaction();
		try{
			classes = (Classes) session.get(Classes.class, id);
			transaction.commit();
		}catch(Exception e ){
			e.printStackTrace();
			transaction.rollback();
		}
		return classes;
	}

	@Override
	public Long getAllCount(String keyWord, Integer beanId) {
		Long count = 0l;
		super.openTransaction();
		try{
			String hql = "select count(classesId) where ClassesNumber like ? and Major.majorId like ?";
			Query query = session.createQuery(hql);
			query.setString(0, "#"+keyWord+"#");
			if(beanId==null){
				query.setString(1,"" );
			}else
				query.setInteger(1, beanId);
			count=(Long)query.uniqueResult();
			transaction.commit();
		}catch(Exception e ){
			e.printStackTrace();
			transaction.rollback();
		}
		return count;
	}

	@Override
	public Classes findByBean(Classes bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
