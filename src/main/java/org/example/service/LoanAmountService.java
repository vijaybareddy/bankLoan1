package org.example.service;

import org.example.model.LoanApplication;
import org.example.model.LoanDetails;

public class LoanAmountService {
    public double balanceAmount;
    public LoanDetails loanDetail;

    public LoanDetails getLoanAmount(LoanApplication loanApplication){
        balanceAmount=(loanApplication.salaryInfo.salaryLpa/12)-loanApplication.salaryInfo.expenses;
        loanDetail = new LoanDetails();
        loanDetail.loanAmount=balanceAmount*10;
        loanDetail.interestRate=0.07;
        loanDetail.totalAmount=loanDetail.loanAmount*loanDetail.interestRate;
        System.out.println(loanDetail.totalAmount);
        return loanDetail;
    }
}
