/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerjfx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.util.Arrays;

/**
 *
 * @author cerigoff
 */
public class PokerController {
	@FXML private TextField rank1;
	@FXML private TextField suit1;
	
	@FXML private TextField rank2;
	@FXML private TextField suit2;
	
	@FXML private TextField rank3;
	@FXML private TextField suit3;
	
	@FXML private TextField rank4;
	@FXML private TextField suit4;
	
	@FXML private TextField rank5;
	@FXML private TextField suit5;
 
	@FXML private TextField Result;
        
        private final int[] cardArr = new int[5];
        private final String[] suitArr = new String[5];
        
        private final int[][] arr = new int[4][13];
        private final int sizeSuits=4;
        private final int sizeCards=13;
        
        private String displayMessage;

 
	 public void GetCards(ActionEvent e)
	 {
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
	     
	     //Result.setText("The hand is: " + Result);
	     
	 }
         public void loadIntoArray(){
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
                 displayMessage = "The hand is a flush";
                 flush = true;
             }    
            return flush;
             
         }
         
         public boolean isStraight(){     
             boolean straight = false;
             Arrays.sort(cardArr);
             for (int i=0; i<cardArr.length-1; i++){
                 if (cardArr[i]+1 == cardArr[i+1]){
                     straight = true;
                 }
             }
            return straight;
         }
         
         public boolean isStraightFlush(){   
             boolean straightFlush = false;
             if(isFlush() == true && isStraight() == true){
                 straightFlush = true;
             }
             return straightFlush;
             
         }
         
}
