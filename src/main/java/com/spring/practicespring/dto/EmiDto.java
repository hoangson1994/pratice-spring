package com.spring.practicespring.dto;

public class EmiDto {
    private long loan;
    private int term;
    private double rate;

    public EmiDto() {
    }

    public EmiDto(long loan, int term, double rate) {
        this.loan = loan;
        this.term = term;
        this.rate = rate;
    }

    public long getLoan() {
        return loan;
    }

    public void setLoan(long loan) {
        this.loan = loan;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
