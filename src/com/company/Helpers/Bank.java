package com.company.Helpers;

import com.company.Helpers.DatabaseManger;
import com.company.Helpers.Bank;
import com.company.Models.Atm;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Bank {

    public static void WelcomeMenu(DatabaseManger dbm) throws SQLException {
        System.out.println("————————————————————————————————————————————————");
        System.out.println("Welcome to ATM 3000. What would you like to do?");
        System.out.println("1) Check History");
        System.out.println("2) Deposit Amount");
        System.out.println("3) Withdraw Amount");
        System.out.println("————————————————————————————————————————————————");

        Scanner scanner = new Scanner( System.in );
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Now showing history");
                List<Atm> results = Atm.findAll(dbm);
                int totalBalance = 0;
                for (Atm atm : results) {
                    System.out.println(atm);
                    totalBalance = totalBalance + atm.getBalance();
                }
                System.out.println("Total{balance=" + totalBalance + "}");
                break;
            case 2:
                System.out.println("What is the name of your deposit?");
                String depositName = scanner.next();
                System.out.println("How much are you depositing?");
                int deposit = scanner.nextInt();
                new Atm(depositName, deposit, dbm.getStatement()).Save();
                break;
            case 3:
                System.out.println("What is the name of your withdraw?");
                String withdrawName = scanner.next();
                System.out.println("How much are you withdrawing?");
                int initialWithdraw = scanner.nextInt();
                int withdraw = -initialWithdraw;
                new Atm(withdrawName, withdraw, dbm.getStatement()).Save();
                break;
        }
        WelcomeMenu(dbm);
    }
}

