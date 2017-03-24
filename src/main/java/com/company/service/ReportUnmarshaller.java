package com.company.service;

import com.company.models.ReportEntity;

public interface ReportUnmarshaller{

    ReportEntity unmarshall(String json);
}
