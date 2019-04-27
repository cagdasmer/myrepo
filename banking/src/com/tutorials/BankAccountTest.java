package com.tutorials;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount bankAccount;

    @Before
    public void setup(){
        bankAccount = new BankAccount("Lionel", "Richie", 1000.00, BankAccount.CHECKING);
    }

    @Test
    public void deposit() {
        assertEquals(1500.00, bankAccount.deposit(500.00, true), 0);
    }

    @Test
    public void withdraw_branch() {
        assertEquals(400.00, bankAccount.withdraw(600.00, true), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdraw_atm() {
        assertEquals(400.00, bankAccount.withdraw(600.00, false), 0);

        // old way
        /* try and don't catch */
    }

    @Test
    public void getBalance() {
        assertEquals(1000.00, bankAccount.getBalance(), 0);
    }


    @Test
    public void isChecking() {
        assertTrue("Not a checking account", bankAccount.isChecking());
    }
}