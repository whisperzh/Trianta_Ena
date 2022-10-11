package com.Trianta_Ena.Units;

import com.Trianta_Ena.Interfaces.Behaviors.TE_Player_Behavior;
import com.Trianta_Ena.Items.TE_Card;

import java.util.List;

public class TE_Player extends Player implements TE_Player_Behavior {

    private boolean isDealer;

    private List<TE_Card> handCards;

    public TE_Player(String name) {
        super(name);
    }

    @Override
    public void roundCheckout() {

    }

    @Override
    public void hit() {

    }

    @Override
    public void stand() {

    }

    @Override
    public void bet(int amount) {

    }

    @Override
    public boolean acceptSwitch2Dealer() {
        return false;
    }

    @Override
    public void becomeDealer(TE_Player curr_dealer) {

    }

    @Override
    public void takeAction() {
        super.takeAction();
    }

    @Override
    public void reset() {
        super.reset();
    }
}
