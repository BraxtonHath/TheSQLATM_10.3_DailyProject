//package com.company.Helpers;
//
//import com.company.Helpers.Bank;
//import com.company.Helpers.Bank;
//import com.company.Helpers.CreateAccount;
//import com.company.Helpers.DatabaseManger;
//import com.company.Models.Atm;
//
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class CreateAccount {
//    public static void checkUser(DatabaseManger dbm) throws SQLException {
//        //limiting users options
//        System.out.println("=========================================================");
//        System.out.println("Thank you for using the Atm. Do you exist in our System?");
//        System.out.println("1) yes");
//        System.out.println("2) no");
//        System.out.println("=========================================================");
//
//        //take the users input for switch
//        Scanner scanner = new Scanner(System.in);
//        int choice = scanner.nextInt();
//
//        //filters thru user inputs and does so and so if blank
//        switch (choice){
//            case 1:
//                System.out.println("Input Name (case sens)");
//                String currentName = scanner.next();
//                Atm searchName = Atm.findByName(dbm, dbm.getStatement(), currentName);
//
//                if (searchName == null) {
//                    System.out.println("not in the system please make a account");
//                    checkUser(dbm);
//                }
//                break;
//
//            case 2:
//                System.out.println("Create User");
//                String name = scanner.next();
//                int total = 0;
//                int deposit = 0;
//                int withdraw = 0;
//                new Atm(name, total, deposit, withdraw, dbm.getStatement()).Save();
//                break;
//
//            default:
//                System.out.println("invalid input");
//        }
//    }
//}
//
//
