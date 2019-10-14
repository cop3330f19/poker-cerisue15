/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerjfx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author cerigoff
 */
public class PokerController {
	@FXML private TextField card1_display;
	@FXML private TextField card1_rank;
	
	@FXML private TextField card2_display;
	@FXML private TextField card2_rank;
	
	@FXML private TextField card3_display;
	@FXML private TextField card3_rank;
	
	@FXML private TextField card4_display;
	@FXML private TextField card4_rank;
	
	@FXML private TextField card5_display;
	@FXML private TextField card5_rank;
 
	@FXML private TextField Result;
        
        private int[] cardArr = new int[5];
        private String[] suitArr = new String[5];
        
        private int[][] arr = new int[4][13];
        private int sizeSuits=4;
        private int sizeCards=13;
        
        private String displayMessage;

 
	 public void GetCards(ActionEvent e)
	 {
	     cardArr[0] = Integer.parseInt(card1_display.getText());
	     suitArr[0] = card1_rank.getText();
	     
	     cardArr[1] = Integer.parseInt(card2_display.getText());
	     suitArr[1] = card2_rank.getText();
	     
	     cardArr[2] = Integer.parseInt(card3_display.getText());
	     suitArr[2] = card3_rank.getText();
	     
	     cardArr[3] = Integer.parseInt(card4_display.getText());
	     suitArr[3] = card4_rank.getText();
	     
	     cardArr[4] = Integer.parseInt(card5_display.getText());
	     suitArr[4] = card5_rank.getText();
	     
	     //Result.setText("The hand is: " + Result);
	     
	 }
         public void loadIntoArray(){
             String diamond = "D";
             String hearts = "H";
             String clubs = "C";
             String spades = "S";
             
             for(int i=0; i < suitArr.length; i++){
                 if (suitArr[i] == diamond){
                     arr[0][cardArr[i]-1] = 1;
                 }
                 else if (suitArr[i] == hearts){
                     arr[1][cardArr[i]-1] = 1;
                 }
                 else if (suitArr[i] == clubs){
                     arr[2][cardArr[i]-1] = 1;
                 }
                 else if (suitArr[i] == spades){
                     arr[3][cardArr[i]-1] = 1;
                 }
                 else if (suitArr[i] == spades){
                     arr[4][cardArr[i]-1] = 1;
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
             boolean flush = false;
             int consec[] = new int[5];
             
             for(int i=0; i < sizeSuits; i++){
                 for(int j=0; j < sizeCards; j++){
                     if(arr[i][j] == 1){
                         int prev = j;    
                         if(arr[i][j] == 1)
                     }
                 }
             }
             
             if (cardArr[0].compareTo(suitArr[1]) == 0 &&
                 suitArr[0].compareTo(suitArr[2]) == 0 &&
                 suitArr[0].compareTo(suitArr[3]) == 0 &&
                 suitArr[0].compareTo(suitArr[4]) == 0){
                 displayMessage = "The hand is a flush";
                 flush = true;
             }    
            return flush;
         }
         
}
