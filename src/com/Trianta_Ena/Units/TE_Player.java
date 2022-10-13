package com.Trianta_Ena.Units;

import com.Trianta_Ena.Enums.TE_CardEnum;
import com.Trianta_Ena.Interfaces.Behaviors.TE_Player_Behavior;
import com.Trianta_Ena.Items.TE_Card;

import java.util.ArrayList;
import java.util.List;

public class TE_Player extends Player implements TE_Player_Behavior {

    private boolean isDealer;//

    private List<TE_Card> handCardsWithoutAce;

    private List<TE_Card> handCardsWithAce;

    private int cash_held;

    private boolean isActiveInRound;

    public TE_Player(String name) {
        super(name);
    }

    public TE_Player()
    {
        super();
        initCardLists();
        setActiveInRound(true);

    }

    public TE_Player(boolean isDealer)
    {
        super();
        this.isDealer=isDealer;
        if(isDealer)
            System.out.println("you are the dealer!");
        initCardLists();
        setActiveInRound(true);
    }

    @Override
    public void roundCheckout() {

    }
    //check whether a player is bust
    public void bustCheckOut(){

    }

    @Override
    public void hit() {//hit or stand
        System.out.println("hit or stand");
        bustCheckOut();
    }

    /**
     *
     */
    public void bet() {
        //bet or fold
        System.out.println("bet or fold");
    }

    @Override
    public boolean acceptSwitch2Dealer() {
        System.out.println("Accept to be a dealer?(y/n)");
        String acc=getScanner().next();
        if(acc.equalsIgnoreCase("y")||acc.equalsIgnoreCase("yes"))
        {
            System.out.println("Your Input: Yes");
            return true;
        }
        System.out.println("Your Input: No");
        return false;
    }

    @Override
    public void becomeDealer(TE_Player curr_dealer) {
        isDealer=true;
        curr_dealer.setDealer(false);
    }

    @Override
    public void takeAction() {
        if(handCardsWithAce.size()==1)
        {
            requestForAceValue();
        }
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

    public boolean getIsDealer() {
        return isDealer;
    }

    public void setDealer(boolean isDealer){
        this.isDealer=isDealer;
    }

    public int requestForAceValue()//need try catch block
    {
        System.out.println("You got an ACE card");
        System.out.println("This card's value can either be 11 or 1");
        System.out.println("Please enter the value of this card(11/1)");
        int val=getScanner().nextInt();
        return val;
    }

    public int getCash_held() {
        return cash_held;
    }

    public void setCash_held(int cash_held) {
        this.cash_held = cash_held;
    }


    public boolean isActiveInRound() {
        return isActiveInRound;
    }

    public void receiveHandCard(TE_Card card){
        if(card.getCardType().equals(TE_CardEnum.ACE))
        {
            handCardsWithAce.add(card);
        }else
        {
            handCardsWithoutAce.add(card);
        }
    }

    public void revealAllCards(){
        for(int i=0;i<handCardsWithoutAce.size();i++)
        {
            handCardsWithoutAce.get(i).reveal();
        }
        for(int i=0;i<handCardsWithAce.size();i++)
        {
            handCardsWithAce.get(i).reveal();
        }
    }

    public void setActiveInRound(boolean activeInRound) {
        isActiveInRound = activeInRound;
    }
}
