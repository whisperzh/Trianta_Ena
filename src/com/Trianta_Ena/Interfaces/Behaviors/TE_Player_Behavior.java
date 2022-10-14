package com.Trianta_Ena.Interfaces.Behaviors;

import com.Trianta_Ena.Units.TE_Player;

public interface TE_Player_Behavior extends Player_Behavior{
    void hit(); // The method cannot modify the object without passing the object as argument. So, it is better to implement this inside the hit method in TE_Player class. 

    boolean acceptSwitch2Dealer();
    void becomeDealer(TE_Player curr_dealer);
}
