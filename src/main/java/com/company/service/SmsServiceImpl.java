package com.company.service;


import com.company.dao.SmsDao;
import com.company.models.SmsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@org.springframework.transaction.annotation.Transactional()
public class SmsServiceImpl implements SmsService{

    @Autowired
    private SmsDao smsDao;
    public List<SmsEntity> getAllSms() {
        return smsDao.getAllSms();
    }
}
