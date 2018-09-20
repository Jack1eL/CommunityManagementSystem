package com.peterpig.cms.dao.impl;

import java.util.List;

import com.peterpig.cms.bean.Student;
import com.peterpig.cms.bean.StudentInfo;
import com.peterpig.cms.dao.StudentInfoDAO;
import com.peterpig.cms.util.OpenTransactionUtils;

public class StudentInfoDAOImpl extends OpenTransactionUtils implements
		StudentInfoDAO {

	@Override
	public boolean doCreat(StudentInfo bean) {
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
	public boolean doUpdate(StudentInfo bean) {
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
			StudentInfo studentInfo = (StudentInfo) session.get(StudentInfo.class, id);
			session.delete(studentInfo);
			transaction.commit();
			flag = true;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<StudentInfo> pageSelAll(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,
			Integer beanId) {
		List<StudentInfo> list = null;
		super.openTransaction();
		try{
			String hql = "";
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return null;
	}

	@Override
	public StudentInfo findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(String keyWord, Integer beanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentInfo findByBean(StudentInfo bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
