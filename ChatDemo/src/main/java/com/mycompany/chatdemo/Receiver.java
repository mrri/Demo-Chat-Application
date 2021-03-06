package com.mycompany.chatdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receiver extends Thread {

    int port;
    ServerSocket socketServer;
    Socket socketReceiver;
    //String message = "";
    Message message;

    public Receiver(int port) {
        this.port = port;
    }

    public void connection() throws IOException, SQLException, ClassNotFoundException {
        socketServer = new ServerSocket(port);
        while (true) {
            socketReceiver = socketServer.accept();
            /*BufferedReader bufferedMessage = new BufferedReader(new InputStreamReader(socketReceiver.getInputStream()));
             message = bufferedMessage.readLine();
             if(message.equals("EXIT"))
             break;
             else{
             String Message = "Receiver: " + message;
             //Storage into DB
             ClientChat.connectDB.InsertToDB(message);
             ClientChat.modelMessage.addElement(Message);
             }*/
            ObjectInputStream objectMessage = new ObjectInputStream(socketReceiver.getInputStream());
            message = (Message) objectMessage.readObject();
            ClientChat.to = message.getFrom();
            ClientChat.connectDB.InsertToDB(message);
            if (message.getMessage().equals("EXIT")) {
                break;
            } else {
                ClientChat.modelMessage.addElement(message.getFrom().toUpperCase() + " :" + message.getMessage());
            }
        }
        socketServer.close();
        System.out.println("Disconnect");
    }

    public void run() {
        try {
            connection();
        } catch (IOException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
