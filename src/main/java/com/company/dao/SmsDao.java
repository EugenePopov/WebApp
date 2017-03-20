package com.company.dao;

import com.company.models.SmsEntity;
import java.util.List;

public interface SmsDao {
    List<SmsEntity> getAllSms();
}
