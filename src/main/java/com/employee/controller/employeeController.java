package com.employee.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.dao.EmpDaoImpl;
import com.employee.entity.EmpBeans;

@Controller
public class employeeController {

	@Autowired
	private EmpDaoImpl empDaoImpl;

	@RequestMapping(path = "/home")
	public String home(Model m) {

		List<EmpBeans> list = empDaoImpl.getAllEmp();
		m.addAttribute("empList", list);
		return "home";
	}

	@RequestMapping(path = "/addEmp")
	public String addEmployee() {
		return "addEmp";
	}

	@RequestMapping(path = "/createEmp", method = RequestMethod.POST)
	public String createEmp(@ModelAttribute EmpBeans emp, HttpSession session) {
		System.out.println(emp);

		int i = empDaoImpl.saveEmp(emp);
		if (i > 0) {
			System.out.println("success");
			session.setAttribute("msg", "Inserted Successfully!");
		} else {
			session.setAttribute("msg", "Some Error has been occured!");
		}
		return "redirect:/addEmp";
	}

	@RequestMapping(path = "/editEmp/{id}")
	public String editEmp(@PathVariable int id, Model m) {
		EmpBeans emp = empDaoImpl.getEmpById(id);
		m.addAttribute("emp", emp);
		return "editEmp";

	}

	@RequestMapping(path = "/updateEmp", method = RequestMethod.POST)
	public String updateEmp(@ModelAttribute EmpBeans emp, HttpSession session) {
		

		 empDaoImpl.update(emp);
		 session.setAttribute("msg", "Update Successfully!");
		
		return "redirect:/home";
	}
	
	@RequestMapping(path = "/deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id , HttpSession session) {
		
		empDaoImpl.deleteEmp(id);
		session.setAttribute("msg", "Delete Successfully!");
		return "redirect:/home";
	}

}
