package com.Trianta_Ena.Items;

/**
 * Child of the Item class.
 * The class entails the attributes and methods corresponding to a card in a standard 52-card deck.
 * The class can be inherited to add functionality based on the game in which the cards are used.
 */
public class Card extends Item{

    public Card() {
        this.faceDown = false;
    }

    private boolean faceDown;

    public void reveal(){}

    public boolean isFaceDown() {
        return faceDown;
    }

    public void setFaceDown(boolean faceDown) {
        this.faceDown = faceDown;
    }
}
