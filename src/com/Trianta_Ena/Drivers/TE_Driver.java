package com.Trianta_Ena.Drivers;

import com.Trianta_Ena.Boards.TE_Board;
import com.Trianta_Ena.Units.TE_Player;

import java.util.*;
@SuppressWarnings("unchecked")
public class TE_Driver extends Driver{

    private List<TE_Player> gameOutSeat;

    private TE_Player currDealer;

    private final int singleEnumCount=8;

    private final int normalPlayerStartCash=100;

    private Map<Integer,Integer> playersBetAmount;

    private PriorityQueue<TE_Player> pq_Score;

    public TE_Driver() {
        System.out.println("Please enter the count of the players: \n");
        System.out.println("=== Please enter a number between 2 and 9 \n");
        int temp = 0;
        while(true){
            temp = getScanner().nextInt();
            if(temp < 2 || temp > 9){
                System.out.println("xxx Invalid input. Please enter an INTEGER between 2 and 9\n\n");
            }
            else{
                setPlayerCount(temp);
                break;
            }
        }
        
        System.out.println("Your input is "+getPlayerCount()+"\n");
        initBoard();
        initGame();
    }

    public void rotateDealer(){

        while(true)
        {
            initScorePq();
            TE_Player p= pq_Score.poll();
            if(p.getIsDealer())
                return;
            if(p.acceptSwitch2Dealer()&&p.getCurrHandCardValue()<=31){
                p.becomeDealer(currDealer);
                currDealer=p;
                return;
            }
        }
    }


    public void playerRoundWinReset()
    {
        for(int i=0;i<getUnitsQueue().size();i++) {
            TE_Player p = (TE_Player) getUnitsQueue().get(i);
            p.setRoundWin(false);
        }
    }

    @Override
    public void play() {
        initPlayersCash();
        while(true)//rounds
        {
            playerRoundWinReset();
            resetPlayersBetAmount();
            increaseRounds();
            //bet or fold
            TE_Board board=(TE_Board)getBoard();
            for(int i=0;i<getUnitsQueue().size();i++){
                TE_Player p=(TE_Player)getUnitsQueue().get(i);
                setCurr_Player(p);
                board.deal2Player(p,!p.getIsDealer());
                p.setActiveInRound(true);
                if(p.getIsDealer())
                    continue;
                receivePlayerBetAmount(p);//do bet
                if(p.isActiveInRound()&&!p.getIsDealer())
                {
                    board.deal2Player(p,true);
                    board.deal2Player(p,true);
                }
                setCurr_Player(null);
            }
            getCurrDealer().setActiveInRound(false);
            //hit or stand
            while(getActivePlayerCount()!=0){
                for(int i=0;i<getUnitsQueue().size();i++){
                    TE_Player p=(TE_Player)getUnitsQueue().get(i);
                    setCurr_Player(p);
                    if(p.isActiveInRound()&&!p.getIsDealer()) {
                        // if the player chooses to hit, then board will deal a card and check for a bust
                        if(p.hit()) {
                            board.deal2Player(p,false); // deal a card
                            p.requestForAceValue();
                            //before you bust you may check the val to avoid that
                            p.bustCheckOut(); // check for bust
                        } 
                    }
                    setCurr_Player(null);
                }
            }

            //dealer's turn
            getCurrDealer().revealAllHandCards();
            getCurrDealer().setActiveInRound(true);
            while (getCurrDealer().getCurrHandCardValue()<27)
            {
                // getCurrDealer().printHandCards();
                board.deal2Player(getCurrDealer(),false);
                getCurrDealer().requestForAceValue();
                getCurrDealer().bustCheckOut();
            }

            if(getCurrDealer().isActiveInRound()) {
                do {
                    boolean dealerHit = getCurrDealer().hit();
                    if(dealerHit&&getCurrDealer().isActiveInRound()) {
                        board.deal2Player(getCurrDealer(), false);
                        getCurrDealer().requestForAceValue();
                        getCurrDealer().bustCheckOut();
                    }
                    else
                        break;
                } while (getCurrDealer().isActiveInRound());
            }
            //dealer's turn over

            checkOut();//related with money
            board.initCardsPile();
            if(judge())//whether the game is over
            {
                printScoreTable();
                //user input
                System.out.println("=== Do you want to play again?(y/n) \n");
                String result=getScanner().next();
                if(result.equalsIgnoreCase("y")||result.equalsIgnoreCase("yes"))
                {
                    System.out.println("Input: yes\n");
                    //only reset part of the game,since the players want to continue;
                    //Team.getBoard().reset();
                }else
                {
                    System.out.println("Input: no\n");
                    break;
                }
            }else
                do{
                    rotateDealer();
                }
                while (!getCurrDealer().isAlive());

            for(int i=0;i<getUnitsQueue().size();i++) {
                TE_Player p=(TE_Player)getUnitsQueue().get(i);
                p.dropAllCards();
            }
        }
        //if while breaks, the game is over
        System.out.println("====================================\n");
        System.out.println(">>>=== Thank you for playing! ===<<< ");
        System.out.println("====================================\n");

        for(int i=0;i<getUnitsQueue().size();i++) {
            TE_Player p=(TE_Player)getUnitsQueue().get(i);
            System.out.println(p.getName() + " won " + p.getWinTimes() + " times.\n");
        }

    }

