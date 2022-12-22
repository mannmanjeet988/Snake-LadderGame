package com.example.snakeandladdergame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;




public class SnakeLadder extends Application {

    public static final int tileSize=40, height = 10, width = 10;

    Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+50);

        int lowerLine=tileSize*height;

        Player firstPlayer = new Player(tileSize, Color.BLACK, "Amit");
        Player secondPlayer = new Player(tileSize-10, Color.WHITE, "Sumit");


        for(int i=0; i < width;i++){
            for(int j=0; j < height;j++){
                Tile tile= new Tile(tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                root.getChildren().add(tile);
            }
        }
        root.getChildren().add(new Tile(tileSize));

        Button playerOneButton= new Button("Player One");playerOneButton.setTranslateX(20);
        playerOneButton.setTranslateY(lowerLine+20);
        Button playerTwoButton= new Button("Player Two");

        playerTwoButton.setTranslateX(250);
        playerTwoButton.setTranslateY(lowerLine+20);
        root.getChildren().addAll(playerOneButton,playerTwoButton,firstPlayer.getCoin(),secondPlayer.getCoin());

       // Image img=new Image(newFileInputStream(path));
//        Image img=new Image(newFileInputStream("I:\\SnakeAndLadderGame\\src\\main\\resources\\SnakeLadderBoard12Nov.jpg"));
//        ImageView boardImage = new ImageView();
//        boardImage.setImage(img);
//        boardImage.setFitWidth(tileSize*width);
//        boardImage.setFitHeight(tileSize*height);
//        root.getChildren().add(boardImage);
        return root;
    }

//    private String newFileInputStream(String s) {
//        String path= "I:\\SnakeAndLadderGame\\src\\main\\resources\\SnakeLadderBoard12Nov.jpg";
//        return path;
//    }

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