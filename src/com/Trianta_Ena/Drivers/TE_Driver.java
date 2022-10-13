package com.Trianta_Ena.Drivers;

import com.Trianta_Ena.Boards.Board;
import com.Trianta_Ena.Boards.TE_Board;
import com.Trianta_Ena.Units.TE_Player;

import java.util.*;

public class TE_Driver extends Driver{

    private List<TE_Player> gameOutSeat;

    private TE_Player currDealer;

    private final int singleEnumCount=8;

    private final int normalPlayerStartCash=100;

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
        initPlayersCach();
        while(true)//rounds
        {
            //bet or fold
            TE_Board board=(TE_Board)getBoard();
            for(int i=0;i<getUnitsQueue().size();i++){
                TE_Player p=(TE_Player)getUnitsQueue().get(i);
                setCurr_Player(p);
                //do something
                board.deal2Player(p,p.getIsDealer());
                setCurr_Player(null);
            }//assign cards

            for(int i=0;i<getUnitsQueue().size();i++){
                TE_Player p=(TE_Player)getUnitsQueue().get(i);
                setCurr_Player(p);
                p.setActiveInRound(true);
                p.bet();//do bet
                if(p.isActiveInRound()&&!p.getIsDealer())
                {
                    board.deal2Player(p,false);
                    board.deal2Player(p,false);
                }
                setCurr_Player(null);
            }



            //hit or stand
            while(getActivePlayerCount()!=0){
                for(int i=0;i<getUnitsQueue().size();i++){
                    TE_Player p=(TE_Player)getUnitsQueue().get(i);
                    setCurr_Player(p);
                    if(p.isActiveInRound())
                        p.hit();
                    setCurr_Player(null);
                }
                break;//need to be delete
            }

            if(judge())
            {
                checkOut();
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
        for(int i=0;i<getUnitsQueue().size();i++) {
            TE_Player p=(TE_Player)getUnitsQueue().get(i);
            p.roundCheckout();
        }
    }

    @Override
    public boolean judge() {
        for(int i=0;i<getUnitsQueue().size();i++) {
            TE_Player p=(TE_Player)getUnitsQueue().get(i);
            int val=p.getCurrHandCardValue();
            if (val>31)
            {
                if(gameOutSeat==null)
                    gameOutSeat=new ArrayList<TE_Player>();
                gameOutSeat.add(p);
            }else
            {
                //do win
            }
        }
        return getUnitsQueue().size()==1;
        //NEED TO BE FILLED
    }

    @Override
    public void instantiateGame() {
        //NEED TO BE FILLED
        initBoard();
        initGame();
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

    public void initPlayersCach(){
        for(int i=0;i<getUnitsQueue().size();i++)
        {
            TE_Player p=(TE_Player)getUnitsQueue().get(i);
            if(p.getIsDealer())
                p.setCash_held(3*normalPlayerStartCash);
            else
                p.setCash_held(normalPlayerStartCash);
        }
    }

}
