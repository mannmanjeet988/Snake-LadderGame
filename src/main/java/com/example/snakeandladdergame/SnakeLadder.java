package com.example.snakeandladdergame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SnakeLadder extends Application {

    public static final int tileSize=40, height = 10, width = 10;

    Pane createContent() {
        Pane root = new Pane();
        root.setPrefSize(width * tileSize, height * tileSize + 50);
         int diceValue;

        int lowerLine = tileSize * height;
        private void  getDiceValue(){
            diceValue = (int)(Math.random()*6+1);
            rolledDiceValueLabel.setText("Dice Value : " + diceValue);
        }

        Player firstPlayer = new Player(tileSize, Color.BLACK, "Amit");
        Player secondPlayer = new Player(tileSize - 10, Color.WHITE, "Sumit");

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Tile tile = new Tile(tileSize);
                tile.setTranslateX(j * tileSize);
                tile.setTranslateY(i * tileSize);
                root.getChildren().add(tile);
            }
        }
        root.getChildren().add(new Tile(tileSize));

        Button playerOneButton = new Button("Player One");
        playerOneButton.setTranslateX(20);
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                firstPlayer.movePalyer(diceValue);
            }
        });


        playerOneButton.setTranslateY(lowerLine + 20);
        Button playerTwoButton = new Button("Player Two");


        playerTwoButton.setTranslateX(250);
        playerTwoButton.setTranslateY(lowerLine + 20);

        Label rolledDicevalueLabel = new Label("Start the game");
        rolledDicevalueLabel.setTranslateY(lowerLine + 20);

//        Image img=new Image(newFileInputStream("I:\\SnakeAndLadderGame\\src\\main\\resources\\SnakeLadderBoard12Nov.jpg"));
//        ImageView boardImage = new ImageView();
//        boardImage.setImage(img);
//        root.getChildren().add(boardImage);

        InputStream stream1 = null;
        try {
            stream1 = new FileInputStream("I:\\SnakeAndLadderGame\\src\\main\\resources\\SnakeLadderBoard12Nov.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Image image = new Image(stream1);
        ImageView boardImage = new ImageView();

        boardImage.setImage(image);
        boardImage.setFitWidth(tileSize * width);
        boardImage.setFitHeight(tileSize * height);

        root.getChildren().addAll(boardImage, playerOneButton, playerTwoButton, firstPlayer.getCoin(), secondPlayer.getCoin());
        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {
       // FXMLLoader fxmlLoader = new FXMLLoader(SnakeLadder.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("SNAKE & LADDER GAME!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}