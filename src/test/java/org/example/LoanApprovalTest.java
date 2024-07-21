package org.example;


import org.example.model.*;
import org.example.service.ApplicationService;
import org.example.service.LoanAmountService;
import org.example.service.LoanApprovalService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoanApprovalTest {
    @Test

    public void getApplicationNumberIsNotNull(){

        ApplicationService applicationService =new ApplicationService();

        LoanApplication loanApplication = new LoanApplication();
        Address address = new Address();
        address.city = "mell";
        address.flatNo = "143";
        address.pincode = "9154";
        address.state = "TG";
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.fullName = "Vijay";
        personalDetails.dob = "19/02/2000";
        personalDetails.adharNo = "1763";
        personalDetails.mailId = "Vijaybareddy143@gmail.com";
        personalDetails.phoneNo = "9154788755";
        personalDetails.panNo = "ESEPB0563B";


        SalaryInfo salaryInfo = new SalaryInfo();
        salaryInfo.salaryLpa=500000;
        salaryInfo.expenses=15000;

        loanApplication.salaryInfo=salaryInfo;
        loanApplication.address=address;
        loanApplication.personalDetails=personalDetails;

        applicationService.getApplication(loanApplication);

        assertNotNull(loanApplication.applicationNo,"Application Number is not Null");

    }

    @Test

    public void testLoanApplicationWithSufficientSalary() {

        ApplicationService applicationService =new ApplicationService();

        LoanApplication loanApplication = new LoanApplication();

        Address address = new Address();
        address.city = "mell";
        address.flatNo = "143";
        address.pincode = "9154";
        address.state = "TG";
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.fullName = "Vijay";
        personalDetails.dob = "19/02/2000";
        personalDetails.adharNo = "1763";
        personalDetails.mailId = "Vijaybareddy143@gmail.com";
        personalDetails.phoneNo = "9154788755";
        personalDetails.panNo = "ESEPB0563B";


        SalaryInfo salaryInfo = new SalaryInfo();
        salaryInfo.salaryLpa=500000;
        salaryInfo.expenses=15000;

        loanApplication.salaryInfo=salaryInfo;
        loanApplication.address=address;
        loanApplication.personalDetails=personalDetails;

        LoanAmountService loanAmountService = new LoanAmountService();
        LoanApprovalService loanApprovalService = new LoanApprovalService(loanAmountService);

        applicationService.getApplication(loanApplication);
        LoanDetails loanDetails = loanAmountService.getLoanAmount(loanApplication);
        loanApprovalService.getLoanApproval(loanDetails,12);


        assertNotNull(loanApplication.applicationNo, "Application number should not be null");
        assertNotNull(loanDetails, "Loan details should not be null");
        assertEquals(loanDetails.totalAmount, loanDetails.loanAmount * loanDetails.interestRate, 0.001, "Total amount calculation should be correct");
        assertNotEquals(loanApplication.salaryInfo.salaryLpa, loanApplication.salaryInfo.expenses, "Salary and expenses should not be equal");
    }

    @Test

    public void testLoanApplicationWithInsufficientSalary() {

        LoanApplication loanApplication = new LoanApplication();

        Address address = new Address();
        address.city = "mell";
        address.flatNo = "143";
        address.pincode = "9154";
        address.state = "TG";
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.fullName = "Vijay";
        personalDetails.dob = "19/02/2000";
        personalDetails.adharNo = "1763";
        personalDetails.mailId = "Vijaybareddy143@gmail.com";
        personalDetails.phoneNo = "9154788755";
        personalDetails.panNo = "ESEPB0563B";

        loanApplication.personalDetails = personalDetails;

        SalaryInfo salaryInfo = new SalaryInfo();
        salaryInfo.salaryLpa = 200000;
        salaryInfo.expenses = 20000;
        loanApplication.salaryInfo = salaryInfo;

        ApplicationService applicationService = new ApplicationService();
        LoanAmountService loanAmountService = new LoanAmountService();
        LoanApprovalService loanApprovalService = new LoanApprovalService(loanAmountService);

        applicationService.getApplication(loanApplication);
        LoanDetails loanDetails = loanAmountService.getLoanAmount(loanApplication);
        loanApprovalService.getLoanApproval(loanDetails,12);

        assertNotNull(loanApplication.applicationNo, "Application number should not be null");
        assertNotNull(loanDetails, "Loan details should not be null");
        assertEquals(loanDetails.totalAmount, loanDetails.loanAmount * loanDetails.interestRate, 0.001, "Total amount calculation should be correct");
        assertNotEquals(loanApplication.salaryInfo.salaryLpa, loanApplication.salaryInfo.expenses, "Salary and expenses should not be equal");
    }

}
