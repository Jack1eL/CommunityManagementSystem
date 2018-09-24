package com.peterpig.cms.biz.impl;

import java.util.List;

import com.peterpig.cms.bean.Major;
import com.peterpig.cms.bean.Student;
import com.peterpig.cms.biz.StudentBiz;
import com.peterpig.cms.dao.StudentDAO;
import com.peterpig.cms.dao.impl.StudentDAOImpl;

public class StudentBizImpl implements StudentBiz {
	private StudentDAO dao;
	public StudentBizImpl(){
		dao = new StudentDAOImpl();
	}
	@Override
	public boolean addStudent(Student student) {
		boolean flag = false;
		try{
			flag = dao.doCreat(student);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateStudent(Student student) {
		boolean flag = false;
		try{
			flag = dao.doUpdate(student);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean removeStudent(Integer studentId) {
		boolean flag = false;
		try{
			flag = dao.doRemove(studentId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Student> findAllStudent(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,
			Integer studentId) {
		List<Student> list = null;
		try{
			list = dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, studentId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Student findById(Integer studentId) {
		Student student = null;
		try{
			student = dao.findById(studentId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public Long getAllCount(String keyWord, Integer studentId) {
		Long count = 0l;
		try{
			count = dao.getAllCount(keyWord, studentId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

}
