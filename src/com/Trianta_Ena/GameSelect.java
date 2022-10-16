package com.Trianta_Ena;

import com.Trianta_Ena.Drivers.Driver;
import com.Trianta_Ena.Drivers.TE_Driver;

import java.util.Scanner;

/**
 * The class is responsible for displaying the menu of available games and present rules for the selected game.
 */

public class GameSelect {
    private Driver gameDriver;

    private Scanner scanner;

    public GameSelect() {
        System.out.println("=======================================================\n");
        System.out.println(">>>=== Hi there! Welcome to the boardgames arena ===<<<\n");
        System.out.println("=======================================================\n");
    }

    /**
     * choose a game
     */
    public void gameChoose(){
        System.out.println("\n>>>=== Please choose the game to start playing ===<<<\n");
        System.out.println("Games");
        System.out.println("\t[1] Tic-tac-toe (not available at the moment)");
        System.out.println("\t[2] Order and Chaos (not available at the moment)");
        System.out.println("\t[3] Trianta Ena");

        int GameMode=getScanner().nextInt();
        while(GameMode!=1&&GameMode!=-1&&GameMode!=2&&GameMode!=3) {
            System.out.println("=== Your Input is Invalid, please input again. ===");
            GameMode = getScanner().nextInt();

        }
        System.out.println("Your Input: ["+Integer.toString(GameMode) +"]\n");
        if(GameMode==1)
        {
            return;
        }else if(GameMode==2)
        {
            return;
        }else if(GameMode==3)
        {
            System.out.println("\nStarting Trianta Ena! Please note the following.\n");
            System.out.println();
            System.out.println("\t1. At the start of the game, Player 1 will always be the dealer. When the round ends, dealer can be changed.");
            System.out.println();
            gameDriver=new TE_Driver();
        }
    }
    public Scanner getScanner(){
        if(scanner==null)
            scanner=new Scanner(System.in);
        return scanner;
    }

    public void start() {
        if(gameDriver!=null)
            gameDriver.play();
    }
}
