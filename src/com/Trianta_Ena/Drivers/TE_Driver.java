package com.Trianta_Ena.Drivers;

import com.Trianta_Ena.Boards.TE_Board;
import com.Trianta_Ena.Units.TE_Player;

import java.util.*;

public class TE_Driver extends Driver{

    private List<TE_Player> gameOutSeat;

    private TE_Player currDealer;

    private final int singleEnumCount=8;

    private final int normalPlayerStartCash=100;

    private Map<Integer,Integer> playersBetAmount;

    private PriorityQueue<TE_Player> pq_Score;

    public TE_Driver() {
        System.out.println("Please enter the count of the players");
        System.out.println("Please enter a number between 5 and 9");
        setPlayerCount(getScanner().nextInt());
        System.out.println("Your input is "+getPlayerCount());
        initBoard();
        initGame();
    }

    public void rotateDealer(){
        initScorePq();
        while(pq_Score.size()!=0)
        {
            TE_Player p= pq_Score.poll();
            if(p.getIsDealer())
                return;
            if(p.acceptSwitch2Dealer()){
                p.becomeDealer(currDealer);
                currDealer=p;
                return;
            }
        }
    }


    @Override
    public void play() {
        initPlayersCash();
        while(true)//rounds
        {
            increaseRounds();
            //bet or fold
            TE_Board board=(TE_Board)getBoard();
            for(int i=0;i<getUnitsQueue().size();i++){
                TE_Player p=(TE_Player)getUnitsQueue().get(i);
                setCurr_Player(p);
                board.deal2Player(p,!p.getIsDealer());
                p.setActiveInRound(true);
                receivePlayerBetAmount(p);//do bet
                if(p.isActiveInRound()&&!p.getIsDealer())
                {
                    board.deal2Player(p,true);
                    board.deal2Player(p,true);
                }
                setCurr_Player(null);
            }

            //hit or stand
            while(getActivePlayerCount()!=0){
                for(int i=0;i<getUnitsQueue().size();i++){
                    TE_Player p=(TE_Player)getUnitsQueue().get(i);
                    setCurr_Player(p);
                    if(p.isActiveInRound()) {
                        // if the player chooses to hit, then board will deal a card and check for a bust
                        if(p.hit()) {
                            board.deal2Player(p,false); // deal a card
                            p.requestForAceValue();
                            //before you bust you may check the val to avoid that
                            p.bustCheckOut(); // check for bust
                        } 
                    }
                    setCurr_Player(null);
                }
            }

            //dealer's turn
            getCurrDealer().revealAllHandCards();

            while (getCurrDealer().getCurrHandCardValue()<27)
            {
                board.deal2Player(getCurrDealer(),false);
                getCurrDealer().requestForAceValue();
                getCurrDealer().bustCheckOut();
            }
            if(getCurrDealer().isActiveInRound()) {
                do {
                    boolean dealerHit = getCurrDealer().hit();
                    if(dealerHit&&getCurrDealer().isActiveInRound()) {
                        board.deal2Player(getCurrDealer(), false);
                        getCurrDealer().requestForAceValue();
                        getCurrDealer().bustCheckOut();
                    }
                    else
                        break;
                } while (getCurrDealer().isActiveInRound());
            }
            //dealer does chained hit
            checkOut();//related with money
            if(judge())//whether the game is over
            {
                printScoreTable();
                //user input
                System.out.println("Do you want to play again?(y/n)");
                String result=getScanner().next();
                if(result.equalsIgnoreCase("y")||result.equalsIgnoreCase("yes"))
                {
                    System.out.println("Input: yes");
                    //only reset part of the game,since the players want to continue;
                    //Team.getBoard().reset();
                }else
                {
                    System.out.println("Input: no");
                    break;
                }
            }else
                rotateDealer();
        }
        //if while breaks, the game is over
        System.out.println("Thank you for playing!");

        for(int i=0;i<getUnitsQueue().size();i++) {
            TE_Player p=(TE_Player)getUnitsQueue().get(i);
            System.out.println(p.getName() + " won " + p.getWinTimes() + " times.");
        }

    }

    public TE_Player getCurrDealer(){
        return currDealer;
    }

    private void initBoard(){
        setBoard(new TE_Board(singleEnumCount));
    }

    @Override
    public void checkOut() {
        //NEED TO BE FILLED
        int winnerCardValThreshold=getCurrDealer().getCurrHandCardValue();
        int roundNormalPlayerWinnerCount=0;
        for(int i=0;i<getUnitsQueue().size();i++) {
            TE_Player p = (TE_Player) getUnitsQueue().get(i);
            if (!p.getIsDealer()) {
                p.roundCheckout(winnerCardValThreshold);
                if(p.isRoundWin())
                {
                    roundNormalPlayerWinnerCount++;
                }
            }
        }
    }

    /**
     * whether the game is over
     * @return
     */
    @Override
    public boolean judge() {
        return getUnitsQueue().size()==1;
        //NEED TO BE FILLED
    }

    @Override
    public void reset() {
        //NEED TO BE FILLED
        getBoard().reset();

    }
    @Override
    public void initGame(){
        setUnitsQueue(new ArrayList<TE_Player>());
        currDealer=new TE_Player(true);
        getUnitsQueue().add(currDealer);
        pq_Score=new PriorityQueue<TE_Player>((a,b)->b.getCurrHandCardValue()-a.getCurrHandCardValue());
        gameOutSeat=new ArrayList<TE_Player>();
        addUnits(getPlayerCount()-1);
        playersBetAmount=new HashMap<Integer,Integer>();
    }

    public void receivePlayerBetAmount(TE_Player p){
        playersBetAmount.put(p.getInitId(),p.bet());
    }

    public int getActivePlayerCount(){
        int count=0;
        for(int i=0;i< getUnitsQueue().size();i++)
        {
            TE_Player p=(TE_Player) getUnitsQueue().get(i);
            if(p.isActiveInRound())
                count++;
        }
        return count;
    }

    @Override
    public void printScoreTable(){
        System.out.println("Team name\tScore\tRound");
//        for(Team t : teamQueue)
//        {
//            System.out.println(t.getName()+"\t"+t.getScore()+"\t"+rounds);
//        }
    }

    public void initScorePq(){
        pq_Score.clear();
        if(getCurr_Player()!=null)
            pq_Score.add((TE_Player) getCurr_Player());
        for(int i=0;i<getUnitsQueue().size();i++) {
            TE_Player p=(TE_Player) getUnitsQueue().get(i);
            pq_Score.add(p);
        }

    }

    @Override
    public void addUnits(int count) {
        for(int i=0;i<count;i++)
        {
            getUnitsQueue().add(new TE_Player());
        }
    }

    public void initPlayersCash(){
        for(int i=0;i<getUnitsQueue().size();i++)
        {
            TE_Player p=(TE_Player)getUnitsQueue().get(i);
            if(p.getIsDealer())
                p.setCashHeld(3*normalPlayerStartCash);
            else
                p.setCashHeld(normalPlayerStartCash);
        }
    }

}
