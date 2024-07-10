package com.elite.user;

import com.elite.blogic.ATMMenu;
import com.elite.blogic.ATMOperation;
import com.elite.exceptions.DepositException;
import com.elite.exceptions.InsufficientFundException;
import com.elite.exceptions.WithdrawException;

import java.util.Scanner;

public class ATMTest {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ATMOperation ao = new ATMOperation();
        // select your appropriate option
        while (true) {
            try {
                ATMMenu.displayMenu();
                System.out.print("\n\tEnter your choice : ");
                int choice = Integer.parseInt(scn.nextLine());
//                while (true) {
                    if (choice == 1 || choice == 2 || choice == 3 || choice == 4) {
                        switch (choice) {

                            case 1:
                                while (true) {
                                    try {
                                        ao.deposit();
                                        System.out.println("Thanks for visit....");
                                        break;
                                    } catch (DepositException de) {
                                        System.out.println("don't try to deposit 0 and less than 100 rupees..");
                                    } catch (NumberFormatException nfe) {
                                        System.out.println("don't try to enter amount as string, character and special symbol..");
                                    }
                                }
                                break;
                            case 2:
                                while (true) {
                                    try {
                                        ao.withdraw();
                                        System.out.println("Thanks for a  visit.....");
                                        break;
                                    } catch (NumberFormatException nfe) {
                                        System.out.println("don't try to pass amount as string, character and special symbol..");
                                    } catch (WithdrawException we) {
                                        System.out.println("don't pass amount as less than zero and less than 100 rupees..");
                                    } catch (InsufficientFundException ife) {
                                        System.out.println("you account not have enough money...");
                                    }
                                }
                                break;
                            case 3:
                                ao.balanceEnquiry();
                                System.out.println("Thanks You for visit....");
                                break;
                            case 4:
//                                return;

                        }
                    } else {
                        System.out.println("Invalid choice!!! try to select valid choice from below choices...\n");
                    }
//                }
            } catch (NumberFormatException nfe) {
                System.out.println("don't try to enter string, character and special symbol select from below choice...");
            }

        }


    }
}
