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

    int lowerLine = tileSize * height;
    int diceValue;
   static Label rolledDiceValueLabel;
    static Button startGameButton;

    boolean firstPlayerTurn = true, secondPlayerTurn = false, gameStarted = false;



    Pane createContent() {

        Pane root = new Pane();
        root.setPrefSize(width*tileSize, height*tileSize+100);

        Player firstPlayer = new Player(tileSize, Color.BLACK, "SURBHI");
        Player secondPlayer = new Player(tileSize - 10, Color.BLUE, "MANJEET");

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Tile tile = new Tile(tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                root.getChildren().add(tile);
            }
        }
      //  root.getChildren().add(new Tile(tileSize));

        Button playerOneButton = new Button("Player One");
        playerOneButton.setTranslateX(20);
        playerOneButton.setTranslateY(lowerLine + 20);
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(firstPlayerTurn){
                        setDiceValue();
                        firstPlayer.movePlayer(diceValue);
                        if(firstPlayer.playerWon() != null){
                            rolledDiceValueLabel.setText(firstPlayer.playerWon());
                            firstPlayerTurn = true;
                            secondPlayerTurn = false;
                            gameStarted = false;
                            startGameButton.setDisable(false);
                            startGameButton.setText("START GAME");
//                            firstPlayer.fixFirstPosition();
//                            secondPlayer.fixFirstPosition();
                        }
                        firstPlayerTurn = false;
                        secondPlayerTurn = true;
                    }
                }
            }
        });

        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setTranslateX(250);
        playerTwoButton.setTranslateY(lowerLine + 20);
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(secondPlayerTurn){
                        setDiceValue();
                        secondPlayer.movePlayer(diceValue);
                        if(secondPlayer.playerWon() != null){
                            rolledDiceValueLabel.setText(secondPlayer.playerWon());
                            firstPlayerTurn = true;
                            secondPlayerTurn = false;
                            gameStarted = false;
                            startGameButton.setDisable(false);
                            startGameButton.setText("START GAME");
//                            firstPlayer.fixFirstPosition();
//                            secondPlayer.fixFirstPosition();
                        }
                        secondPlayerTurn = false;
                        firstPlayerTurn = true;

                    }
                }
            }
        });

        startGameButton = new Button("START");
        startGameButton.setTranslateX(130);
        startGameButton.setTranslateY(lowerLine + 50);
        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                firstPlayer.fixFirstPosition();
                secondPlayer.fixFirstPosition();
                gameStarted = true;
                startGameButton.setText("Ongoing Game");
                startGameButton.setDisable(true);
            }
        });

        rolledDiceValueLabel = new Label("Start the game");
        rolledDiceValueLabel.setTranslateY(lowerLine + 20);
        rolledDiceValueLabel.setTranslateX(150);

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

        root.getChildren().addAll(boardImage);
        root.getChildren().addAll(
                firstPlayer.getCoin(), secondPlayer.getCoin());
        root.getChildren().addAll( playerOneButton, playerTwoButton);
        root.getChildren().add(rolledDiceValueLabel);
        root.getChildren().add(startGameButton);
        //
        return root;
    }

    private void setDiceValue(){
        diceValue = (int)(Math.random()*6+1);
        rolledDiceValueLabel.setText("Dice Value : " + diceValue);
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