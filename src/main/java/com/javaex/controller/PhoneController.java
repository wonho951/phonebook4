package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller	//-->얘도 임포트 해줘야함
public class PhoneController {
	//필드
	//생성자
	//메소드 g/s
	//메소드 - 일반
	@RequestMapping(value="list", method = {RequestMethod.GET, RequestMethod.POST})	//여러개 쓰려면 {}써주기
	public String list() {
		System.out.println("[PhoneController]");
		return "";//jsp 위치 써줌
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/test")	//이름 주는거 action역할
	public String test() {
		System.out.println("test");
	
		return "/WEB-INF/views/test.jsp";	// DispatcherServlet 에게 test.jsp로 포워드 하라는 뜻. 
											// 포워드 되는 파일을 알려줌.
	}
}