package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Player Representation
    //0 - X
    //1 - O
    int count = 0;
    boolean gameActive = true;
    String winnerStr;
    int activePlayer = 0;   //x is our default active Player
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    //State Meanings
    //0 - X
    //1 - O
    //2 - Blank

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  playerTap(View view){
        ImageView img = (ImageView) view;   //view is the information of the imageView which is converted to ImageView form
        int tappedImage = Integer.parseInt(img.getTag().toString());
        TextView status = findViewById(R.id.status);
        if(!gameActive || count==9){
            gameReset(view);
        }
        if(gameState[tappedImage] == 2 && gameActive){
            gameState[tappedImage] = activePlayer;

            if(activePlayer == 0){
                img.setImageResource(R.drawable.o);
                activePlayer = 1;
                status.setText("X's turn - Tap to play");
                count = count+1;
                if(count == 9){
                    status.setText("Draw!,Tap to continue");
                }
            }
            else{
                img.setImageResource(R.drawable.x);
                activePlayer = 0;
                status.setText("O's turn - Tap to play");
                count = count+1;
                if(count == 9){
                    status.setText("Draw!,Tap to continue");
                }
            }
        }
        //check if any player has won
        for(int[] winPosition: winPositions){
            if(gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] !=2   ){
            //find is someone has won the game
                if(gameState[winPosition[0]] == 0){
                    gameActive = false;
                    winnerStr = "O has won!";
                }
                else{
                    gameActive = false;
                    winnerStr = "X has won!";
                }

                //update the status bar for the winner announcement
                status.setText(winnerStr);
            }
        }
    }

    public void gameReset(View view){
        count = 0;
        gameActive = true;
        activePlayer = 0;
        for(int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
    }
}
