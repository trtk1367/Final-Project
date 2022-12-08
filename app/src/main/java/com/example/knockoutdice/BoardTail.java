package com.example.knockoutdice;

public class BoardTail {
    private int coll,row,worth;

    public BoardTail (int coll, int row, int worth){
        this.row=row;
        this.coll=coll;
        this.worth=worth;
    }

    public int getColl() {
        return coll;
    }

    public void setColl(int coll) {
        this.coll = coll;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }
}


