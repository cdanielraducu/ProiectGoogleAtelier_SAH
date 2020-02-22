package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Pion implements Observer {

    char val;
    int x;
    int y;
    int player;

    public Pion(){
        val = 'P';
        int x = 0;
        int y = 0;
        player = 0;
    }
    public Pion(int x, int y, int player){
        val = 'P';
        this.x = x;
        this.y = y;
        this.player = player;
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

    public int getPlayer() {
        return player;
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
        List<Pozitie> pozitii = new LinkedList<>();

        if(player == 2) {
            int copiex = this.x - 1;
            int copiey = this.y - 1;
            pozitii.add(new Pozitie(copiex, copiey));
            copiex = this.x - 1;
            copiey = this.y + 0;
            pozitii.add(new Pozitie(copiex, copiey));
            copiex = this.x - 1;
            copiey = this.y + 1;
            pozitii.add(new Pozitie(copiex, copiey));
        } else if(player == 1){
            int copiex = this.x + 1;
            int copiey = this.y - 1;
            pozitii.add(new Pozitie(copiex, copiey));
            copiex = this.x + 1;
            copiey = this.y + 0;
            pozitii.add(new Pozitie(copiex, copiey));
            copiex = this.x + 1;
            copiey = this.y + 1;
            pozitii.add(new Pozitie(copiex, copiey));
        }
        return pozitii;
    }

}
