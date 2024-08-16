package com.employee.dao;

import java.util.List;

import com.employee.entity.EmpBeans;

public interface EmpDaoImpl {
	public int saveEmp(EmpBeans emp);
	public EmpBeans getEmpById(int id);
	public List<EmpBeans> getAllEmp();
	public void update(EmpBeans emp);
	public void deleteEmp(int id);
}
