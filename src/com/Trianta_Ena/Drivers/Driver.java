package com.Trianta_Ena.Drivers;

import com.Trianta_Ena.Boards.Board;
import com.Trianta_Ena.Units.Player;
import com.Trianta_Ena.Units.Units;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Driver {
    private Scanner scanner;

    private boolean isTeamBased;

    private List unitsQueue;

    private int rounds;

    private int playerCount;

    private Player curr_Player;

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

    public static void setBoard(Board board) {
        Driver.board = board;
    }

    public void initUnitsList(){}

    public boolean getIsTeamBased() {
        return isTeamBased;
    }

    public void printScoreTable(){}

    public void addUnits(int count){

    }


    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public void setCurr_Player(Player curr_Player) {
        this.curr_Player = curr_Player;
    }

    public List getUnitsQueue() {
        return unitsQueue;
    }

    public void setUnitsQueue(List unitsQueue) {
        this.unitsQueue = unitsQueue;
    }
}
