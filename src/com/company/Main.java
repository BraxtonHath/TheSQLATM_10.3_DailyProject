package com.company;


import com.company.Helpers.DatabaseManger;
import com.company.Helpers.Bank;
import com.company.Models.Atm;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException{

        Class.forName("org.sqlite.JDBC"); //to load in libary


        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:Atm.db")) {// creating DB not Table


            DatabaseManger dbm = new DatabaseManger(connection);
            dbm.dropAtmTable();
            dbm.createAtmTable();

//            CreateAccount.checkUser(dbm);
            Bank.WelcomeMenu(dbm);


        } catch (SQLException ex){//to keep the error from URL ^^^^^
            System.out.println("something went wrong");
            ex.printStackTrace();
        }
    }
}
