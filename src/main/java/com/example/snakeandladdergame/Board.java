package com.example.snakeandladdergame;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pair<Integer, Integer>> positionCordinates;
    private ArrayList<Integer> snakeLadderPosition;

    public Board() {
        populatePositionCordinates();
        populateSnakeLadderPosition();
    }

    private void populatePositionCordinates() {
        positionCordinates = new ArrayList<>();
        positionCordinates.add(new Pair<Integer, Integer>(0, 0));


        int x = 1, y = 10, xPos, yPos;
        for (int i = 0; i < SnakeLadder.height; i++) {
            x = 1;
            for (int j = 0; j < SnakeLadder.width; j++) {
                if (y%2 == 0) {
                    xPos = x*SnakeLadder.tileSize - SnakeLadder.tileSize/2;
                }
                else {
                    xPos = SnakeLadder.width*SnakeLadder.tileSize - (x*SnakeLadder.tileSize - SnakeLadder.tileSize/2);
                }
                yPos = y*SnakeLadder.tileSize - SnakeLadder.tileSize/2;
                positionCordinates.add(new Pair<Integer, Integer>(xPos, yPos));
                x++;
            }
            y--;
        }
    }

    private void populateSnakeLadderPosition() {
        snakeLadderPosition = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeLadderPosition.add(i);
        }
        snakeLadderPosition.set(4, 25);
        snakeLadderPosition.set(13, 46);
        snakeLadderPosition.set(27, 5);
        snakeLadderPosition.set(33, 49);
        snakeLadderPosition.set(40, 3);
        snakeLadderPosition.set(42, 63);
        snakeLadderPosition.set(43, 18);
        snakeLadderPosition.set(50, 69);
        snakeLadderPosition.set(54, 31);
        snakeLadderPosition.set(62, 81);
        snakeLadderPosition.set(66, 45);
        snakeLadderPosition.set(76, 58);
        snakeLadderPosition.set(74, 92);
        snakeLadderPosition.set(89, 53);
        snakeLadderPosition.set(99, 41);
    }

//        public static void main (String[]args){
//            Board board = new Board();
//            board.populatePositionCordinates();
//    for(int i =0; i< board.positionCordinates.size();i++){
//        System.out.println(i+ " #x:" + board.positionCordinates.get(i).getKey() +
//                " y: " + board.positionCordinates.get(i).getValue());
//    }
//        }

    public int getXCordinate(int position) {
        return positionCordinates.get(position).getKey();
    }

    public int getYCordinate(int position) {
        return positionCordinates.get(position).getValue();
    }

    public int getNextPosition(int position) {
        if(position >= 1 && position<=100)
       return snakeLadderPosition.get(position);
        else
            return -1;
    }
}
