package com.company.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.company.models.ReportEntity;
import com.company.models.SmsEntity;
import com.company.service.ReportService;
import com.company.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private SmsService smsService;
	@Autowired
	private ReportService reportService;

	@RequestMapping(value="/sms" )
	public ModelAndView test(HttpServletResponse response) throws IOException{

		ModelAndView mv = new ModelAndView("list-of-sms");
		List<SmsEntity> smsList = smsService.getAllSms();
		mv.addObject("smsList", smsList);

		return mv;
	}

	@RequestMapping(value="/report" )
	public ModelAndView report(HttpServletResponse response) throws IOException{

		ModelAndView mv = new ModelAndView("report");
		List<ReportEntity> reports = reportService.getReports();
		mv.addObject("reports", reports);

		return mv;
	}
}
