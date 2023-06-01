package com.example.solitairegame;

import javafx.application.Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public abstract class Screen extends Application {

    private String Username;
    private String password;

    public String getUsername(){
        return Username;
    }
    public String getPassword(){
        return password;
    }

    public void setUsername(String name){
        Username=name;
    }
    public void setPassword(String pass){
        password=pass;
    }


    public boolean checkUsernameExists(String username) {
        String filename = "Pass";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("%%");
                if (parts.length == 2 && parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        return false;
    }




}
