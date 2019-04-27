package com.tutorials;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private BankAccount bankAccount;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @Before
    public void setup(){
        bankAccount = new BankAccount("Guy", "Ritchie", 5000.00, BankAccount.CHECKING);
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions(){
        return Arrays.asList(new Object[][]{
                {100.00, true, 5100.00},
                {200.00, true, 5200.00},
                {325.14, true, 5325.14},
                {489.33, true, 5489.33},
                {1000.00, true, 6000.00},
        });
    }

    @Test
    public void deposit() {
        assertEquals(expected, bankAccount.deposit(amount, branch), 0);
    }
}
