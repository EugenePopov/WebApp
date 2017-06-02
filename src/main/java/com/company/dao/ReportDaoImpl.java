package com.company.dao;

import com.company.models.ReportEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportDaoImpl implements ReportDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<ReportEntity> getReports() {
        return getCurrentSession().createQuery("from ReportEntity ").list();
    }

    @Override
    public void saveReport(ReportEntity report) {
        getCurrentSession().save(report);
    }
}
