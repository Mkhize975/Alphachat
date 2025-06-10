/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_final;

/**
 *
 * @author RC_Student_lab
 */
public class LoginClass {
    private final String storedUsername;
    private final String storedPassword;
    private final String firstName;
    private final String lastName;

    // Constructor receives user data from registration
    public LoginClass(String username, String password, String fName, String lName) {
        this.storedUsername = username;
        this.storedPassword = password;
        this.firstName = fName;
        this.lastName = lName;
    }

    // Login method
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return storedUsername.equals(enteredUsername) && storedPassword.equals(enteredPassword);
    }

    // Status message
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

