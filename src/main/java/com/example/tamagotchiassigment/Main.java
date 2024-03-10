package com.example.tamagotchiassigment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Main extends Application implements  InformAble {

    //Instance variables, so the instances can be accessed from all instance variables
    Tamagotchi tg = null;
    TextField tfMood = null;

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gp = new GridPane();
        ColumnConstraints cc1 = new ColumnConstraints(100);
        ColumnConstraints cc2 = new ColumnConstraints(100);
        ColumnConstraints cc3 = new ColumnConstraints(100);

        RowConstraints rc1 = new RowConstraints(100);
        RowConstraints rc2 = new RowConstraints(100);
        RowConstraints rc3 = new RowConstraints(100);

        gp.getColumnConstraints().addAll(cc1,cc2,cc3);
        gp.getRowConstraints().addAll(rc1,rc2,rc3);

        Scene scene = new Scene(gp,600,600);

        tfMood = new TextField();
        tfMood.setMinWidth(300);
        gp.add(tfMood,0,0,3,1);

        //Instantiate a Tamagotchi object and give it a reference to the inform method, see interface informable
        tg = new Tamagotchi(this);

        //button to increment food of the tamagotchi
        Button btnFeed = new Button("Feed");
        gp.add(btnFeed,0,2);
        btnFeed.setOnAction((event)->tg.setFood(tg.getFood()+1));

        primaryStage.setTitle("Tamagotchi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * This method is defined in the inforamble interface and is used by the Tamagotchi to tell that its state Feeling has changed
     * used with the state pattern design
     */
    @Override
    public void inform(String feeling) {

        tfMood.setText(feeling);
    }

//      used with the enum design
//    @Override
//    public void inform(Feeling mood) {
//
//        tfMood.setText(mood.toString());
//    }
}
