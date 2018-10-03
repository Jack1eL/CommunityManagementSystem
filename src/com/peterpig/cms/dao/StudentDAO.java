package com.peterpig.cms.dao;

import java.util.List;

import com.peterpig.cms.bean.Student;

public interface StudentDAO extends baseDAO<Student, Integer> {
	public Student findAllInfo(Student bean);
	
	public List<Student> findStudentByGroupId(Integer associationId);
	
	public Student joinAssociation(Integer aid,Integer sid);
}
