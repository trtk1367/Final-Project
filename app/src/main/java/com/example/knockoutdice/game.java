package com.example.knockoutdice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class game extends AppCompatActivity implements View.OnClickListener{
    private TextView PlayerOneScore, PlayerTwoScore, PlayerOneRow_0, PlayerOneRow_1, PlayerOneRow_2,
            PlayerTwoRow_0, PlayerTwoRow_1, PlayerTwoRow_2, DiceVal_0, DiceVal_1;
    private Button [] playersButtons =new Button[18];
        Button Roll;
    private int playerOneScore=0, playerTwoScore=0, playerOneRow_0, playerOneRow_1, playerOneRow_2,
            playerTwoRow_0, playerTwoRow_1, playerTwoRow_2;
    //boardes
    Board gameBoard =new Board();
    int dice;



    //true = player one turn
    Boolean currentPlayer= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Roll= findViewById(R.id.Roll);
        DiceVal_0 = findViewById(R.id.DiceVal_0);
        DiceVal_1 = findViewById(R.id.DiceVal_1);
        PlayerOneScore = findViewById(R.id.PlayerOneScore);
        PlayerTwoScore = findViewById(R.id.PlayerTwoScore);
        PlayerOneRow_0 = findViewById(R.id.PlayerOneRow_0);
        PlayerOneRow_1 = findViewById(R.id.PlayerOneRow_1);
        PlayerOneRow_2 = findViewById(R.id.PlayerOneRow_2);
        PlayerTwoRow_0 = findViewById(R.id.PlayerTwoRow_0);
        PlayerTwoRow_1 = findViewById(R.id.PlayerTwoRow_1);
        PlayerTwoRow_2 = findViewById(R.id.PlayerTwoRow_2);

        Roll = findViewById(R.id.Roll);
        Roll.setOnClickListener(this);

        for (int i=0; i<playersButtons.length;i++){
            String buttonID ="btn_" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            playersButtons[i]=(Button) findViewById(resourceID);
            playersButtons[i].setOnClickListener(this);
        }
       gameBoard.Reset();
        setUnclickable();
  }


    @Override
    public void onClick(View v) {

        if(v == Roll){
            Random random =new Random();
            dice =random.nextInt(7-1)+1;
            choosePlayerButtons();
            DiceVal_0.setText(""+dice+"");
            DiceVal_1.setText(""+dice+"");
            return;
        }
        String buttonID =v.getResources().getResourceEntryName(v.getId());
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length()-1,buttonID.length()));
        gameBoard.AddPoints(gameStatePointer,dice);
        ((Button)v).setText(""+dice+"");
        ((Button)v).setTextColor(Color.parseColor("#FFC34A"));
        UpdateScore();
        setUnclickable();
        PlayerOneScore.setText(""+playerOneScore+"");
        PlayerTwoScore.setText(""+playerTwoScore+"");
        ChangePlayerTurn();
    }
    public void choosePlayerButtons(){
        if (currentPlayer){
            for (int i=0; i<9;i++){
                playersButtons[i].setEnabled(true);
            }
            for (int i =9;i<playersButtons.length;i++){
                playersButtons[i].setEnabled(false);
            }
        }
        else {
            for (int i=0; i<9;i++){
                playersButtons[i].setEnabled(false);
            }
            for (int i =9;i<playersButtons.length;i++){
                playersButtons[i].setEnabled(true);
            }
        }
    }
    public void setUnclickable (){
        for (int i =0;i<playersButtons.length;i++){
            playersButtons[i].setEnabled(false);
        }
    }
    public void UpdateScore(){
        if(currentPlayer)
            playerOneScore+=dice;
        else
            playerTwoScore+=dice;
    }
    public void ChangePlayerTurn(){
        if(currentPlayer)
            currentPlayer=false;
        else
            currentPlayer=true;
    }
}