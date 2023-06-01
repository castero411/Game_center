package com.example.solitairegame;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URI;


public class RegisterStage extends Screen {


    @Override
    public void start(Stage stage) {



        Pane mainView=new Pane();
        Pane vBox=new VBox(10);
        Button Register=new Button("Register");
        ImageView imageView = new ImageView("D:\\my work\\my projects\\Solitaire_Project\\Icon.png");
        Image image1=new Image("D:\\my work\\my projects\\Solitaire_Project\\Background2.jpg");
        Background background = new Background(new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
        mainView.setBackground(background);
        Glow glow=new Glow();

        Hyperlink About=new Hyperlink("About us");
        About.setLayoutX(380);
        About.setLayoutY(240);
        About.setTextFill(Paint.valueOf("black"));
        About.setVisited(false);
        About.setOnAction(event->{
            try{
                java.awt.Desktop.getDesktop().browse(URI.create("https://github.com/castero2castero"));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        Text Type=new Text("Register");
        Type.setFont(new Font("serif",32));
        Type.setFill(Color.rgb( 235,156, 92));
        Type.setX(10);
        Type.setY(69);


        Hyperlink goBack=new Hyperlink("Back to LOGIN");
        goBack.setTextFill(Color.WHITE);
        goBack.setLayoutX(350);
        goBack.setLayoutY(20);
        goBack.setOnAction(event->{
            LoginStage backToLogin=new LoginStage();
            try {
                backToLogin.start(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        TextField usernameField=new TextField();
        usernameField.setMaxWidth(130);


        imageView.setEffect(glow);
        imageView.setOnTouchPressed(event->{
            System.out.println("welcome lad");
        });

        Text UserName= new Text("User name");
        UserName.setFont(new Font("Comic Sans MS",15));
        UserName.setFill(Paint.valueOf("white"));

        Text Password = new Text("Password");
        Password.setFont(new Font("Comic Sans MS",15));
        Password.setFill(Paint.valueOf("white"));

        PasswordField passwordField=new PasswordField();
        passwordField.setMaxWidth(130);


        vBox.getChildren().addAll(UserName,usernameField,Password,passwordField,Register);
        mainView.getChildren().add(vBox);
        ((VBox) vBox).setSpacing(10);
        Scene s=new Scene(mainView);
        ((VBox) vBox).setAlignment(Pos.CENTER);
        vBox.setMinWidth(480);
        vBox.setMinHeight(270);
        mainView.getChildren().addAll(imageView,About,goBack,Type);
        imageView.setY(230);
        imageView.setX(5);



        Register.setOnAction(event -> {
            setUsername(usernameField.getText());
            setPassword(passwordField.getText());
            if (getUsername().trim().isEmpty() || getPassword().trim().isEmpty()) {
                System.out.println("Please enter a username and password.");
                Text error=new Text("parameters are empty");
                error.setX(320);
                error.setY(150);
                error.setFill(Paint.valueOf("red"));
                mainView.getChildren().add(error);

            } else if (checkUsernameExists(getUsername())) {
                Text error1=new Text("username already exists");error1.setX(320);
                error1.setY(150);
                error1.setFill(Paint.valueOf("red"));
                mainView.getChildren().add(error1);
            } else {
                addNewUser(getUsername(), getPassword());
                System.out.println("Registration successful.");
                ChooseMenu next=new ChooseMenu();
                LoginStage.setUserName(LoginStage.getUserName());
                try {
                    next.start(stage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });






        stage.setMinWidth(480);
        stage.setMaxWidth(480);
        stage.setMinHeight(310);
        stage.setMaxHeight(310);
        stage.setAlwaysOnTop(false);//always stay on top of all tabs
        stage.setScene(s);
        stage.setTitle("Game Project");

        stage.show();






    }

    private void addNewUser(String username, String password) {
        String filename = "Pass";
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
            pw.println(username + "%%" + password);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
