package com.example.snakeandladdergame;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pair<Integer, Integer>> positionCordinates;

    public Board(){
        populatePositionCordinates();
    }

    public void populatePositionCordinates() {


        int x = 1, y = 10, xPos, yPos;
        for (int i = 0; i < SnakeLadder.height; i++) {
            x = 1;
            for (int j = 0; j < SnakeLadder.width; j++) {
                if (y % 2 == 0)
                    xPos = x * SnakeLadder.tileSize - SnakeLadder.tileSize / 2;
                else {
                    xPos = SnakeLadder.width * SnakeLadder.height - (x * SnakeLadder.tileSize - SnakeLadder.tileSize / 2);
                }
                yPos = y * SnakeLadder.tileSize - SnakeLadder.tileSize / 2;
                positionCordinates.add(new Pair<Integer, Integer>(xPos, yPos));
                x++;
            }
            y--;
        }
    }


        public static void main (String[]args){
            Board board = new Board();
            board.populatePositionCordinates();

        }

        public int getXCordinate ( int position){
            return positionCordinates.get(position).getKey();
        }

        public int getYCordinate ( int position){
            return positionCordinates.get(position).getKey();
        }


    }
