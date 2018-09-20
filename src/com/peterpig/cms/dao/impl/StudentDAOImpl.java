package com.peterpig.cms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.junit.Test;

import com.peterpig.cms.bean.Student;
import com.peterpig.cms.dao.StudentDAO;
import com.peterpig.cms.util.OpenTransactionUtils;

public class StudentDAOImpl extends OpenTransactionUtils implements StudentDAO {

	@Override
	public boolean doCreat(Student bean) {
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
	public boolean doUpdate(Student bean) {
		boolean flag = false;
		super.openTransaction();
		try {
			
			session.save(bean);
			transaction.commit();
			flag=true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag = false;
		super.openTransaction();
		try{
			Student student = (Student) session.get(Student.class, id);
			session.delete(student);
			transaction.commit();
			flag = true;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Student> pageSelAll(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,
			Integer beanId) {
		List<Student> list = null;
		super.openTransaction();
		try{
			String hql = "from Student where username like ? and classes.classesId like ? order by "+orderField+" "+orderType;
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			if(beanId==null){
				query.setString(1, "");
			}else{
				query.setInteger(1, beanId);
			}
			query.setFirstResult((curPage-1)*pageSize);
			query.setMaxResults(pageSize);
			
			//执行查询并且保存到列表
			list=query.list();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return list;
	}

	@Override
	public Student findById(Integer id) {
		Student student = null;
		super.openTransaction();
		try{
			student = (Student) session.get(Student.class, id);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return student;
	}

	@Override
	public Long getAllCount(String keyWord, Integer beanId) {
		Long count = 0L;
		super.openTransaction();
		try{
			String hql = "select count(studentId) from student where username like ? and classes.classesId like ? ";
			Query query =  session.createQuery(hql);
			query.setString(0,"#"+keyWord+"#" );
			if(beanId==null){
				query.setString(1, "");
			}else{
				query.setInteger(1, beanId);
			}
			count=(Long)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		
		return count;
	}

	@Override
	public Student findByBean(Student bean) {
		// TODO Auto-generated method stub
		return null;
	}
	@Test
	public void tt(){
		findById(1);
	}

}
