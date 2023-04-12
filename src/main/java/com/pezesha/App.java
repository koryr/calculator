package com.pezesha;

import java.text.DecimalFormat;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    public static final Logger LOGGER = Logger.getLogger(App.class.getName());

    private double totalInterest;
    DecimalFormat f = new DecimalFormat("##0.00");


    public static void main(String[] args) {
        App app = new App();
        app.calculator(100,3,8, App.Frequency.MONTHLY);
    }

    /**
     * Loan calculator function
     *
     * @param principal          Loan amount
     * @param term               Loan term in months
     * @param rate               Interest rate per year
     * @param repaymentFrequency Repayment frequency (monthly, bi-monthly, or weekly)
     */
    public void calculator(double principal, int term, int rate, Frequency repaymentFrequency) {
        double annualRate = (double) rate /100;
        int numberOfPayments = term * frequencyNumber(repaymentFrequency);
        double ratePerPeriod = (double) annualRate / numberOfPayments;
        double compoundPayment = principal * Math.pow(1 + ratePerPeriod, numberOfPayments);
        LOGGER.info("Total payment = " + f.format(compoundPayment));
        totalInterest = compoundPayment - principal;
        LOGGER.info("Total Interest = " + f.format(totalInterest));
        double totalAmount = principal + totalInterest;
        double paidAmount = 0.0;
        double newPrincipal = principal / (double) numberOfPayments;
        double simpleInterest = 0.0;
        for (int i = 0; i < numberOfPayments; i++) {
            simpleInterest = (newPrincipal * (Math.pow((1 + (double) annualRate / i), i))) - newPrincipal;
            paidAmount += newPrincipal + simpleInterest;
            LOGGER.info("Principal = " + f.format(newPrincipal + simpleInterest) + " Interest = " + f.format(simpleInterest) +
                    " Balance = " + f.format(totalAmount - paidAmount));

        }
        System.out.println("\n");
    }

    private int frequencyNumber(Frequency frequency) {
        switch (frequency) {
            case DAILY -> {
                return 30;
            }

            case BI_MONTHLY -> {
                return 2;
            }
            case MONTHLY -> {
                return 1;
            }
            default -> {
                return 0;
            }
        }

    }

    public enum Frequency {
        MONTHLY,
        BI_MONTHLY,
        DAILY
    }
}
