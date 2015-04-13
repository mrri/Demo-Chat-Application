/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_chatdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;


/**
 *
 * @author Quoc Huy Ngo
 */
public class ConnectDB {
    private DataSource dataSource;
    Connection connection = null;
    String table = "message";
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void insertDB(Message message) throws SQLException{
        try {
            String query = "INSERT INTO " + table + " VALUES (?, ?, ?)";
            
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, message.getFrom());
            ps.setString(2, message.getTo());
            ps.setString(3, message.getMessage()); 
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(connection != null)
                connection.close();
        }
        
    }
}

