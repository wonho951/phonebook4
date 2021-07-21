package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	//-->얘도 임포트 해줘야함
public class PhoneController {
	//필드
	//생성자
	//메소드 g/s
	//메소드 - 일반
	
	@RequestMapping(value = "/test")	//이름 주는거 action역할
	public void test() {
		System.out.println("test");
	}
}
