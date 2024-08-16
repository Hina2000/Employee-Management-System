package com.employee.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.entity.EmpBeans;

@Repository
public class EmpDao implements EmpDaoImpl {
	
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int saveEmp(EmpBeans emp) {
        int i = (Integer) hibernateTemplate.save(emp);
        return i;
    }

    public EmpBeans getEmpById(int id) {
        EmpBeans emp = hibernateTemplate.get(EmpBeans.class, id);
        return emp;
    }

    public List<EmpBeans> getAllEmp() {
        List<EmpBeans> list = hibernateTemplate.loadAll(EmpBeans.class);
        return list;
    }

    @Transactional
    public void update(EmpBeans emp) {
        hibernateTemplate.update(emp);
    }

    @Transactional
    public void deleteEmp(int id) {
        EmpBeans emp = hibernateTemplate.get(EmpBeans.class, id);
        hibernateTemplate.delete(emp);
    }
}
