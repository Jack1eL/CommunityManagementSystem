package com.peterpig.cms.dao;

import com.peterpig.cms.bean.Student;

public interface StudentDAO extends baseDAO<Student, Integer> {
	public Student findAllInfo(Student bean);
}
