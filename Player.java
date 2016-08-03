/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.util.ArrayList;

/**
 *
 * @author athaliaho
 */
public class Player {
    
    String myName;
    private ArrayList<Card> myCards; 
    private boolean isMyTurn = false;
    private boolean saidUNO = false;
    
    public Player(String name) {
        myName = name;
        myCards = new ArrayList<Card>();            
    }
    
    
    
    public String getName() {
        return myName;
    }

    public ArrayList<Card> getMyCards() {
        return myCards;
    }

    public void setName(String name) {
        this.myName = name;
    }

    public void setMyCards(ArrayList<Card> myCards) {
        this.myCards = myCards;
    }
    
    public void clearCards() {
        myCards.clear();
    }
    
    public void gainCard(Card card) {
        myCards.add(card);
    }
    
    public Card playCard(Card pileCard) {
        
        // play the first playable card we can find
        for (Card c : myCards) {
            if (c.canPlay(pileCard)) 
            {
                myCards.remove(c);
                
                return c;
            }
            
        }
        return null;
    }
    public String toString() {
        return myName;
}
	
	public void toggleTurn(){
		isMyTurn = (isMyTurn) ? false : true;
	}
	
	public boolean isMyTurn(){
		return isMyTurn;
	}
	
	public boolean hasCards(){
		return (myCards.isEmpty()) ? false : true;
	}
	
	public boolean getSaidUNO(){
		return saidUNO;
	}
	
	public void saysUNO(){
		saidUNO = true;
	}
	
	public void setSaidUNOFalse(){
		saidUNO = false;
	}
    
}
