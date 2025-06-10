/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_final;
import java.util.Random;
import java.util.Objects;
/**
 *
 * @author RC_Student_lab
 */


public class Message {
    private final String messageID;
    private static int messageCount = 0;

    private final String recipient;
    private final String messageText;

    //  New field added for 'flag'
    private String flag;

    public Message(String recipient, String messageText, String flag) {
        this.messageID = generateMessageID();
        messageCount++;
        this.recipient = recipient;
        this.messageText = messageText;
        this.flag = flag; // Store the flag
    }

    private String generateMessageID() {
        Random rand = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(rand.nextInt(10));
        }
        return id.toString();
    }

    public static int getMessageCount() {
        return messageCount;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    //  Implement getContent to return messageText
    public String getContent() {
        return messageText;
    }

    // ✅ Implement getFlag properly
    public String getFlag() {
        return flag;
    }

    //  Implement set methods
    public void setRecipient(String recipient) {
        // This cannot change final fields, so only allow if not final.
        throw new UnsupportedOperationException("Recipient is final and cannot be changed.");
    }

    public void setContent(String content) {
        throw new UnsupportedOperationException("messageText is final and cannot be changed.");
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    //  Optional: generate a hash for comparison
    public String generateHash() {
        return Integer.toHexString(Objects.hash(recipient, messageText, flag));
    }

    AbstractStringBuilder getMessageText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
