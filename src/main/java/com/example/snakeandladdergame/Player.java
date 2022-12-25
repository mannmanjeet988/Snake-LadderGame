package com.example.snakeandladdergame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player {
    private Circle coin;
    private String name;
    private int coinPosition;

    private static Board gameBoard = new Board();

    public Circle getCoin() {

        return coin;
    }

//    public String setName() {
//        this.name= name;
//
//    }

    public int getCoinPosition() {

        return coinPosition;
    }

    public Player(int tileSize, Color coinColor, String playerName){
        coinPosition=1;
        name=playerName;
        coin = new Circle(tileSize/2);
        coin.setFill(coinColor);
        coin.setTranslateX(20);
        coin.setTranslateY(380);
    }

    public void movePalyer(int diceValue){
        if(coinPosition + diceValue <=100){
            coinPosition+= diceValue;
            coin.setTranslateX(gameBoard.getXCordinate((coinPosition)));
            coin.setTranslateY(gameBoard.getYCordinate((coinPosition)));
        }
    }

}
