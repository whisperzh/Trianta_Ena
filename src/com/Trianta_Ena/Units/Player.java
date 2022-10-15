package com.Trianta_Ena.Units;

import com.Trianta_Ena.Utilities.Cache;

import java.util.Scanner;

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
        System.out.println("Please enter a player name");
        String name=s.next();
        System.out.println("Your input "+name);
        setName(name);
    }

    public boolean isAlive(){
        return false;
    }
}
