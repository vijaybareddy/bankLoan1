//package org.example;
//
//import org.example.model.*;
//import org.example.service.ApplicationService;
//import org.example.service.LoanAmountService;
//import org.example.service.LoanApprovalService;
//
///**
// * Hello world!
// *
// */
//public class App {
//    public static void main(String[] args) {
//        ApplicationService applicationService = new ApplicationService();
//        LoanApplication loanApplication = new LoanApplication();
//        Address address = new Address();
//        address.city = "mell";
//        address.flatNo = "143";
//        address.pincode = "9154";
//        address.state = "TG";
//        PersonalDetails personalDetails = new PersonalDetails();
//        personalDetails.fullName = "Vijay";
//        personalDetails.dob = "19/02/2000";
//        personalDetails.adharNo = "1763";
//        personalDetails.mailId = "Vijaybareddy143@gmail.com";
//        personalDetails.phoneNo = "9154788755";
//        personalDetails.panNo = "ESEPB0563B";
//
//        SalaryInfo salaryInfo = new SalaryInfo();
//        salaryInfo.salaryLpa = 500000;
//        salaryInfo.expenses = 15000;
//
//        loanApplication.salaryInfo = salaryInfo;
//        loanApplication.address = address;
//        loanApplication.personalDetails = personalDetails;
//        applicationService.getApplication(loanApplication);
//
//        LoanAmountService loanAmountService = new LoanAmountService();
//        LoanDetails loanDetails = loanAmountService.getLoanAmount(loanApplication);
//
//        LoanApprovalService loanApprovalService = new LoanApprovalService(loanAmountService);
//        loanApprovalService.getLoanApproval(12, loanDetails);
//    }
//}
//
