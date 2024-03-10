module com.example.tamagotchiassigment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tamagotchiassigment to javafx.fxml;
    exports com.example.tamagotchiassigment;
}