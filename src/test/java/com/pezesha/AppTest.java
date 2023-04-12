package com.pezesha;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private App app;

    @Before
    public void setUp() {
//Arrange
        app = new App();
    }


    /**
     * test calculator function
     */

    @Test
    public void testCalculatorDailyPayment() {
        System.out.println("Daily Repayment");
        app.calculator(100,11,8, App.Frequency.DAILY);
    }

    @Test
    public void testCalculatorBIMonthly() {
        System.out.println("BI-Monthly Repayment");
        app.calculator(100,3,8, App.Frequency.BI_MONTHLY);
    }

    @Test
    public void testCalculatorMonthly() {
        System.out.println("Monthly Repayment");
        app.calculator(100,3,8, App.Frequency.MONTHLY);
    }
}
