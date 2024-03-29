package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Employee;
import com.service.EmployeeService;

@Controller
public class EmployeeController {

	@RequestMapping(value = "demo",method = RequestMethod.GET)
	public ModelAndView sayHello() {
		System.out.println("I Came here");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("display.jsp");
		return mav;
	}
	
	@Autowired
	EmployeeService employeeService;
	@RequestMapping(value = "store",method = RequestMethod.POST)
	public ModelAndView storeInfo(HttpServletRequest req,Employee emp) {
		System.out.println("I Came here");
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		float salary = Float.parseFloat(req.getParameter("salary"));
		emp.setId(id);
		emp.setName(name);
		emp.setSalary(salary);
		String res = employeeService.storeEmployeeInfo(emp);
		System.out.println(res);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		return mav;
	}
	
}
