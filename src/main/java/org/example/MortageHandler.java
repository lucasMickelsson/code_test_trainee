package org.example;

public class MortageHandler {
    private double interest_on_monthly_basis;
    private double total_loan;
    private int number_of_payments;

    public MortageHandler(double interest_on_monthly_basis, double total_loan, int number_of_payments) {
        this.interest_on_monthly_basis = interest_on_monthly_basis;
        this.total_loan = total_loan;
        this.number_of_payments = number_of_payments;
    }

    double calculate_mortage(){
        double fixed_monthly_payment=(total_loan*
                (interest_on_monthly_basis*(1+interest_on_monthly_basis)^number_of_payments))
                /((1+interest_on_monthly_basis)^number_of_payments)-1;
        return fixed_monthly_payment;
    }
}
