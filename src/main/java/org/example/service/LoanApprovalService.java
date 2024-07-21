package org.example.service;

import org.example.model.LoanDetails;

public class LoanApprovalService {
    public LoanAmountService loanAmountService;

    public LoanApprovalService(LoanAmountService loanAmountService){
        this.loanAmountService = loanAmountService;
    }

    public void getLoanApproval(LoanDetails loanDetails,int months ){

        double  emiPm=loanDetails.totalAmount/months;
        if ( loanAmountService.balanceAmount > 0.6 * emiPm){
            System.out.println("eligble for loan");
        }else {
            System.out.println("not eligble for loan");
        }
    }
}
