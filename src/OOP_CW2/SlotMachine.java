/**
 * Created by Suwadith on 12/9/2016.
 */

package OOP_CW2;

import java.util.*;

public class SlotMachine {

    private int remCredit = 10;
    private int currentBet = 0;

    //A reel array which would hold 3 reels
    private Reel[] reel = new Reel[3];

    //Makes sure when this constructor is loaded 3 new reels
    public SlotMachine() {
        for(int x = 0 ; x < 3 ; x++) {
            reel[x] = new Reel();
        }
    }

    public int getRemCredit() {
        return remCredit;
    }

    public void setRemCredit(int remCredit) {
        this.remCredit = remCredit;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    //Returns the appropriate reel according to it's No, and spins it
    public ArrayList<Symbol> getReel(int reelNo) {
        return reel[reelNo].spin();
    }

    public void addCoin(){
        remCredit+=1;
    }

    public void betOne(){
        if(remCredit>0){
            currentBet+=1;
            remCredit-=1;
        }else{
            throw new RuntimeException("Not enough Credits");
        }
    }

    public void betMax(){
        if(remCredit>2){
           currentBet+=3;
            remCredit-=3;
        }else{
            throw new RuntimeException("Not enough Credits");
        }
    }


}

