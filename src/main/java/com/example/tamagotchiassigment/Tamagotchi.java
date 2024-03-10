package com.example.tamagotchiassigment;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Definition of the Tamaghotchi
 */
public class Tamagotchi {

    //region Constants to define when the statemachine "feelings" should change. Also to avoid magic numbers
    public static final int HUNGRY_LIMIT = 6;
    public static final int HAPPY_LIMIT = 10;
    public static final int SICK_LIMIT = 20;
    private final int MAX_FOOD = 30;
    //endregion

    //region Instance variables
    private int food = 10;

    //Callback interface
    private InformAble info = null;

    //The timer object that will decrease the food with 1 each second
    private Timer timer = new Timer();

    //Statemachine ref, used with state pattern design
    FeelingStateable feelingState = null;

    //used with enum design
    //private Feeling currentFeeling = Feeling.HAPPY;
    //endregion

    //region getters/setters

    /**
     * used with state pattern design
     * the enum design could have something similar?
     * @param feelingState
     */
    public void setFeelingState(FeelingStateable feelingState) {
        this.feelingState = feelingState;
        info.inform(this.feelingState.getState());
    }

    public void setFood(int food) {
        //Max values of food is 30, if higher then ignore it
        if( food > MAX_FOOD )
            return;

        this.food = food;
        System.out.println("Food value:" + food);
        mood();
    }

    public int getFood() {
        return food;
    }
    //endregion

    /**
     * Overloaded constructor, setting the callback interface and starting a timer for decrementing the food
     * @param inform
     */
    public Tamagotchi(InformAble inform)
    {
        info = inform;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //The food instance variable may not be less then zero
                if(food>0)
                    setFood(getFood()-1);


            }
        },500,1000);

        //setFeelingState(new State()); // used with state pattern design
    }

    /**
     * Method that contains the statemachine or invokes the statemachine
     */
    private void mood()
    {

//hints for either
//used with state pattern design
//         feelingState.change(this);;

//used with enum design
//        if( this.currentFeeling == Feeling.HAPPY )
//        {
//            if(this.food > SICK_LIMIT)
//                setCurrentFeeling(Feeling.SiCK);
    }


}
