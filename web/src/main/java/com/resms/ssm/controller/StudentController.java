package com.resms.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.resms.ssm.model.Student;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	/**
	 * 简单参数绑定
	 * 
	 * @param request
	 * @param model
	 * @param student_id
	 * @return
	 */
	// @RequestParam里边指定request传入参数名称和形参进行绑定。如果不用要求传入参数和形参必须一致
	// 通过required属性指定参数是否必须要传入
	// 通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	@RequestMapping(value = "/add", method = { RequestMethod.POST, RequestMethod.GET })
	public String getItem(HttpServletRequest request, Model model,
			@RequestParam(value = "id", required = true, defaultValue = "1") Integer student_id) {

		model.addAttribute("message", "this is a addStudent action message");
		if(request.getMethod().equalsIgnoreCase(RequestMethod.POST.name()))
		{
			logger.info("=======================add");		
		}
		else if(request.getMethod().equalsIgnoreCase(RequestMethod.GET.name()))
		{
			logger.info("=======================get");	
		}
		else
		{
			logger.info("=======================other web method");
		}
		return "info";
	}

	/**
	 * pojo绑定 页面表单中的input的name和controller的pojo形参中的属性名称（非形参名）一致，即可将页面数据绑定到pojo
	 * 
	 * @param request
	 * @param model
	 * @param items_id
	 * @return
	 */
	@RequestMapping(value = "/edit", method = { RequestMethod.POST, RequestMethod.GET })
	public String editStudent(Student student, HttpServletRequest request, Model model) {
		if (request.getMethod().equalsIgnoreCase(RequestMethod.POST.name())) {
			logger.info("=======================editStudent");
			System.out.println("name=" + student.getName());
			model.addAttribute("message", "this is a editStudent action message");
			return "info";
		} else {
			logger.info("=======================getStudent");
			Student s = new Student();
			s.setName("sam");
			s.setId(1L);

			model.addAttribute("student", s);
			return "addStudent";
		}
	}
}
