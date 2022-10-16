package com.Trianta_Ena;

/**
 * The class is the entry point to the game and contains the main() method.
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        GameSelect gs=new GameSelect();
        gs.gameChoose();
        gs.start();
    }
}
