package com.resms.ssm.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.resms.ssm.auth.bean.User;
import com.resms.ssm.auth.service.UserService;
import org.springframework.web.servlet.ModelAndView;

@Controller  
@RequestMapping("/user")
public class UserController {  
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired 
    private UserService userService;  
	
	public UserController()
	{
		logger.info("~~~~~~~");
	}
      
    @RequestMapping(value="/showUser",method=RequestMethod.GET)
    public String toIndex(HttpServletRequest request,Model model){
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = this.userService.getUserById(userId);  
        model.addAttribute("user", user);  
        
        logger.info("=======================");
        return "showUser";  
    }
    @RequestMapping(value="/show",method=RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、收集参数、验证参数
        //2、绑定参数到命令对象
        //3、将命令对象传入业务对象进行业务处理
        //4、选择下一个页面
        int userId = Integer.parseInt(req.getParameter("id"));

        ModelAndView mv = new ModelAndView();
        //添加模型数据 可以是任意的POJO对象

        User user = this.userService.getUserById(userId);
        mv.addObject("user", user);
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("showUser");
        return mv;
    }

    @RequestMapping(value="/error",method=RequestMethod.GET)
    public ModelAndView error(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "杀个程序员祭天！");
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("error");
        return mv;
    }
}
