package com.Trianta_Ena.Boards;

import com.Trianta_Ena.Enums.TE_CardEnum;
import com.Trianta_Ena.Items.TE_Card;
import com.Trianta_Ena.Units.TE_Player;

import java.util.*;

/**
 * Inherits the Board class. Additional TE specific attributes and methods have been implemented in this class.
 */
public class TE_Board extends Board {
    private List<TE_Card> cards;

    private Random random;

    private int singleEnumCount=4;

    public TE_Board(int singleEnumCount) {
        this.singleEnumCount=singleEnumCount;
        if(cards==null)
            cards=new ArrayList<TE_Card>();
        initCardsPile();
        reshuffle();
    }

    public void reshuffle() {
        Collections.shuffle(cards);
    }

    public void deal2Player(TE_Player player,boolean faceDown) {
        //fetch a random card from the cards and give it to the player
        int index=getRandom().nextInt(cards.size());
        TE_Card card=cards.get(index);
        card.setFaceDown(faceDown);
        player.receiveHandCard(card);
        cards.remove(index);
    }

    @Override
    public void reset() {
        //super.reset();
        initCardsPile();
        reshuffle();
    }

    public Random getRandom(){
        if(random==null)
            random=new Random();
        return random;
    }

    public void initCardsPile(){
        cards.clear();
        for (var e : TE_CardEnum.values()) {
            for (int i = 0; i < singleEnumCount; i++) {
                cards.add(new TE_Card(e));
            }

        }
    }
}
