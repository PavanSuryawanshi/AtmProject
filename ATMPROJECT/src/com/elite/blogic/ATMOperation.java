package com.elite.blogic;

import com.elite.exceptions.DepositException;
import com.elite.exceptions.InsufficientFundException;
import com.elite.exceptions.WithdrawException;

import java.util.Scanner;

public class ATMOperation {
    double balance = 0; // 500 
    Scanner scn = new Scanner(System.in);
    // ATMOperation Constructor is used for initializing balance..
    public ATMOperation(){
        balance = 500;
    }

    public void deposit() throws DepositException, NumberFormatException{
        System.out.print("Enter how much amount you want to deposit : ");
        double amount = Double.parseDouble(scn.nextLine());
        if (amount <= 0 || amount < 100) {
            DepositException de = new DepositException();
            throw de;
        } else {
            balance = balance + amount;
            System.out.println("your account is credited with "+amount+" rupees");
        }
    } // deposit

    public void withdraw() throws WithdrawException, InsufficientFundException, NumberFormatException {
        System.out.println("Enter how much amount you want to withdraw : ");
        double amount = Double.parseDouble(scn.nextLine());
        balance = balance + 10000;
        if (amount <= 0 || amount < 100) {
            throw new WithdrawException();
        } else if ((amount + 500) > balance) {
            throw new InsufficientFundException();
        } else {
            if(amount <= balance) {
                balance = balance - amount;
                System.out.println("your account has been debited with : "+amount+" rupees.");
                System.out.println("your account balance after withdraw is : "+balance);
            }
        }
    } // withdraw

    public void balanceEnquiry() {
        System.out.println("available balance : "+balance);
    } // balanceEnquiry

}
