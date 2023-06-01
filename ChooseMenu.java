package com.example.solitairegame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



import java.io.IOException;



public class ChooseMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Pane mainView=new Pane();
        Pane vBox=new VBox(10);
        ImageView imageView = new ImageView("D:\\my work\\my projects\\Solitaire_Project\\Icon.png");
        Image image1=new Image("D:\\my work\\my projects\\Solitaire_Project\\Background2.jpg");
        Background background = new Background(new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
        mainView.setBackground(background);




        Text hello = new Text("Welcome"+" "+LoginStage.getUserName());
        hello.setFont(new Font("comic sans ",23));
        hello.setFill(Color.rgb(235,156, 92));
        hello.setLayoutX(40);


        ImageView image =new ImageView(new Image("D:\\my work\\my projects\\Solitaire_Project\\High Scores.png"));
        image.setFitHeight(20);
        image.setFitWidth(20);

        Button HighScore=new Button();
        HighScore.setGraphic(image);
        HighScore.setOnAction(event->{

        });



        HBox box1=new HBox(hello);
        box1.setPadding(new Insets(34,10,34,10));
        box1.getChildren().addAll(HighScore);
        box1.setSpacing(260);



        ImageView snakeImage =new ImageView(new Image("D:\\my work\\my projects\\Solitaire_Project\\Snake game.jpeg"));
        snakeImage.setFitWidth(100);
        snakeImage.setFitHeight(100);

        Button snake =new Button();
        snake.setGraphic(snakeImage);
        snake.setOnAction(event->{
            Snake snakeGame=new Snake();
            try{
                Stage stage2=new Stage();
                snakeGame.start(stage2,stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


        ImageView solitaireImage =new ImageView(new Image("D:\\my work\\my projects\\Solitaire_Project\\SolitaireIcon.png"));
        solitaireImage.setFitWidth(100);
        solitaireImage.setFitHeight(100);
        solitaireImage.fitHeightProperty();
        solitaireImage.fitWidthProperty();


        Button Solitaire =new Button();
        Solitaire.setGraphic(solitaireImage);


        HBox box2=new HBox();
        box2.setPadding(new Insets(1,50,1,50));
        box2.setSpacing(30);
        box2.getChildren().addAll(snake,Solitaire);


        vBox.getChildren().addAll(box1, box2);




        mainView.getChildren().add(vBox);
        ((VBox) vBox).setSpacing(10);
        Scene s=new Scene(mainView);

        vBox.setMinWidth(480);
        vBox.setMinHeight(270);
        mainView.getChildren().add(imageView);
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