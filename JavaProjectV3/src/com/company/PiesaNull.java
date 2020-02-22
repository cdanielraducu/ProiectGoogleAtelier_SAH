package com.company;

import java.util.HashMap;
import java.util.List;

public class PiesaNull implements Observer {
    private char val;
    private int x;
    private int y;
    PiesaNull(){
        val = 0;
        x = 0;
        y = 0;
    }
    PiesaNull(int x, int y){
        val = 0;
        this.x = x;
        this.y = y;
    }
    public void setVal(char val){
        this.val = val;
    }
    @Override
    public char getValue() {
        return val;
    }
    @Override
    public void setCoords(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int getPlayer() {
        return 0;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public List<Pozitie> showMoves() {
        return null;
    }
}
