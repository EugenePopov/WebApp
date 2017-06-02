package com.company.service;

import com.company.dao.ReportDao;
import com.company.models.ReportEntity;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Override
    public List<ReportEntity> getReports() {
        return reportDao.getReports();
    }

    @Override
    public void putReport(String json) {

        Gson gson = new Gson();
        ReportEntity report = gson.fromJson(json, ReportEntity.class);

        reportDao.saveReport(report);
    }
}
