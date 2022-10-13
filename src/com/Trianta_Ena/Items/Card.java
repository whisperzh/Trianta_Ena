package com.Trianta_Ena.Items;

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
