package com.example.solitairegame;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;


public class LoadingScreen extends Screen {



    @Override
    public void start(Stage stage)  {


        Pane mainView=new Pane();
        Pane Vbox=new VBox(10);


        Image image1=new Image("D:\\my work\\my projects\\Solitaire_Project\\Background2.jpg");
        Background background = new Background(new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));


        ProgressBar progress=new ProgressBar();

        ImageView imageView = new ImageView("D:\\my work\\my projects\\Solitaire_Project\\Icon.png");

        mainView.setBackground(background);

        Text Welcome =new Text("Game Center");
        Welcome.setFont(new Font("ariel",22));
        Welcome.setFill(Color.rgb( 235,156, 92));

        Button next=new Button("Start");
        Hyperlink About=new Hyperlink("About us");
        About.setLayoutX(380);
        About.setLayoutY(240);
        About.setTextFill(Paint.valueOf("black"));


        next.setOnAction(actionEvent -> {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(2000); // Sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> {
                    LoginStage nextPage = new LoginStage();
                    try {
                        nextPage.start(new Stage());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            });
            thread.start();
        });

        About.setVisited(false);
        About.setOnAction(event->{
                try{
                    java.awt.Desktop.getDesktop().browse(URI.create("https://github.com/castero2castero"));

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        });



        Vbox.getChildren().addAll(Welcome,progress,next);
        mainView.getChildren().add(Vbox);
        ((VBox) Vbox).setSpacing(10);
        Scene s=new Scene(mainView);
        ((VBox) Vbox).setAlignment(Pos.CENTER);
        Vbox.setMinWidth(480);
        Vbox.setMinHeight(270);
        mainView.getChildren().add(imageView);
        mainView.getChildren().add(About);
        imageView.setY(230);
        imageView.setX(5);




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
