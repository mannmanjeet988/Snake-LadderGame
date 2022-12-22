module com.example.snakeandladdergame {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jfr;


    opens com.example.snakeandladdergame to javafx.fxml;
    exports com.example.snakeandladdergame;
}