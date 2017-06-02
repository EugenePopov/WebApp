package com.company.controller;

import com.company.models.ReportEntity;
import com.company.service.ReportService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@org.springframework.web.bind.annotation.RestController

public class RestController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/entity", method = RequestMethod.GET)
    public String getEntity(HttpServletResponse response) throws IOException {

        List<ReportEntity> reports = reportService.getReports();

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(reports);

        return json;
    }
}
