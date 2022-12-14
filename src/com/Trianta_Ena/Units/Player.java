package com.Trianta_Ena.Units;

import com.Trianta_Ena.Utilities.Cache;

import java.util.Scanner;

/**
 * Child of the Units class. Represents an individual player in any game.
 */
@SuppressWarnings("unchecked")
public class Player extends Units{
    public Player(){
        super();
        setNameFromConsole();
    }

    public Player(String name) {
        super(name);
    }

    public void setNameFromConsole(){
        Scanner s=getScanner();
        System.out.println("\n=== Please enter your name");
        String name=s.next();
        System.out.println("Your input "+name+"\n");
        setName(name);
    }

    public boolean isAlive(){
        return false;
    }
}
