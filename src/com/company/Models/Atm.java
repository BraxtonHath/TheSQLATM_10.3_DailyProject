package com.company.Models;

import com.company.Helpers.DatabaseManger;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Atm {
    private String name;
    private int balance;
    private Statement statement;

    public Atm(String name, int balance, Statement statement) {
        this.name = name;
        this.balance = balance;
        this.statement = statement;
    }


//    //Overriding the previous version with ID
//    public Atm(String name, int balance, Statement statement, int id) {
//        this(name, balance, statement);
//        this.id = id;
//    }


    public void Save() throws SQLException {
        String formattedSql = String.format("INSERT INTO Atm (name, balance) VALUES ('%s', %s)", name, balance);
        statement.executeUpdate(formattedSql);
        //inserting info into table and saving
    }


    public static List<Atm> findAll(DatabaseManger dbm) throws SQLException {
        ResultSet rs = dbm.findAll("Atm");
        List<Atm> tempCollection = new ArrayList<>();
        Statement tempStatement = dbm.getStatement();
        while (rs.next()) {
            String name = rs.getString("name");
            int balance = rs.getInt("balance");

            Atm transaction = new Atm(name, balance, tempStatement);
            tempCollection.add(transaction);
        }
        return tempCollection;
    }

//    public static Atm findByName(DatabaseManger dbm, Statement statement, String currentName) throws SQLException {
//        String formattedSql = String.format("SELECT * FROM Atm WHERE name = '%s'", currentName);
//        ResultSet rs = statement.executeQuery(formattedSql);
//        List<Atm> tempCollection = new ArrayList<>();
//        Statement tempStatement = dbm.getStatement();
//
//        while (rs.next()) {
//
//            String name = rs.getString("name");
//            int total = rs.getInt("total");
//            int deposit = rs.getInt("deposit");
//            int withdraw =rs.getInt("withdraw");
//
//
//            Atm tempStat = new Atm(name, total, deposit, withdraw, tempStatement, rs.getInt("id"));
//            tempCollection.add(tempStat);
//        }
//        if (tempCollection.size() != 0) {
//            return tempCollection.get(0);
//        } else {
//            return null;
//        }
//    }

    //    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setTotal(int total) {
//        this.total = total;
//    }
//
//    public void setDeposit(int deposit) {
//        this.deposit = deposit;
//    }
//
//    public void setWithdraw(int withdraw) {
//        this.withdraw = withdraw;
//    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public Statement getStatement() {
        return statement;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

