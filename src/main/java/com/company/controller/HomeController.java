package com.company.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.company.models.SmsEntity;
import com.company.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private SmsService smsService;

	@RequestMapping(value="/" )
	public ModelAndView test(HttpServletResponse response) throws IOException{

		ModelAndView mv = new ModelAndView("list-of-teams");
		List<SmsEntity> smsList = smsService.getAllSms();
		mv.addObject("smsList", smsList);


		//mv.addObject("att", "hello");
		return mv;
	}
}
