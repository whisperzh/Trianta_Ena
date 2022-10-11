package com.Trianta_Ena.Drivers;

import com.Trianta_Ena.Boards.TE_Board;
import com.Trianta_Ena.Units.TE_Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TE_Driver extends Driver{

    private List<TE_Player> gameOutSeat;

    public TE_Driver() {
    }

    public void rotateDealer(){
        //NEED TO BE FILLED
    }

    @Override
    public void play() {
        while(true)
        {
            TE_Player p=(TE_Player)unitsQueue.poll();
            p.takeAction();
            unitsQueue.add(p);
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
            }
        }
        System.out.println("Thank you for playing!");

        for(int i=0;i<unitsQueue.size();i++) {
            TE_Player p=(TE_Player)unitsQueue.poll();
            System.out.println(p.getName() + " won " + p.getWinTimes() + " times.");
            unitsQueue.add(p);
        }

    }

    private void initBoard(){
        setBoard(new TE_Board());
    }

    @Override
    public void checkOut() {
        //NEED TO BE FILLED
        for(int i=0;i<unitsQueue.size();i++) {
            TE_Player p=(TE_Player)unitsQueue.poll();
            p.roundCheckout();
            unitsQueue.add(p);
        }
    }

    @Override
    public boolean judge() {
        for(int i=0;i<unitsQueue.size();i++) {
            TE_Player p=(TE_Player)unitsQueue.poll();
            int val=p.getCurrHandCardValue();
            if (val>31)
            {
                if(gameOutSeat==null)
                    gameOutSeat=new ArrayList<TE_Player>();
                gameOutSeat.add(p);
            }
            else
                unitsQueue.add(p);
        }
        return unitsQueue.size()==1;
        //NEED TO BE FILLED
    }

    @Override
    public void instantiateGame() {
        //NEED TO BE FILLED
        initBoard();
        initUnitQueue();
    }

    @Override
    public void reset() {
        //NEED TO BE FILLED
        getBoard().reset();

    }
    @Override
    public void initUnitQueue(){
        unitsQueue = new LinkedList<TE_Player>();
    }

    @Override
    public void printScoreTable(){
        System.out.println("Team name\tScore\tRound");
//        for(Team t : teamQueue)
//        {
//            System.out.println(t.getName()+"\t"+t.getScore()+"\t"+rounds);
//        }
    }

    @Override
    public void addUnits(int count) {
        for(int i=0;i<count;i++)
        {
            unitsQueue.add(new TE_Player());
        }
    }
}