    public TE_Player getCurrDealer(){
        return currDealer;
    }

    private void initBoard(){
        setBoard(new TE_Board(singleEnumCount));
    }

    @Override
    public void checkOut() {
        //NEED TO BE FILLED
        int winnerCardValThreshold=getCurrDealer().getCurrHandCardValue();
        int roundNormalPlayerWinnerCount=0;
        if(getCurrDealer().isAlive()){
            for(int i=0;i<getUnitsQueue().size();i++) {
                TE_Player p = (TE_Player) getUnitsQueue().get(i);
                if (!p.getIsDealer()) {
                    p.roundCheckout(winnerCardValThreshold);
                    if(p.isRoundWin())
                    {
                        System.out.println("=== "+p.getName()+" win this round ===\n");
                        roundNormalPlayerWinnerCount++;
                    }
                }
            }
            if(roundNormalPlayerWinnerCount==0)
                getCurrDealer().setRoundWin(true);
        }else
        {
            for(int i=0;i<getUnitsQueue().size();i++) {
                TE_Player p = (TE_Player) getUnitsQueue().get(i);
                if (!p.getIsDealer()&&p.isAlive()) {
                    p.setRoundWin(true);
                    System.out.println("=== "+p.getName()+" win this round ===\n");
                    roundNormalPlayerWinnerCount++;

                }
            }
        }

        for(int i=0;i<getUnitsQueue().size();i++)
        {
            TE_Player p = (TE_Player) getUnitsQueue().get(i);
            if(p.isAlive()&&p.isRoundWin())
                assignBetWinReward(p);
        }
        if(!getCurrDealer().isAlive())
        {
            if(getUnitsQueue().contains(getCurrDealer()))
                getUnitsQueue().remove(getCurrDealer());
            if(!gameOutSeat.contains(getCurrDealer()))
                gameOutSeat.add(getCurrDealer());
        }
    }

    /**
     * whether the game is over
     * @return
     */
    @Override
    public boolean judge() {
        return getUnitsQueue().size()==1;
        //NEED TO BE FILLED
    }

    @Override
    public void reset() {
        //NEED TO BE FILLED
        getBoard().reset();

    }
    @Override
    public void initGame(){
        setUnitsQueue(new ArrayList<TE_Player>());
        currDealer=new TE_Player(true);
        getUnitsQueue().add(currDealer);
        pq_Score=new PriorityQueue<TE_Player>((a,b)->b.getCurrHandCardValue()-a.getCurrHandCardValue());
        gameOutSeat=new ArrayList<TE_Player>();
        addUnits(getPlayerCount()-1);
        playersBetAmount=new HashMap<Integer,Integer>();
    }

    public void receivePlayerBetAmount(TE_Player p){
        playersBetAmount.put(p.getInitId(),p.bet());
    }

    public int getActivePlayerCount(){
        int count=0;
        for(int i=0;i< getUnitsQueue().size();i++)
        {
            TE_Player p=(TE_Player) getUnitsQueue().get(i);
            if(p.isActiveInRound())
                count++;
        }
        return count;
    }

    @Override
    public void printScoreTable(){
        System.out.println("Team name\tScore\tRound");
    }

    public void initScorePq(){
        pq_Score.clear();
        if(getCurr_Player()!=null)
            pq_Score.add((TE_Player) getCurr_Player());
        for(int i=0;i<getUnitsQueue().size();i++) {
            TE_Player p=(TE_Player) getUnitsQueue().get(i);
            pq_Score.add(p);
        }

    }

    public void resetPlayersBetAmount(){
        playersBetAmount.clear();
    }

    @Override
    public void addUnits(int count) {
        for(int i=0;i<count;i++)
        {
            getUnitsQueue().add(new TE_Player());
        }
    }

    public void initPlayersCash(){
        for(int i=0;i<getUnitsQueue().size();i++)
        {
            TE_Player p=(TE_Player)getUnitsQueue().get(i);
            if(p.getIsDealer())
                p.setCashHeld(3*normalPlayerStartCash);
            else
                p.setCashHeld(normalPlayerStartCash);
        }
    }

    /**
     * assigning reward and at the same time update the dealer's money
     * @param p
     */
    public void assignBetWinReward(TE_Player p)
    {

        if(p.getIsDealer())
        {   //dealer wins

            for(int amount : playersBetAmount.values())
                p.addCash(amount);
            for(int i=0;i<getUnitsQueue().size();i++)
            {
                TE_Player player=(TE_Player) getUnitsQueue().get(i);
                if(!player.isAlive())
                {
                    getUnitsQueue().remove(i);
                    gameOutSeat.add(player);
                }
            }
        }
        else//not a dealer
        {
            int amount=playersBetAmount.get(p.getInitId());
            p.addCash(2*amount);
            boolean transactionSucceed=getCurrDealer().reduceCash(amount);
            if(!transactionSucceed&&!gameOutSeat.contains(getCurrDealer()))
            {
                getUnitsQueue().remove(getCurr_Player());//need to find a new dealer after the process
                gameOutSeat.add(getCurrDealer());
            }

        }
        System.out.println(p.getName()+"\'s remaining cash: "+p.getCashHeld()+"\n");

    }
}
