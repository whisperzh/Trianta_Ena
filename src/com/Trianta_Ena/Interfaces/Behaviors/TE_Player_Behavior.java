package com.Trianta_Ena.Interfaces.Behaviors;

import com.Trianta_Ena.Units.TE_Player;

/**
 *  Extends Player_Behavior interface. The interface provides methods that are common between a player and the banker (in our TE game there are 2 types of players, "Player" and "Banker").
 */
public interface TE_Player_Behavior extends Player_Behavior{
    boolean hit(); // The method cannot modify the object without passing the object as argument. So, it is better to implement this inside the hit method in TE_Player class. 

    boolean acceptSwitch2Dealer();
    void becomeDealer(TE_Player curr_dealer);
}
