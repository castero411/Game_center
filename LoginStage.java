package com.example.solitairegame;

import javafx.application.Application;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;


public   class LoginStage extends Application {


    private static String UserName;

    private String Password;
    public static String getUserName() {
        return UserName;
    }
    public static void setUserName(String name){
        UserName=name;
    }
    private Stage main=new Stage();

    public Stage getStage(){
        return main;
    }





    @Override
    public void start(Stage stage) throws IOException {

        main=stage;
        Pane mainView=new Pane();
        Pane vBox=new VBox(10);
        Button login=new Button("Login");
        ImageView imageView = new ImageView("D:\\my work\\my projects\\Solitaire_Project\\Icon.png");
        Image image1=new Image("D:\\my work\\my projects\\Solitaire_Project\\Background2.jpg");
        Background background = new Background(new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
        mainView.setBackground(background);
        Glow glow=new Glow();


        TextField usernameField=new TextField();
        usernameField.setMaxWidth(130);

        PasswordField passwordField=new PasswordField();
        passwordField.setMaxWidth(130);



        Text Type=new Text("Login");
        Type.setFont(new Font("ariel",32));
        Type.setFill(Color.rgb( 235,156, 92));
        Type.setX(10);
        Type.setY(69);


        login.setOnAction(event -> {
            UserName = usernameField.getText();
            Password = passwordField.getText();
            if (checkCredentials(UserName, Password)) {
                ChooseMenu nextStage=new ChooseMenu();
                try {
                    nextStage.start(stage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                ;
            } else {
                Text error=new Text("Error\n"+"please check\nyour password");
                error.setX(320);
                error.setY(150);
                error.setFill(Paint.valueOf("red"));
                mainView.getChildren().add(error);
            }
        });







        Button gotoRegister=new Button("Register");
        gotoRegister.setOnAction(event->{
                RegisterStage register=new RegisterStage();
            register.start(stage);
        });
        gotoRegister.setAlignment(Pos.BOTTOM_RIGHT);

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



        vBox.getChildren().addAll(UserName,usernameField,Password,passwordField,login,gotoRegister);
        mainView.getChildren().add(vBox);
        ((VBox) vBox).setSpacing(10);
        Scene s=new Scene(mainView);
        ((VBox) vBox).setAlignment(Pos.CENTER);
        vBox.setMinWidth(480);
        vBox.setMinHeight(270);
        mainView.getChildren().addAll(Type,imageView,About);
        imageView.setY(230);
        imageView.setX(5);

        Button registerStage=new Button("Register");
        registerStage.setOnAction(event->{
            RegisterStage stage2=new RegisterStage();

        });



        stage.setMinWidth(480);
        stage.setMaxWidth(480);
        stage.setMinHeight(310);
        stage.setMaxHeight(310);
        stage.setAlwaysOnTop(false);//always stay on top of all tabs
        stage.setScene(s);
        stage.setTitle("Game Project");

        stage.show();

        stage.show();






    }

    private boolean checkCredentials(String userName, String password) {
        String filename = "Pass";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("%%");
                if (parts.length == 2 && parts[0].equals(userName) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        return false;
    }
}





