package com.service.loan.service;

import com.service.loan.dto.AuditData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AuditService {

    private final List<AuditData> auditData = new ArrayList<>();

    public List<AuditData> getAudit(){
        return this.auditData;
    }

    public void saveAudit(AuditData data){
        auditData.add(data);
    }
}
