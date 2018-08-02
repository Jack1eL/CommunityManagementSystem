package com.peterpig.cms.dao;

import com.peterpig.cms.bean.Association;
import com.peterpig.cms.bean.Student;
/**
 * 社团接口类
 * @author JackieL
 *
 */
public interface AssociationDAO extends baseDAO<Association, Integer> {
	
	public boolean creatAssociation(Association bean,Integer studentId);
}
