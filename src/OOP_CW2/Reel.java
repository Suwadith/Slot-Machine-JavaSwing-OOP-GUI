/**
 * Created by Suwadith on 12/9/2016.
 */

package OOP_CW2;

import javax.swing.*;
import java.util.*;
import java.util.*;

public class Reel {

    //creates an ArrayList list of symbol objects
    private ArrayList<Symbol> symbol = new ArrayList<Symbol>();

    //Loads all the Symbols inside the Reel Constructor so that each reel can hold all those symbols
    public Reel()
    {
            Symbol bell = new Symbol();
            bell.setImage(new ImageIcon("src/OOP_CW2/bell.png", "Bell"));
            bell.setValue(6);
            symbol.add(bell);

            Symbol cherry = new Symbol();
            cherry.setImage(new ImageIcon("src/OOP_CW2/cherry.png", "Cherry"));
            cherry.setValue(2);
            symbol.add(cherry);

            Symbol lemon = new Symbol();
            lemon.setImage(new ImageIcon("src/OOP_CW2/lemon.png", "Lemon"));
            lemon.setValue(3);
            symbol.add(lemon);

            Symbol plum = new Symbol();
            plum.setImage(new ImageIcon("src/OOP_CW2/plum.png", "Plum"));
            plum.setValue(4);
            symbol.add(plum);

            Symbol redSeven = new Symbol();
            redSeven.setImage(new ImageIcon("src/OOP_CW2/redSeven.png", "Seven"));
            redSeven.setValue(7);
            symbol.add(redSeven);

            Symbol watermelon = new Symbol();
            watermelon.setImage(new ImageIcon("src/OOP_CW2/watermelon.png", "Watermelon"));
            watermelon.setValue(5);
            symbol.add(watermelon);

            //makes sure that each time a reel gets created it shuffles the order of the symbols in it.
            Collections.shuffle(symbol);
        }

    public void setSymbol(Symbol symbol) {
        if(symbol != null) {
            this.symbol.add(symbol);
        }
    }

    //when the spin method is invoked it will return the whole instance of a symbol ArrayList
    public ArrayList<Symbol> spin() {
        return symbol;
    }

}
