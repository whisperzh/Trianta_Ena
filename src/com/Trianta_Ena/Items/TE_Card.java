package com.Trianta_Ena.Items;

import com.Trianta_Ena.Enums.TE_CardEnum;

import javax.swing.*;

public class TE_Card extends Card{
    private TE_CardEnum cardType;

    private int val;

    public TE_Card(TE_CardEnum t){
        super();
        cardType=t;
        switch (t)
        {
            case ACE:
                setVal(11);
                break;
            case TWO:
                setVal(2);
                break;
            case THREE:
                setVal(3);
                break;
            case FOUR:
                setVal(4);
                break;
            case FIVE:
                setVal(5);
                break;
            case SIX:
                setVal(6);
                break;
            case SEVEN:
                setVal(7);
                break;
            case EIGHT:
                setVal(8);
                break;
            case NINE:
                setVal(9);
                break;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                setVal(10);
                break;
            default:
                break;
        }
    }

    public int getVal() {
        //switch cardType
        return val;
    }

    public TE_CardEnum getCardType() {
        return cardType;
    }

    public void setVal(int val) {
        if(getCardType().equals(TE_CardEnum.ACE))
            this.val = val;
    }
}
