package org.example;

public class Customer {
    private String name;
    private double total_loan;
    private double interest;
    private int years;

    public Customer(String name, double total_loan, double interest, int years) {
        this.name = name;
        this.total_loan = total_loan;
        this.interest = interest;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public double getTotal_loan() {
        return total_loan;
    }

    public double getInterest() {
        return interest;
    }

    public int getYears() {
        return years;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotal_loan(double total_loan) {
        this.total_loan = total_loan;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
