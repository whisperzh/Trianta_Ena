package com.Trianta_Ena.Drivers;

import com.Trianta_Ena.Units.TE_Player;

import java.util.Iterator;
import java.util.LinkedList;

public class TE_Driver extends Driver{
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
        }

    }

    @Override
    public void checkOut() {
        //NEED TO BE FILLED
    }

    @Override
    public boolean judge() {
        //NEED TO BE FILLED
        return super.judge();
    }

    @Override
    public void instantiateGame() {
        //NEED TO BE FILLED
        super.instantiateGame();
    }

    @Override
    public void reset() {
        //NEED TO BE FILLED
        super.reset();
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
}
