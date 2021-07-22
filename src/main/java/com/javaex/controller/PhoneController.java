package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.PhoneDao;
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
	public String list(Model model) {		//Model은 택배박스 내놓으라는 뜻
		System.out.println("[PhoneController]");
		
		//Dao사용
		 PhoneDao phoneDao = new PhoneDao(); 
		 
		 //Dao의 메소드로 데이터 가져오기
		 List<PersonVo> personList = phoneDao.getPersonList();
		 
		 
		 //model담기 (택배박스 담기)	--> DispatcherServlet(ds)에 전달된다 --> request의 attritube영역에 넣는다.
		 model.addAttribute("personList", personList);
		 System.out.println(personList);
		
		
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
    //ModelAttribute일때
    @RequestMapping(value="/write", method= {RequestMethod.GET,RequestMethod.POST})
    public String write(@ModelAttribute PersonVo personVo) {	//알아서 PersonVo를 new해서 파라미터까지 담아줌. 개꿀?
       System.out.println("[PhoneController.write]");

       //@ModelAttribute --> new PersonVo()
       //				 --> 값을 넣어주는 원리는 기본생성자 + setter 로 넣어줌	--> 기본생성자 있는지 확인하기
       //				 --> 필드명이랑 세터랑 이름 맞아야함.
       System.out.println(personVo);
       
       PhoneDao phoneDao = new PhoneDao();       
       phoneDao.personInsert(personVo);
       
       return "redirect:/list";	//리다이렉트 문법  redirect:  이 뒤에 주소써줌
    }
	
	
	//파라미터가 있을때도 있고 없을때도 있고	
	/*
    @RequestMapping(value="/write", method= {RequestMethod.GET,RequestMethod.POST})
    public String write(@RequestParam("name") String name, 
 		   			    @RequestParam("hp") String hp, 
		   			    @RequestParam(value = "company", required = false, defaultValue = "-1") String company) {	//디폴트 값은 변수가 아예 없을때 -1로 나옴
       System.out.println("[PhoneController.write]");

       PersonVo personVo = new PersonVo(name, hp, company);
       System.out.println(personVo);
       return "";
    }*/
	
    
    //pathVariable test
    @RequestMapping(value = "/board/read/{no}", method = {RequestMethod.GET, RequestMethod.POST})
    public String read(@PathVariable("no") int boardNo) {
    	System.out.println("pathVariable [read]");
    	
    	//localhost:8088/phonebook3/board/read/1	이런 형식으로 주소 쓰면됨
    	//localhost:8088/phonebook3/board/read/2
    	
    	
    	System.out.println(boardNo);
    	
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