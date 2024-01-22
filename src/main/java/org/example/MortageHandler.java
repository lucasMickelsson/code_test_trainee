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

    public double calculate_mortage(){
        double decimal_interest= interest_on_monthly_basis/100;

        double numerator= total_loan*decimal_interest*power((1+decimal_interest), number_of_payments);
        double denominator= power((1 + decimal_interest), number_of_payments) - 1;

        return numerator/denominator;
    }
    private double power(double number, int numOfTimes) {
        double result = 1.0;
        for (int i = 0; i < numOfTimes; i++) {
            result *= number;
        }
        return result;
    }


    public double getInterest_on_monthly_basis() {
        return interest_on_monthly_basis;
    }

    public void setInterest_on_monthly_basis(double interest_on_monthly_basis) {
        this.interest_on_monthly_basis = interest_on_monthly_basis;
    }

    public double getTotal_loan() {
        return total_loan;
    }

    public void setTotal_loan(double total_loan) {
        this.total_loan = total_loan;
    }

    public int getNumber_of_payments() {
        return number_of_payments;
    }

    public void setNumber_of_payments(int number_of_payments) {
        this.number_of_payments = number_of_payments;
    }
}
