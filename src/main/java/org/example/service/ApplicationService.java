package org.example.service;

import org.example.model.LoanApplication;

import java.util.UUID;

public class ApplicationService {
    public LoanApplication getApplication(LoanApplication loanApplication){
        if ( (loanApplication.salaryInfo.salaryLpa/12)>15000) {
            loanApplication.applicationNo= UUID.randomUUID().toString();
        }
        System.out.println(loanApplication.applicationNo);
        return loanApplication;
    }
}
