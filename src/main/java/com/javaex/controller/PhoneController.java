package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller	//-->얘도 임포트 해줘야함
//@RequestMapping(value = "/pb")	//얘로 통일하면 /pb/ ~~해야 주소가됨
public class PhoneController {
	//필드
	//생성자
	//메소드 g/s
	//메소드 - 일반
	
	//리스트
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})	//여러개 쓰려면 {}써주기
	public String list() {
		System.out.println("[PhoneController]");
		return "/WEB-INF/views/list.jsp";	// DispatcherServlet 에게 test.jsp로 포워드 하라는 뜻.
		
	}
	
		
	//쓰기폼
	@RequestMapping(value = "/writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("[PhoneController.writeFrom]");
		
		return "/WEB-INF/views/writeForm.jsp";	// DispatcherServlet 에게 test.jsp로 포워드 하라는 뜻.
	}
	
	
	//쓰기
	
	//테스트
	@RequestMapping(value="/test")	//이름 주는거 action역할
	public String test() {
		System.out.println("test");
	
		return "/WEB-INF/views/test.jsp";	// DispatcherServlet 에게 test.jsp로 포워드 하라는 뜻. 
											// 포워드 되는 파일을 알려줌.
	}
}