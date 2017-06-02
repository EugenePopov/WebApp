package com.company.dao;

import com.company.models.ReportEntity;

import java.util.List;

public interface ReportDao {
    List<ReportEntity> getReports();

    void saveReport(ReportEntity report);
}
