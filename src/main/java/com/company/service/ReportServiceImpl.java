package com.company.service;

import com.company.dao.ReportDao;
import com.company.models.ReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@org.springframework.transaction.annotation.Transactional()
public class ReportServiceImpl implements ReportService{

    @Autowired
    private ReportDao reportDao;

    @Override
    public List<ReportEntity> getReports() {
        return reportDao.getReports();
    }
}
