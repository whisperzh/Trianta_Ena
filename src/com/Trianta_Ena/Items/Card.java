package com.Trianta_Ena.Items;

public class Card extends Item{
    private boolean faceDown;

    public void reveal(){}

    public boolean isFaceDown() {
        return faceDown;
    }

    public void setFaceDown(boolean faceDown) {
        this.faceDown = faceDown;
    }
}
