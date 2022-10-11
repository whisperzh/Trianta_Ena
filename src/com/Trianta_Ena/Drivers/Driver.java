package com.Trianta_Ena.Drivers;

import com.Trianta_Ena.Boards.Board;
import com.Trianta_Ena.Units.Player;
import com.Trianta_Ena.Units.Units;

import java.util.Queue;
import java.util.Scanner;

public class Driver {
    private Scanner scanner;

    private boolean isTeamBased;

    protected Queue unitsQueue;

    private int rounds;

    protected Player curr_Player;

    private static Board board;

    public Driver() {

    }

    public void play(){}

    //whether the game ends
    public boolean judge(){
        return false;
    }

    public void instantiateGame(){}

    public void reset(){}

    public Scanner getScanner(){
        if(scanner==null)
            scanner=new Scanner(System.in);
        return scanner;
    }

    public void checkOut() {
    }

    public int getRounds() {
        return rounds;
    }

    public void increaseRounds() {
        this.rounds++;
    }

    public Player getCurr_Player() {
        return curr_Player;
    }

    public static Board getBoard() {
        return board;
    }

    public void initUnitQueue(){}

    public boolean getIsTeamBased() {
        return isTeamBased;
    }

    public void printScoreTable(){}


}
