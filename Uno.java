
package uno;

import uno.Card.CardValue;
import uno.Card.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Uno {

    public class DeckMain {
    final private static int MAXCARDS  = 108;
    private List<Card> deck= new ArrayList<Card>();
    private List<Card>actionCard=new ArrayList<Card>();
    private List<Card>normalCard=new ArrayList<Card>();
       
    public List<Card> prepareDeck(){
         
        initCards();
        shuffleCards();
        return deck;
    }
     
     
 public List<Card> prepareDeckSpecial(){
         
        initActionCards();
        shuffleCards();
        return actionCard;
    }
  
 public List<Card> prepareDeckNormal(){
     
    initNormalCards();
    shuffleCards();
        return normalCard;
 }
     
    public void initCards(){
        for(Color color:Color.values()){
        for(int j=0; j<2;j++){
            for(CardValue cardValue:Card.CardValue.values()){
                 if(j==1 && cardValue.equals(CardValue.ZERO)||j==1 && (cardValue.equals(CardValue.WILD)||cardValue.equals(CardValue.WILD_FOUR))){
                    continue;    
                 }
                 else if (cardValue.equals(CardValue.WILD)||cardValue.equals(CardValue.WILD_FOUR)) {
                     deck.add(new Card(cardValue, null, cardType));
                }
                 else{
                     deck.add(new Card(cardValue, color, cardType));
                 }
                 
    public void initActionCards(){
        for(Color color:Color.values()){
        for(int j=0; j<2;j++){
            for(CardValue cardValue:Card.CardValue.values()){
                 if(j==1 && (cardValue.equals(CardValue.WILD)||cardValue.equals(CardValue.WILD_FOUR))){
                    continue;    
                 }
                 else if (cardValue.equals(CardValue.WILD)||cardValue.equals(CardValue.WILD_FOUR)) {
                     actionCard.add(new Card(cardValue, null, cardType));
                }
                 else if(cardValue.equals(CardValue.DRAW_TWO)||cardValue.equals(CardValue.REVERSE)||cardValue.equals(CardValue.SKIP))
                     actionCard.add(new Card(cardValue, color, cardType));
                 }
             
            }
         }
        }
         
    public void initNormalCards(){
        for(Color color:Color.values()){
        for(int j=0; j<2;j++){
            for(CardValue cardValue:Card.CardValue.values()){
                 if(j==1 && cardValue.equals(CardValue.ZERO)){
                    continue;    
                 }
                if (!(cardValue.equals(CardValue.WILD)||cardValue.equals(CardValue.WILD_FOUR)||cardValue.equals(CardValue.DRAW_TWO)||cardValue.equals(CardValue.SKIP)||cardValue.equals(CardValue.REVERSE))) {
                     normalCard.add(new Card(cardValue, color, cardType));
                 }
            }
        }
        }
             
    }
    
          
        }
    public boolean canPlay(List<Card> list1,Card card) {
 
    for (int i=0; i<list1.size(); i++)
        if (((Card)list1.get(i)).canPlay(card))
            return true;
             
    return false;
}
 
public boolean canPlay(Card card,Card otherCard) {
     
    if(card.canPlay(otherCard))
            return true;
             
         
    return false;
             
}
 
public boolean canPlayColor(List<Card> list1,Color otherCardColor) {
    for(Card tempCard :list1){
        if(tempCard.color.equals(otherCardColor)){
            return true;
        }
    }
    return false;
}
    public void shuffleCards(){
        Collections.shuffle(deck);
        Collections.shuffle(actionCard);
        Collections.shuffle(normalCard);
    }
public void testPlay() {
        // stack the deck

        // player 0's cards
        deck.add(card[Card.RED][2]);
        deck.add(card[Card.GREEN][2]);
        deck.add(card[Card.GREEN][3]);
        deck.add(card[Card.YELLOW][3]);
        deck.add(card[Card.YELLOW][8]);
        deck.add(card[Card.BLUE][3]);
        deck.add(card[Card.WILD][0]);

        // player 1's cards
        deck.add(card[Card.BLUE][2]);
        deck.add(card[Card.BLUE][4]);
        deck.add(card[Card.BLUE][5]);
        deck.add(card[Card.BLUE][6]);
        deck.add(card[Card.YELLOW][7]);
        deck.add(card[Card.GREEN][6]);
        deck.add(card[Card.RED][7]);
        
        // player 2's cards
        deck.add(card[Card.YELLOW][2]);
        deck.add(card[Card.YELLOW][4]);
        deck.add(card[Card.YELLOW][5]);
        deck.add(card[Card.YELLOW][6]);
        deck.add(card[Card.RED][7]);
        deck.add(card[Card.GREEN][6]);
        deck.add(card[Card.BLUE][7]);

        // player 3's cards
        deck.add(card[Card.YELLOW][9]);
        deck.add(card[Card.YELLOW][8]);
        deck.add(card[Card.GREEN][5]);
        deck.add(card[Card.BLUE][6]);
        deck.add(card[Card.RED][0]);
        deck.add(card[Card.GREEN][0]);
        deck.add(card[Card.BLUE][2]);
        
        // player 4's cards
        deck.add(card[Card.YELLOW][0]);
        deck.add(card[Card.YELLOW][1]);
        deck.add(card[Card.GREEN][5]);
        deck.add(card[Card.GREEN][1]);
        deck.add(card[Card.RED][9]);
        deck.add(card[Card.GREEN][8]);
        deck.add(card[Card.BLUE][0]);
        
        
        // the starting card
        deck.add(card[Card.COLOUR_RED][1]);

        // the deck
        deck.add(card[Card.COLOUR_RED][7]);
        
        Uno game = new Uno (deck, 2);
        assertEquals(2, game.getPlayers().size());
        Player player0 = game.getPlayers().get(0);
        Player player1 = game.getPlayers().get(1);
        Player player2 = game.getPlayers().get(2);
        Player player3 = game.getPlayers().get(3);
        Player player4 = game.getPlayers().get(4);
        
        // player0 should win
        assertEquals(player0, game.play());
    }
    
}

 
            
         
        
         
    
 