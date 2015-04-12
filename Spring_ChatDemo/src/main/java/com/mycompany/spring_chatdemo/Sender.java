/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_chatdemo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

/**
 *
 * @author Quoc Huy Ngo
 */
public class Sender {

    int port;
    String ip;
    public Sender(String ip ,int port) throws IOException, SQLException {
        this.port = port;
        this.ip = ip;
        connetClient();
    }
    
      public void connetClient() throws IOException, SQLException{        
        Socket clientSocket = new Socket(ip , port);
        ObjectOutputStream objectMessage = new ObjectOutputStream(clientSocket.getOutputStream());
        //Message message = new Message(tbUserName.getText(), to , tbMessage.getText());
        objectMessage.writeObject(ClientChat.message);
        ClientChat.connectDB.insertDB(ClientChat.message);
        ClientChat.modelMessage.addElement(ClientChat.message.getFrom().toUpperCase() + " :" + ClientChat.message.getMessage());
    }
}
