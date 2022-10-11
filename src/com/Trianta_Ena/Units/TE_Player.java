package com.Trianta_Ena.Units;

import com.Trianta_Ena.Interfaces.Behaviors.TE_Player_Behavior;
import com.Trianta_Ena.Items.TE_Card;

import java.util.ArrayList;
import java.util.List;

public class TE_Player extends Player implements TE_Player_Behavior {

    private boolean isDealer;

    private List<TE_Card> handCardsWithoutAce;

    private List<TE_Card> handCardsWithAce;

    public TE_Player(String name) {
        super(name);
    }

    public TE_Player()
    {
        super();
        initCardLists();
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
    }

    public void initCardLists(){
        handCardsWithAce=new ArrayList<TE_Card>();
        handCardsWithoutAce=new ArrayList<TE_Card>();
    }

    public int getCurrHandCardCount(){
        return handCardsWithoutAce.size()+handCardsWithAce.size();
    }

    public int getCurrHandCardValue(){
        int val=0;
        for(int i=0;i<handCardsWithoutAce.size();i++)
        {
            val+= handCardsWithoutAce.get(i).getVal();
        }
        if(handCardsWithAce.size()==0)
        {
            return val;
        }else if(handCardsWithAce.size()==1){
            //ask player
        }
        else {
            val+=(handCardsWithAce.size()-1)*11+1;
        }

        //remember >31==bust
        return val;
    }
}
