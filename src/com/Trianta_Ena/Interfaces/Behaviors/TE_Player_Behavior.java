package com.Trianta_Ena.Interfaces.Behaviors;

import com.Trianta_Ena.Units.TE_Player;

public interface TE_Player_Behavior extends Player_Behavior{
    void hit();
    boolean acceptSwitch2Dealer();
    void becomeDealer(TE_Player curr_dealer);
}
