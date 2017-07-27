package com.company.Helpers;

import com.company.Helpers.DatabaseManger;
import com.company.Helpers.Bank;
import com.company.Models.Atm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DatabaseManger {

    Connection connection;
    Statement statement;

    public Statement getStatement() {
        return statement;
    }


    public DatabaseManger(Connection connection) throws SQLException {
        this.statement = connection.createStatement();
    }

    public void createAtmTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE Atm (id INTEGER PRIMARY KEY, name String, balance INTEGER)");
        //making a table to for the testing

    }

    public void dropAtmTable() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS Atm");// deletes tables for Test
    }

    public ResultSet findAll(String table) throws SQLException {
        String formattedSql = String.format("SELECT * FROM %s", table);
        ResultSet rs = statement.executeQuery(formattedSql);
        return rs;
    }
}
