package com.Trianta_Ena.Units;

import java.util.LinkedList;
import java.util.Queue;

public class Team extends Units{
    protected Queue playerQueue;
    private char teamPieceType;

    public Team(String name) {
        super(name);
        initPlayerQueue();
    }

    private void initPlayerQueue() {
        playerQueue=new LinkedList();
    }




}