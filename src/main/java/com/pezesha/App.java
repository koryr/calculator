package org.example;

/**
 * Hello world!
 */
public class App {

    private float totalInterest;



    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * Loan calculator function
     *
     * @param amount             Loan amount
     * @param term               Loan term in months
     * @param rate               Interest rate per year
     * @param repaymentFrequency Repayment frequency (monthly, bi-monthly, or weekly)
     */
    public void calculator(float amount, int term, int rate, String repaymentFrequency) {
        totalInterest = (amount * term * rate) / 100;
        System.out.println("interest"+ totalInterest);


    }

    private int frequencyNumber(Frequency frequency){
        switch (frequency){
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
