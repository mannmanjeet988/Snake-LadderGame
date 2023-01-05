package com.example.snakeandladdergame;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    private Circle coin;
    private String name;
    private int coinPosition;

    private static Board gameBoard = new Board();

    public void movePlayer(int diceValue){
        if( coinPosition + diceValue <= 100 ) {
            coinPosition += diceValue;
//            coin.setTranslateX(gameBoard.getXCordinate(coinPosition));
//            coin.setTranslateY(gameBoard.getYCordinate(coinPosition));
            translatePlayer();

            int newPosition = gameBoard.getNextPosition(coinPosition);
            if (newPosition != coinPosition) {
                coinPosition = newPosition;
                translatePlayer();
            }
        }
    }

    public String playerWon(){
        if(coinPosition==100){
            return name + " Won the Game";
        }
        return null;
    }

    public Circle getCoin() {
        return coin;
    }

    public void setName(String name) {
        this.name= name;
    }

    public int getCoinPosition() {
        return coinPosition;
    }

    private void translatePlayer(){
        TranslateTransition move = new TranslateTransition(Duration.millis(1000),this.coin);
        move.setToX(gameBoard.getXCoordinate(coinPosition));
        move.setToY(gameBoard.getYCoordinate(coinPosition));
        move.setAutoReverse(false);
        move.play();
    }

    public Player(int tileSize, Color coinColor, String playerName){
        coinPosition=1;
        name=playerName;
        coin = new Circle(tileSize/2);
        coin.setFill(coinColor);
        coin.setTranslateX(20);
        coin.setTranslateY(380);
    }

    public void fixFirstPosition(){
        coinPosition=1;
        coin.setTranslateX(20);
        coin.setTranslateY(380);
       movePlayer(0);
    }

}
