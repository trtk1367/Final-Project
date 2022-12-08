package com.example.knockoutdice;

public class Board {

    private BoardTail GameBoard[];

    public Board() {
        this.GameBoard=new BoardTail[18];
    }
    public void Reset() {
        for (int i = 0; i < GameBoard.length; i++) {
            int coll = i % 3;
            int val = 0;
            int Row=0;
            if (i < 9) {
                Row=i/3;
            }
            else {
                Row = (i - 9) / 3;
            }
        BoardTail t =new BoardTail(coll,val,Row);
        this.GameBoard[i]=t;
        }
    }
    public void AddPoints(int place, int val){
        GameBoard[place].setWorth(val);
    }
    public int UpdateCollScore(Boolean player, int Place){
         int Coll = GameBoard[Place].getColl();
         int CollScore=0;
         if(player){
            for (int i = 0; i<9; i++) {
             if (GameBoard[i].getColl() == Coll)
                 CollScore += GameBoard[i].getWorth();
             }
         }
         else{
             for (int i = 9; i< GameBoard.length; i++) {
                 if (GameBoard[i].getColl() == Coll)
                     CollScore += GameBoard[i].getWorth();
             }
         }
         return CollScore;
    }
}
