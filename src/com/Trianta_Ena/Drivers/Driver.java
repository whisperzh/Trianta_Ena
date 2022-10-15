package com.Trianta_Ena.Drivers;

import com.Trianta_Ena.Boards.Board;
import com.Trianta_Ena.Units.Player;

import java.util.List;
import java.util.Scanner;
@SuppressWarnings("unchecked")
public class Driver {
    private Scanner scanner;

    private boolean isTeamBased;

    private List unitsQueue; // raw type

    private int rounds;

    private int playerCount;

    private Player curr_Player;

    private static Board board;

    public Driver() {

    }

    /**
     * Store the main logic of the Game
     */
    public void play(){}

    /**
     * whether game is over
     * @return
     */
    public boolean judge(){
        return false;
    }

    /**
     * reset game
     */
    public void reset(){}

    /**
     * needed to be called when you need input
     * @return
     */
    public Scanner getScanner(){
        if(scanner==null)
            scanner=new Scanner(System.in);
        return scanner;
    }

    /**
     * do the checkout, usually would be called after the round ends or the game ends
     */
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

    /**
     * initiate game
     */
    public void initGame(){}

    public boolean getIsTeamBased() {
        return isTeamBased;
    }

    /**
     * print the total rounds and players' scores
     */
    public void printScoreTable(){}

    public void addUnits(int count){

    }

    public void instantiateGame(){}

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
