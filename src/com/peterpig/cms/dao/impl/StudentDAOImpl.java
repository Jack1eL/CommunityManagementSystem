package com.peterpig.cms.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import com.peterpig.cms.bean.Association;
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
			String hql = "from Student where username like ? order by "+orderField+" "+orderType;
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
//			if(beanId==null){
//				query.setString(1, "%%");
//			}else{
//				query.setInteger(1, beanId);
//			}
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
			String hql = "select count(studentId) from Student where username like ?";
			Query query =  session.createQuery(hql);
			query.setString(0,"%"+keyWord+"%" );
//			if(beanId==null){
//				query.setString(1, "%%");
//			}else{
//				query.setInteger(1, beanId);
//			}
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
		//findById(1);
		//pageSelAll("",1,2,"asc","username",3);
		//getAllCount("",2);
		Student student = new Student();
		student.setUsername("aaa");
		student.setPassword("123");
		System.out.println(findAllInfo(student));
	}

	@Override
	public Student findAllInfo(Student bean) {
		Student student = null;
		super.openTransaction();
		try{
			String hql="from Student where username=? and password=?";
			Query query=session.createQuery(hql);
			query.setString(0, bean.getUsername());
			query.setString(1, bean.getPassword());
			student=(Student)query.uniqueResult();
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Student> findStudentByGroupId(Integer associationId) {
		List<Student> studentList=null;
		super.openTransaction();
		try{
			String hql="select new Student(s.studentId as studentId,ag.groupId as groupId,si.name as name) from Student s,AssociationGroup ag,StudentInfo si"
						+" where s.group.groupId=ag.groupId and s.studentId=si.studentId and s.association.associationId=?"
						+" group by s.studentId";
			Query query=session.createQuery(hql);
			query.setInteger(0, associationId);
			studentList=query.list();
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}
		return studentList;
	
	}

	@Override
	public Student joinAssociation(Integer aid,Integer sid) {
		Student ss=null;
		super.openTransaction();
		try {
			Student s=(Student) session.get(Student.class, sid);
			Association a=(Association) session.get(Association.class, aid);
			s.setAssociation(a);
			session.save(s);
			session.save(a);
			
			transaction.commit();
			ss=s;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return ss;
	}

}
