package com.Trianta_Ena.Units;

import com.Trianta_Ena.Utilities.Cache;

import java.util.Scanner;

/**
 * The class represents a player, one of the building blocks in any game.
 * A unit will be a team in a team-based game, it will be a player in an individual player-based game.
 */
@SuppressWarnings("unchecked")
public class Units {
    private String name;
    private boolean isWinner;
    private int winTimes;
    private Scanner scanner;

    protected final int initId;

    public Units() {
        initId= Cache.existingPlayerCount;
        Cache.increaseExistingPlayerCount();
    }

    public Units(String name) {
        initId= Cache.existingPlayerCount;
        Cache.increaseExistingPlayerCount();
        this.name=name;
    }

    public void takeAction(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void reset(){}

    public Scanner getScanner(){
        if(scanner==null)
            scanner=new Scanner(System.in);
        return scanner;
    }

    public int getWinTimes() {
        return winTimes;
    }

    public void setWinTimes(int winTimes) {
        this.winTimes = winTimes;
    }


    public int getInitId() {
        return initId;
    }

}

