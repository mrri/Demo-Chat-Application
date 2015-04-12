/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_chatdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quoc Huy Ngo
 */
public class ConnectDB {
    private Connection connection;
    String table = "message";
    public ConnectDB() throws ClassNotFoundException {
        try {
            connect();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void connect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/chat";
        connection = DriverManager.getConnection(url, "root", "");
        System.err.println("Connect Success");
    }
    
    public void InsertToDB(Message message) throws SQLException{
        Statement statement = (Statement)connection.createStatement();
        String query = "insert into " + table + " values('" + message.getMessage()
                                                         + "','" + message.getFrom() + "','" + message.getTo() + "')";
        statement.executeUpdate(query);
    }
            
}
