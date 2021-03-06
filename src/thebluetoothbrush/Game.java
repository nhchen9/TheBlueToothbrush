/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebluetoothbrush;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Nick
 */
public class Game{
   static int indexX = 0;
   static int indexY = 0;
   int x;
   int y;
   boolean gameOver = false;
   int tcount;  
   boolean toggle;
   Troop[][] board = new Troop[13][13];
   int[][] holder = new int[2][2];
   Troop[] temp = new Troop[2];
   Troop dbase = new Troop( "base" );//theyre all bases
   Troop rbase = new Troop( "base" );//theyre all bases
   Troop cbase = new Troop( "base" );//theyre all bases
   Troop ruff = new Troop( 80, 2, 1, 1, 1);
   Troop arch = new Troop( 50, 3, 1, 1, 6);
   Troop grw = new Troop( 20, 3, 1, 1, 11);
   ArrayList<Integer> dinfo = new ArrayList<Integer>();
   ArrayList<Integer> cinfo = new ArrayList<Integer>();
   ArrayList<Integer> rinfo = new ArrayList<Integer>();
     
       public void newGame(){
         
        tcount = 0;
        dinfo.add(0);
        cinfo.add(0);
        rinfo.add(0);
        dinfo.add(0);
        cinfo.add(0);
        rinfo.add(0);
        for( int i = 0 ; i < 13 ; i ++ ){
            for( int j = 0 ; j < 13 ; j ++ ){
                board[i][j] = new Troop();
            }
        }
        
            for( int i = 4 ; i < 9 ; i ++ ){
                for( int j = 0 ; j < 2 ; j ++ ){
                board[i][j] = new Troop(1000);
                board[j][i] = new Troop(1000);
            }
        }
            
            for( int i = 5 ; i < 8 ; i ++ ){
                board[i][2] = new Troop(1000);
                board[2][i] = new Troop(1000);
            }

        for( int i = 9 ; i < 13 ; i ++ ){
            for( int j = 4 ; j < 13 ; j ++ ){
                board[i][j] = new Troop(1000);
                board[j][i] = new Troop(1000);
            }
       }
            board[4][10].setType(0);
            board[4][9].setType(0);
            board[10][4].setType(0);
            board[9][4].setType(0);
        
        board[0][0] = dbase;
        board[0][12] = cbase;
        board[12][0] = rbase;
        board[1][1] = ruff;
        board[1][11] = arch;
        board[11][1] = grw;
        JFrame frame = new JFrame("The War of The Rats");
        
        //set the min and max dimensions - we don't want them shifting the
        //screen size
        Dimension dim = new Dimension(750,750);
        frame.setMinimumSize(dim);
        //now we fill it with buttons - set the layout to grid layout, then fill
        //with buttons
        frame.setLayout(new GridLayout(13,13));
        //no make the button array
        JButton [][] buttArray = new JButton[13][13];
        for(int i = 0;i<13;i++){
            for(int j = 0;j<13;j++){
                buttArray[i][j] = new JButton();                     
            }
        }
        for(int i = 0;i<13;i++){
            for(int j = 0;j<13;j++){
         
                frame.add(buttArray[i][j]);
            }
        }

        for(int i = 0 ; i < 13 ; i++){
            for(int j = 0;j<13;j++){
                if( board[i][j].getType() == 22){
                    buttArray[i][j].setVisible(false);
                }
     
                
            }
        }
        
       for(int i = 0 ; i < 13 ; i++)
        {
            for(int j = 0 ; j < 13 ; j++){
                buttArray[i][j].addActionListener( new Listener ( i , j ){
                public void actionPerformed(ActionEvent e){
                    
                    if( toggle == false ){
                       holder[0][0] = getX(this); //holder "holds" two sets of coordinates
                       holder[0][1] = getY(this);
                       x = holder[0][0]; //just for shortening
                       y = holder[0][1];
                       toggle = true; //recognizes the second click
                       System.out.println(x);
                       System.out.println(y);//test 
                       
                   }else{
                      
                       temp = doIt(determ(board[x][y],board[getX(this)][getY(this)]), board[x][y],board[getX(this)][getY(this)]); //basically hold two troops
                       System.out.println( temp[0].getType());
                       System.out.println( temp[0].getHealth());
                       System.out.println( temp[1].getType());
                       System.out.println( temp[1].getHealth());
                       board[x][y] = temp[0]; //replaces first one with modified guy
                       board[getX(this)][getY(this)] = temp[1];//replaces first 2nd with modified guy
                       printBoard();
                       toggle = false;
                   }
             }});
            }}
        frame.setVisible(true);
    }
       public void newTurn(){
           tcount++;
           dinfo.set(0, 4);
           cinfo.set(0, 4);
           rinfo.set(0, 4);
           //p1 turn
           for( int i = 0 ; i < 13 ; i ++ ){
               for( int j = 0 ; i < 13 ; i ++ ){
                   if( board[i][j].getType() > 0 && board[i][j].getType() < 6 ){
                       //make movements
                       //attack
                   }
               }
           }
           
           //prompt buying
           
           //p2 turn
           for( int i = 0 ; i < 13 ; i ++ ){
               for( int j = 0 ; i < 13 ; i ++ ){
                   if( board[i][j].getType() > 5 && board[i][j].getType() < 11 ){
                       //make movements
                       //attack
                   }
               }
           }
           
           //prompt buying
           
           //p3 turn
           for( int i = 0 ; i < 13 ; i ++ ){
               for( int j = 0 ; i < 13 ; i ++ ){
                   if( board[i][j].getType() > 10 && board[i][j].getType() < 16 ){
                       //make movements
                       //attack
                   }
               }
           }
           
           //prompt buying
       }
       public void runGame(){
       
           newGame();
           
           while( !gameOver ){
               newTurn();
           }
       }
       public void printBoard(){
           for( int i = 0 ; i < 13 ; i ++ ){
               for( int j = 0 ; j < 13 ; j ++ ){
                   System.out.print(board[i][j].getType() + "  ");
               }
               System.out.println();
           }
       }
}