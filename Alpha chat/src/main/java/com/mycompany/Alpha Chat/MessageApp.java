/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_final;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Map;

/**
 *
 * @author RC_Student_lab
 */
public class MessageApp {
    private static final List<Message> messageList = new ArrayList<>();

    public static boolean checkMessageID(String id) {
        return id != null && id.length() <= 10;
    }

    public static int checkRecipientCell(String cellNumber) {
        if (cellNumber != null && cellNumber.startsWith("+") && cellNumber.length() <= 13 && cellNumber.length() >= 11) {
            return 1;
        } else {
            return 0;
        }
    }

    public static String createMessageHash(String message) {
        return Integer.toHexString(message.hashCode());
    }

    public static String sendMessage(String recipient, String messageText) {
        if (messageText.length() > 250) {
            return "Please enter a message of less than 250 characters.";
        }

        Message message = new Message(recipient, messageText, "Sent");
        messageList.add(message);
        storeMessage(message);
        return "Message sent.";
    }

    public static void storeMessage(Message message) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter("messages.json", true);
            gson.toJson(message, writer);
            writer.write(System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving message: " + e.getMessage());
        }
    }

    public static String printMessages() {
        if (messageList.isEmpty()) return "No messages sent.";
        StringBuilder output = new StringBuilder("Sent Messages:\n");
        for (Message msg : messageList) {
            output.append("To: ").append(msg.getRecipient())
                  .append("\nID: ").append(msg.getMessageID())
                  .append("\nMessage: ").append(msg.getMessageText())
                  .append("\n---\n");
        }
        return output.toString();
    }

    public static int returnTotalMessages() {
        return messageList.size();
    }

    void addMessage(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getMessagesByFlag(String sent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getLongestMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getMessagesByRecipient(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getMessageHash(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean deleteMessageByHash(String hash) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    List<Map<String, String>> getSentMessageReport() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}