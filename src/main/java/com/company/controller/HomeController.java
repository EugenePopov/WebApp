package com.company.controller;

import com.company.models.ReportEntity;
import com.company.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
@Controller
public class HomeController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public ModelAndView getReport(HttpServletResponse response) throws IOException {

        ModelAndView mv = new ModelAndView("report.jsp");
        List<ReportEntity> reports = reportService.getReports();

        mv.addObject("reports", reports);

        return mv;
    }

    @RequestMapping(value = "/api/report", method = RequestMethod.POST, consumes = "application/json")
    public ModelAndView postReport(@RequestBody String httpBody) throws Exception {

        ModelAndView modelAndView = new ModelAndView("report.jsp");

        reportService.putReport(httpBody);

        return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) throws Exception {

        ModelAndView modelAndView = new ModelAndView("login/login.html");

        if (error != null) {
            modelAndView.addObject("error", "Invalid credentials provided");
        }

        if (logout != null) {
            modelAndView.addObject("message", "Logged out successfully");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/try", method = RequestMethod.GET)
    public String tryReturn() {

        return "index.html";
    }
}
