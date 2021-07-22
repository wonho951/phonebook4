package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.vo.PersonVo;

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
	
	//localhost:8088/phonebook3/write?name=최원호&hp=010-2222-2222&company=02-2222-2222
	//Write
	//파라미터를 1개씩 받을때
    /*@RequestMapping(value="/write", method= {RequestMethod.GET,RequestMethod.POST})
    public String write(@RequestParam("name") String name, 
 		   			    @RequestParam("hp") String hp, 
		   			    @RequestParam("company") String company) {
       System.out.println("[PhoneController.write]");

       PersonVo personVo = new PersonVo(name, hp, company);
       System.out.println(personVo);
       return "";
    }*/
	
	
	//파라미터 다받을때 (파라미터 갯수 많아질수록 개꿀인듯)
    @RequestMapping(value="/write", method= {RequestMethod.GET,RequestMethod.POST})
    public String write(@ModelAttribute PersonVo personVo) {	//알아서 PersonVo를 new해서 파라미터까지 담아줌. 개꿀?
       System.out.println("[PhoneController.write]");

       //@ModelAttribute --> new PersonVo()
       //				 --> 값을 넣어주는 원리는 기본생성자 + setter 로 넣어줌	--> 기본생성자 있는지 확인하기      
       System.out.println(personVo);
       return "";
    }
	
	
	
	
	
	//테스트
	@RequestMapping(value="/test")	//이름 주는거 action역할
	public String test() {
		System.out.println("test");
	
		return "/WEB-INF/views/test.jsp";	// DispatcherServlet 에게 test.jsp로 포워드 하라는 뜻. 
											// 포워드 되는 파일을 알려줌.
	}
}