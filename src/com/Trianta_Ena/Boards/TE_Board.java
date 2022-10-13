package com.Trianta_Ena.Boards;

import com.Trianta_Ena.Enums.TE_CardEnum;
import com.Trianta_Ena.Items.TE_Card;
import com.Trianta_Ena.Units.TE_Player;

import java.security.cert.TrustAnchor;
import java.util.*;

public class TE_Board extends Board {
    private List<TE_Card> cards;

    private Random random;

    public TE_Board(int singleEnumCount) {
        cards=new ArrayList<TE_Card>();
        for (var e : TE_CardEnum.values()) {
            for (int i = 0; i < singleEnumCount; i++) {
                cards.add(new TE_Card(e));
            }

        }
        reshuffle();
    }

    public void reshuffle() {
        Collections.shuffle(cards);
    }

    public void deal2Player(TE_Player player,boolean faceDown) {
        //fetch a random card from the cards and give it to the player
        int index=getRandom().nextInt(104);
        TE_Card card=cards.get(index);
        card.setFaceDown(faceDown);
        player.receiveHandCard(card);
        cards.remove(index);
    }

    @Override
    public boolean isValidMove(int input) {
        return true;
    }

    @Override
    public void reset() {
        super.reset();
    }

    public Random getRandom(){
        if(random==null)
            random=new Random();
        return random;
    }
}
