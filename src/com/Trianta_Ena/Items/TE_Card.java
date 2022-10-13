package com.Trianta_Ena.Items;

import com.Trianta_Ena.Enums.TE_CardEnum;

public class TE_Card extends Card{
    private TE_CardEnum cardType;

    private int val;

    public TE_Card(TE_CardEnum t){
        super();
        cardType=t;
    }

    public int getVal() {
        //switch cardType
        return val;
    }

    public TE_CardEnum getCardType() {
        return cardType;
    }
}
