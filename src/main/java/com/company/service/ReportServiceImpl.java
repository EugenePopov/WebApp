package com.company.service;

import com.company.dao.ReportDao;
import com.company.models.ReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//TODO: service vs transactional

@Service
@Transactional
public class ReportServiceImpl implements ReportService{

    @Autowired
    private ReportDao reportDao;

    @Override
    public List<ReportEntity> getReports() {
        return reportDao.getReports();
    }

    @Override
    public void putReport(String json) {
        ReportUnmarshaller unmarshaller = new ReportUnmarshallerImpl();
        ReportEntity report = unmarshaller.unmarshall(json);

        reportDao.saveReport(report);
    }
}
