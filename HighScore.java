package com.example.solitairegame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;


public class HighScore extends Application {


    @Override
    public void start(Stage stage)  {


        Pane mainView=new Pane();
        Pane Vbox=new VBox(10);


        Image image1=new Image("D:\\my work\\my projects\\Solitaire_Project\\Background2.jpg");
        Background background = new Background(new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));



        String score="Your score is "+String.valueOf(Snake.getScore());
        Text Score=new Text(score);
        Score.setFont(new Font("sans serif ",23));
        Score.setFill(Color.rgb(0,10, 0));




        mainView.setBackground(background);


        Hyperlink About=new Hyperlink("About us");
        About.setLayoutX(380);
        About.setLayoutY(240);
        About.setTextFill(Paint.valueOf("black"));


        Button Back=new Button("Back");
        Back.setFont(new Font("ariel",15));
        Back.setOnAction(event->{
            ChooseMenu backToMenu=new ChooseMenu();
            try{
                backToMenu.start(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        mainView.getChildren().addAll(Back,Score);

        Back.setLayoutX(400);
        Back.setLayoutY(30);

        Score.setLayoutX(159);
        Score.setLayoutY(120);

        About.setVisited(false);
        About.setOnAction(event->{
            try{
                java.awt.Desktop.getDesktop().browse(URI.create("https://github.com/castero2castero"));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });



        mainView.getChildren().add(Vbox);
        ((VBox) Vbox).setSpacing(10);
        Scene s=new Scene(mainView);
        ((VBox) Vbox).setAlignment(Pos.CENTER);
        Vbox.setMinWidth(480);
        Vbox.setMinHeight(270);
        mainView.getChildren().add(About);


        stage.setMinWidth(480);
        stage.setMaxWidth(480);
        stage.setMinHeight(310);
        stage.setMaxHeight(310);
        stage.setAlwaysOnTop(false);//always stay on top of all tabs
        stage.setScene(s);
        stage.setTitle("Game Project");

        stage.show();


    }

}

