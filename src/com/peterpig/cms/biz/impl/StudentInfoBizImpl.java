package com.peterpig.cms.biz.impl;

import java.util.List;

import com.peterpig.cms.bean.Student;
import com.peterpig.cms.bean.StudentInfo;
import com.peterpig.cms.biz.StudentInfoBiz;
import com.peterpig.cms.dao.StudentInfoDAO;
import com.peterpig.cms.dao.impl.StudentInfoDAOImpl;

public class StudentInfoBizImpl implements StudentInfoBiz {
	private StudentInfoDAO dao ;
	public StudentInfoBizImpl(){
		dao = new StudentInfoDAOImpl();
	}
	@Override
	public boolean addStudentInfo(StudentInfo sutdentInfo) {
		boolean flag = false;
		try{
			flag = dao.doCreat(sutdentInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateStudentInfo(StudentInfo sutdentInfo) {
		boolean flag = false;
		try{
			flag = dao.doUpdate(sutdentInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean removeStudentInfo(Integer sutdentInfoId) {
		boolean flag = false;
		try{
			flag = dao.doRemove(sutdentInfoId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<StudentInfo> findAllStudentInfo(String keyWord,
			Integer curPage, Integer pageSize, String orderType,
			String orderField, Integer studentInfoId) {
		List<StudentInfo> list = null;
		try{
			list = dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, studentInfoId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public StudentInfo findById(Integer studentInfoId) {
		StudentInfo studentInfo = null;
		try{
			studentInfo = dao.findById(studentInfoId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return studentInfo;
	}

	@Override
	public Long getAllCount(String keyWord, Integer studentInfoId) {
		Long count = 0l;
		try{
			count = dao.getAllCount(keyWord, studentInfoId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

}
