package com.company.service;

import com.company.models.ReportEntity;

import java.util.List;


public interface ReportService {

    List<ReportEntity> getReports();
    void putReport(String json);
}
