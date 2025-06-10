/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.alphachat;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class alphachat {
    public String fName, lName, Username, Password, cellphone;

    public boolean checkPasswordComplexity(String password) {
        boolean hasUppercase = false, hasDigit = false, hasSpecialCharacter = false;
        String specialChars = "!@#$%^&*()_+-=[]{}|;':,.<>?~";
        if (password.length() < 8) return false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (specialChars.contains(String.valueOf(c))) hasSpecialCharacter = true;
        }
        return hasUppercase && hasDigit && hasSpecialCharacter;
    }

    public boolean checkCellPhoneNumber(String number) {
        return number != null && number.matches("\\+\\d{10,}");
    }

    public String RegisterUser() {
        boolean validUsername = false;
        boolean validPassword = false;
        boolean validCellphone = false;

        fName = JOptionPane.showInputDialog("Enter your first name:");
        lName = JOptionPane.showInputDialog("Enter your last name:");

        while (!validUsername) {
            Username = JOptionPane.showInputDialog("Enter your username (must include '_' and be no more than 5 characters):");
            if (Username != null && Username.contains("_") && Username.length() <= 5) {
                JOptionPane.showMessageDialog(null, "Username successfully captured.");
                validUsername = true;
            } else {
                JOptionPane.showMessageDialog(null, "Username is incorrectly formatted.");
            }
        }

        while (!validPassword) {
            Password = JOptionPane.showInputDialog("Enter your password (8+ chars, uppercase, digit, special character):");
            if (checkPasswordComplexity(Password)) {
                JOptionPane.showMessageDialog(null, "Password successfully captured.");
                validPassword = true;
            } else {
                JOptionPane.showMessageDialog(null, "Password does not meet the complexity requirements.");
            }
        }

        while (!validCellphone) {
            cellphone = JOptionPane.showInputDialog("Enter your cellphone number with international code (e.g. +2783968976):");
            if (checkCellPhoneNumber(cellphone)) {
                JOptionPane.showMessageDialog(null, "Cell number successfully captured.");
                validCellphone = true;
            } else {
                JOptionPane.showMessageDialog(null, "Cell number is incorrectly formatted.");
            }
        }

        return "User registered successfully!";
    }

   public static void main(String[] args) {
    POE_Final user = new POE_Final();

    MessageApp messageApp = new MessageApp(); // Link to MessageApp

    JOptionPane.showMessageDialog(null, "Welcome to Alpha Chat");
    JOptionPane.showMessageDialog(null, user.RegisterUser());

    LoginClass login = new LoginClass(user.Username, user.Password, user.fName, user.lName);

    boolean loggedIn = false;
    while (!loggedIn) {
        String loginUsername = JOptionPane.showInputDialog("Enter your username to login:");
        String loginPassword = JOptionPane.showInputDialog("Enter your password to login:");

        JOptionPane.showMessageDialog(null, login.returnLoginStatus(loginUsername, loginPassword));

        if (login.loginUser(loginUsername, loginPassword)) {
            loggedIn = true;
        }
    }

    int maxMessages = 0;
    while (true) {
        try {
            maxMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages do you want to send?"));
            if (maxMessages > 0) break;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
        }
    }

    int sentMessages = 0;

    while (true) {
        String menu = """
                      Please select an option:
                      1) Send Messages
                      2) Show Recently Sent Messages
                      3) Quit
                      """;
        String choice = JOptionPane.showInputDialog(menu);

        if (choice == null || choice.equals("3")) {
            JOptionPane.showMessageDialog(null, "Thank you for using QuickChat. Total messages sent: " + sentMessages);
            break;
        }

        switch (choice) {
            case "1" -> {
                if (sentMessages >= maxMessages) {
                    JOptionPane.showMessageDialog(null, "You have reached your message limit.");
                    break;
                }

                String recipient = JOptionPane.showInputDialog("Enter recipient phone number:");
                if (MessageApp.checkRecipientCell(recipient) == 0) {  // ✅ FIXED: changed to int check
                    JOptionPane.showMessageDialog(null, "Invalid phone number format.");
                    break;
                }

                String messageText = JOptionPane.showInputDialog("Enter your message (max 250 characters):");
                if (messageText == null || messageText.length() > 250) {
                    JOptionPane.showMessageDialog(null, "Message too long. Try again.");
                    break;
                }

                Message msg = new Message(recipient, messageText, "Sent");
                messageApp.storeMessage(msg);

                JOptionPane.showMessageDialog(null, "Message sent to " + recipient + ": " + messageText);
                sentMessages++;
            }

            case "2" -> JOptionPane.showMessageDialog(null, MessageApp.printMessages());  // ✅ FIXED: show sent messages

            default -> JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        }
   }
}



