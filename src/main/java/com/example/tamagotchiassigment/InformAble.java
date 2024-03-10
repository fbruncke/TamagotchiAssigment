package com.example.tamagotchiassigment;

/**
 *
 * interface used to let the UI know when the feelings of the Tamagotchi changes
 */

public interface InformAble {
    void inform(String feeling);    //used with the state pattern design
    //void inform(Feeling mood);    //used with the enum design
}
