package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/simple")
public class SimpleController {
	/**
	 * 第一种
	 * 
	 * 
	 * */
	
	
	@RequestMapping("/servlet")
	public String servlet(HttpServletRequest request) {
		//接收前端传入的参数name
		String name = request.getParameter("name");
		//name ==null || "".equals(name)
		if(StringUtils.isEmpty(name)) {
			name = "world";
		}
		//向request域传值
		request.setAttribute("result", "Hello " + name);
		
		//webapp/pages/param.jap
		
		return "param";
			
	}
	@RequestMapping(value="/simple", method = {RequestMethod.GET})
	public ModelAndView simple(
			@RequestParam(required = false ,defaultValue = "1") 
			int id,
			String name) {
		System.out.println("id param - " + id);
		System.out.println("name param - " +name);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result","ModelAndView传值");
		mv.setViewName("param");
		return mv;
		
		
		
	}
	
	
	
}
