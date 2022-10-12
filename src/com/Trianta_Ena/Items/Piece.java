package com.Trianta_Ena.Items;

/**
 * Directly copied from assignment1
 */

public class Piece extends Item{
    private boolean isActivated;

    private char pieceType=' ';

    private int position;

    public int getDisplayIndex() {
        return displayIndex;
    }

    private int displayIndex;

    public Piece(int displayIndex){
        this.displayIndex=displayIndex;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public void activate(char teamPieceType) {
        isActivated=true;
        pieceType=teamPieceType;
    }

    public char getPieceType() {
        return pieceType;
    }

    public void setPieceType(char pieceType) {
        this.pieceType = pieceType;
    }

    public void reset(){
        setActivated(false);
        pieceType=' ';
    }
}
