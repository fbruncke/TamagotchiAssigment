package com.example.tamagotchiassigment;

/**
 * Used with the state pattern design and not the enum design
 */
public interface FeelingStateable {
    void change(Tamagotchi tg);

    String getState();
}
