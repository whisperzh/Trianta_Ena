package com.Trianta_Ena;

import com.Trianta_Ena.Drivers.Driver;
import com.Trianta_Ena.Drivers.TE_Driver;

import java.util.Scanner;

public class GameSelect {
    private Driver gameDriver;

    private Scanner scanner;

    public GameSelect() {
        System.out.println("Hi there, Welcome to boardgame");
    }

    public void gameChoose(){
        System.out.println("Please choose your game.");
        System.out.println("Games");
        System.out.println("\t[1] Tic-tac-toe");
        System.out.println("\t[2] Order and Chaos");
        System.out.println("\t[3] Trianta Ena");

        int GameMode=getScanner().nextInt();
        while(GameMode!=1&&GameMode!=-1&&GameMode!=2&&GameMode!=3) {
            System.out.println("Your Input is Invalid, please input again.");
            GameMode = getScanner().nextInt();

        }
        System.out.println("Your Input: ["+Integer.toString(GameMode) +"]");
        if(GameMode==1)
        {
            return;
        }else if(GameMode==2)
        {
            return;
        }else if(GameMode==3)
        {
            gameDriver=new TE_Driver();
            gameDriver.play();
        }
    }
    public Scanner getScanner(){
        if(scanner==null)
            scanner=new Scanner(System.in);
        return scanner;
    }

    public void start() {
        //write something like driver.Play();
    }
}
