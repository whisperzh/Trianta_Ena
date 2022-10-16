package com.Trianta_Ena.Units;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */

/**
 * Child of the Units class. Represents a team of players in any game.
 */
@SuppressWarnings("unchecked")
public class Team extends Units{
    private Queue playerQueue;
    private char teamPieceType;

    public Team(String name) {
        super(name);
        initPlayerQueue();
    }

    private void initPlayerQueue() {
        playerQueue=new LinkedList();
    }




}
