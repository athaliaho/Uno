
package uno;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;

        
public class Card {
    
      public enum Color { YELLOW, BLUE, GREEN, RED; }
 
    public enum CardValue { ZERO,ONE,TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, 
                       NINE, TWENTY, FIFTY;}
    
    public enum CardType { NORMAL, DRAW_TWO, REVERSE, SKIP, WILD, WILD_FOUR;} 
    
    int yellow = Color.YELLOW.ordinal();
    int blue = Color.BLUE.ordinal();
    int green = Color.GREEN.ordinal();
    int red = Color.RED.ordinal();
     
    CardValue cardValue;
    Color color;
    CardType cardType;
 
    public Card ( CardValue cardValue, Color color, CardType cardType) {
        this.cardValue = cardValue;
        this.color = color;
        this.cardType = cardType;
        
    }
     
    public String toString(){
        if(cardValue.equals(CardValue.TWENTY)||cardValue.equals(CardValue.FIFTY)){
            return cardValue.name();
        }
        else{
        return cardValue.name()+"-"+color.name();
        }
        }
     
    public boolean canPlay(Card otherCard) {
         
        return this.cardValue == otherCard.cardValue || this.color == otherCard.color;
    }
     
  public boolean canPlayColor(Card otherCard) {
         
        return this.color == otherCard.color;
    }
     
} 

