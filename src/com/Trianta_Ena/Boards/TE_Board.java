package com.Trianta_Ena.Boards;

import com.Trianta_Ena.Items.TE_Card;
import com.Trianta_Ena.Units.TE_Player;

import java.security.cert.TrustAnchor;
import java.util.List;

public class TE_Board extends Board{
    private List<TE_Card> cards;
    public TE_Board() {

    }

    public void reshuffle(){

    }

    public void deal2Player(TE_Player player){
    //fetch a random card from the cards and give it to the player
    }

    @Override
    public boolean isValidMove(int input) {
        return true;
    }

    @Override
    public void reset() {
        super.reset();
    }
}
