/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjfx;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author cerigoff
 */
public class FXMLDocumentController implements Initializable {
        
    @FXML private TextField rank1;
    @FXML private TextField suit1;
    
    @FXML private Label label;
	
    @FXML private TextField rank2;
    @FXML private TextField suit2;
	
    @FXML private TextField rank3;
    @FXML private TextField suit3;
	
    @FXML private TextField rank4;
    @FXML private TextField suit4;
	
    @FXML private TextField rank5;
    @FXML private TextField suit5;
 
    @FXML private TextArea displayMessage;
    @FXML private Button display_button;
    
        
    private final int[] cardArr = new int[5];
    private final String[] suitArr = new String[5];
        
    private final int[][] arr = new int[4][13];
    private final int sizeSuits=4;
    private final int sizeCards=13;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @FXML public void getRank1(){ 
        
        System.out.println(rank1.getText());
    }
    
    @FXML
    public void getCards(ActionEvent e) {
        
            System.out.println("got here");

    cardArr[0] = Integer.parseInt(rank1.getText());
    suitArr[0] = suit1.getText();
	     
    cardArr[1] = Integer.parseInt(rank2.getText());
    suitArr[1] = suit2.getText();
	     
    cardArr[2] = Integer.parseInt(rank3.getText());
    suitArr[2] = suit3.getText();
	     
    cardArr[3] = Integer.parseInt(rank4.getText());
    suitArr[3] = suit4.getText();
	     
    cardArr[4] = Integer.parseInt(rank5.getText());
    suitArr[4] = suit5.getText(); 
    
    loadIntoArray();
    displayHand();

    }
    
    @FXML    
    public void displayHand(){
        String hand = "nothing";
        if (isFlush()) { 
            hand = "a Flush";
            if (isStraight()) { hand = "a Straight Flush"; }
        }
        
        if (isStraight()) { hand = "a Straight"; }
        else if (isFourOfAKind()) { hand = "a Four of a kind"; }
        else if (isFullHouse()) { hand = "a Full house"; }
        else if (isThreeOfAKind()) { hand = "a Three of a kind"; }
        else if (isTwoPair()) { hand = "Two pair"; }
        else if (isOnePair()) { hand = "One pair"; }
            


        
        System.out.println("displaying hand");
        if (isFlush() && hand != "a Flush") { displayMessage.setText("The hand is a Flush and " + hand); }
        else
        displayMessage.setText("The hand is " + hand);
    }    
    
    public void loadIntoArray(){
        
        System.out.println("loading array");
        
        String diamond = "D";
        String hearts = "H";
        String clubs = "C";
        String spades = "S";
             
        for(int i=0; i < suitArr.length; i++){
            if (suitArr[i].compareTo(diamond) == 0){
                arr[0][cardArr[i]-1] = 1;
            }
            else if (suitArr[i].compareTo(hearts) == 0){
                arr[1][cardArr[i]-1] = 1;
            }
            else if (suitArr[i].compareTo(clubs) == 0){
                arr[2][cardArr[i]-1] = 1;
            }
            else if (suitArr[i].compareTo(spades) == 0){
                arr[3][cardArr[i]-1] = 1;
            }
                 
        }
             
    }
         
    public boolean isFlush(){   
        boolean flush = false;
        if (suitArr[0].compareTo(suitArr[1]) == 0 &&
            suitArr[0].compareTo(suitArr[2]) == 0 &&
            suitArr[0].compareTo(suitArr[3]) == 0 &&
            suitArr[0].compareTo(suitArr[4]) == 0){
            flush = true;
        }    
        return flush;
             
    }
         
    public boolean isStraight(){     
        boolean straight = false;
        int cnt=0;
        Arrays.sort(cardArr);
        for (int i=0; i<cardArr.length-1; i++){
            if (cardArr[i]+1 == cardArr[i+1]){
                cnt++;
            }
        }
        if (cnt == 4)
            straight = true;
       
        return straight;
    }
         
    public boolean isStraightFlush(){   
        boolean straightFlush = false;
        if(isFlush() == true && isStraight() == true){
            straightFlush = true;
        }
        return straightFlush;
             
    }
    
    public boolean isFourOfAKind(){   
        boolean fourOfAKind = false;
        int cnt = 0;
        Arrays.sort(cardArr);
        if ((cardArr[0] == (cardArr[1]) &&
            cardArr[0] == (cardArr[2]) &&
            cardArr[0] == (cardArr[3])) ||
            (cardArr[1] == (cardArr[2]) &&
            cardArr[1] == (cardArr[3]) &&
            cardArr[1] == (cardArr[4]))){
            fourOfAKind = true;
        }
        return fourOfAKind;
             
    }
    
    public boolean isFullHouse(){
        boolean fullHouse = false;
        Arrays.sort(cardArr);
        if (cardArr[0] == cardArr[1]){
            if (cardArr[2] == cardArr[3] &&
               cardArr[3] == cardArr[4]){
                fullHouse = true;
            }
        }
        else if (cardArr[3] == cardArr[4]){
            if (cardArr[1] == cardArr[2] &&
               cardArr[2] == cardArr[3]){
                fullHouse = true;
            }
        }
        return fullHouse;
    }
    
    public boolean isThreeOfAKind(){   
        boolean threeOfAKind = false;
        Arrays.sort(cardArr);
        if ((cardArr[0] == cardArr[1] &&
            cardArr[0] == cardArr[2]) ||
            (cardArr[1] == cardArr[2] &&
            cardArr[1] == cardArr[3]) ||
            (cardArr[2] == cardArr[3] &&
            cardArr[2] == cardArr[4]) ){
            threeOfAKind = true;
        }
            
        return threeOfAKind;       
    }
    
    public boolean isTwoPair(){   
        boolean twoPair = false;
        Arrays.sort(cardArr);
        if ((cardArr[0] == cardArr[1] &&
            cardArr[2] == cardArr[3]) ||
            (cardArr[1] == cardArr[2] &&
            cardArr[3] == cardArr[4]) ){
            twoPair = true;
        }
            
        return twoPair;       
    }
    
    public boolean isOnePair(){   
        boolean onePair = false;
        Arrays.sort(cardArr);
        if ((cardArr[0] == cardArr[1]) ||
            (cardArr[1] == cardArr[2]) ||
            (cardArr[2] == cardArr[3]) ||
            (cardArr[3] == cardArr[4]) ){
            onePair = true;
        }
            
        return onePair;       
    }
        
    
}
