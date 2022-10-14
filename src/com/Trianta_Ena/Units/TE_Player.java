package com.Trianta_Ena.Units;

import com.Trianta_Ena.Enums.TE_CardEnum;
import com.Trianta_Ena.Interfaces.Behaviors.TE_Player_Behavior;
import com.Trianta_Ena.Items.TE_Card;

import java.util.ArrayList;
import java.util.List;

public class TE_Player extends Player implements TE_Player_Behavior {

    private boolean isDealer;//

    private int cashHeld;

    private boolean isActiveInRound;

    private boolean roundWin=false;

    private Hand hand;

    public TE_Player(String name) {
        super(name);
    }

    public TE_Player()
    {
        super();
        setActiveInRound(true);
        hand=new Hand();
    }

    public TE_Player(boolean isDealer)
    {
        super();
        this.isDealer=isDealer;
        if(isDealer)
            System.out.println("you are the dealer!");
        hand=new Hand();
        setActiveInRound(true);
    }

    @Override
    public void roundCheckout() {// have to sum up the money that the player may get,
        //because the money is prepaid to the game

    }
    public void roundCheckout(int threshold){
        if(hand.getCardVal()>threshold)
        {
            setRoundWin(true);
        }
    }

    /**
     * check whether a player is bust
     */
    public void bustCheckOut(){ // Returns TRUE if the player is bust. Otherwise returns FALSE
        int handCardValue = hand.getCardVal();
        if(handCardValue > 31){
            System.out.println("\nYou have gone bust!\n");
            setActiveInRound(false);
        }
    }

    /**
     * whether the player hits or stands
     * @return the player's choice
     */
    @Override
    public boolean hit() {//hit or stand
        while(true) {
            System.out.println("hit or stand");
            System.out.println("Would you like to [h]it or [s]tand? \nEnter your choice 'h' or 's':");
            String hitOrStand = getScanner().next();

            if(hitOrStand.equals("h")) {
                return true;
            }else if(hitOrStand.equals("s")) {
                setActiveInRound(false); // The current player is inactive for the rest of the round
                return false; 
            }
            else {
                System.out.println("Please enter a valid option:");
                System.out.println("Available options are 'h' for bet and 's' for fold.\n");
            }
        }
    }

    /**
     *whether the player bets or folds
     */
    public int bet() {
        //bet or fold
        while(true) {
            System.out.println("bet or fold");
            System.out.println("Would you like to [b]et or [f]old? \nEnter your choice 'b' or 'f':");
            String betOrFold = getScanner().next();


            if(betOrFold.equals("b")) {
                // System.out.println("Your Input: "+betOrFold);
                System.out.println("Please enter the bet amount: ");

                try {
                    int betAmount = getScanner().nextInt();
                    setCashHeld(cashHeld-betAmount);
                    System.out.println("Your remaining cash: " + Integer.toString(cashHeld));
                    return betAmount;
                }
                catch(Exception e) {
                    System.out.println("Enter an INTEGER amount (Not a fraction amount)");
                }
            }
            else if(betOrFold.equals("f")) {
                // System.out.println("Your Input: "+betOrFold);
                setActiveInRound(false); // The current player is inactive for the rest of the round
                break;
            }
            else {
                System.out.println("Please enter a valid option:");
                System.out.println("Available options are 'b' for bet and 'f' for fold.\n");
            }
        }
        return 0;
    }

    /**
     * whether the player accepts to become a dealer
     * @return the player's choice
     */
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

    /**
     * suppose to be called every round
     */
    @Override
    public void takeAction() {
//        if(handCardsWithAce.size()==1)
//        {
//            requestForAceValue();
//        }
    }

    @Override
    public void reset() {
        setRoundWin(false);
        hand.resetHandCard();
    }


    public boolean getIsDealer() {
        return isDealer;
    }

    public void setDealer(boolean isDealer){
        this.isDealer=isDealer;
    }

    public int requestForAceValue()//need try catch block
    {
        int val=11;
        if(hand.getHandCardsWithAce().size()==1)
        {
            System.out.println("You got an ACE card");
            System.out.println("This card's value can either be 11 or 1");
            System.out.println("Please enter the value of this card(11/1)");
            val=getScanner().nextInt();
            hand.getHandCardsWithAce().get(0).setVal(val);
        }
        return val;
    }

    public int getCashHeld() {
        return cashHeld;
    }

    public void setCashHeld(int cashHeld) {
        this.cashHeld = cashHeld;
    }

    public boolean isActiveInRound() {
        return isActiveInRound;
    }



    public void setActiveInRound(boolean activeInRound) {
        isActiveInRound = activeInRound;
    }

    public boolean isRoundWin() {
        return roundWin;
    }

    public void setRoundWin(boolean roundWin) {
        setWinTimes(getWinTimes()+1);
        this.roundWin = roundWin;
    }



    /**
     * You cannot add zero or negative amount
     * @param amount cash amount
     */
    public void addCash(int amount){
        if(amount<=0)
        {
            return;
        }
        setCashHeld(getCashHeld()+amount);
    }

    /**
     * if this player cannot pay the required amount
     * this method return false
     * @param amount cash amount
     * @return the result of the transaction
     */
    public boolean reduceCash(int amount)
    {
        setCashHeld(getCashHeld()-amount);
        if(getCashHeld()<amount) {
            setCashHeld(0);
            return false;
        }
        return true;
    }

    /**
     * receive a card from board
     * @param card the parameters from board
     */
    public void receiveHandCard(TE_Card card){
        hand.getCard(card);
    }

    public Hand getHand() {
        return hand;
    }
    public int getCurrHandCardValue(){
        return hand.getCardVal();
    }

    public void revealAllHandCards(){
        getHand().exposeHandCards();
    }

    private class Hand{

        private List<TE_Card> handCardsWithoutAce;

        private List<TE_Card> handCardsWithAce;

        public Hand() {
            initCardLists();
        }

        public void getCard(TE_Card card){
            if(card.getCardType().equals(TE_CardEnum.ACE))
            {
                handCardsWithAce.add(card);
            }else
            {
                handCardsWithoutAce.add(card);
            }
        }
        public void initCardLists(){
            handCardsWithAce=new ArrayList<TE_Card>();
            handCardsWithoutAce=new ArrayList<TE_Card>();
        }

        /**
         * clear handcard LISTS
         */
        public void resetHandCard(){
            handCardsWithAce.clear();
            handCardsWithoutAce.clear();
        }

        public void exposeHandCards(){
            for (TE_Card card : handCardsWithoutAce) {
                card.reveal();
            }
            for (TE_Card card : handCardsWithAce) {
                card.reveal();
            }
        }
        public int getCurrHandCardCount(){
            return handCardsWithoutAce.size()+handCardsWithAce.size();
        }

        public int getCardVal(){
            int val=0;
            for(int i=0;i<handCardsWithoutAce.size();i++)
            {
                val+= handCardsWithoutAce.get(i).getVal();
            }
            for(int i=0;i<handCardsWithAce.size();i++)
            {
                val+=handCardsWithAce.get(i).getVal();
            }

            //remember >31==bust
            return val;
        }

        public List<TE_Card> getHandCardsWithoutAce() {
            return handCardsWithoutAce;
        }

        public List<TE_Card> getHandCardsWithAce() {
            return handCardsWithAce;
        }
}

}
