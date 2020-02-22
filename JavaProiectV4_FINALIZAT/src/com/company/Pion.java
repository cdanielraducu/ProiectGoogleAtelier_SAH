package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Pion implements Observer {
    char val;
    int x;
    int y;
    int player;

    public Pion() {
        val = 'P';
        int x = 0;
        int y = 0;
        player = 0;
    }

    public Pion(int x, int y, int player) {
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
    public void setCoords(int x, int y) {
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

        if (player == 2) {
            int copiex = this.x - 1;
            int copiey = this.y - 1;
            pozitii.add(new Pozitie(copiex, copiey));
            copiex = this.x - 1;
            copiey = this.y + 0;
            pozitii.add(new Pozitie(copiex, copiey));
            copiex = this.x - 1;
            copiey = this.y + 1;
            pozitii.add(new Pozitie(copiex, copiey));
        } else if (player == 1) {
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

    @Override
    public List<Pozitie> verifMoves(Map<Pozitie, Observer> tabla, List<Pozitie> pozitii, int cordx, int cordy, int size) {
        pozitii = verifica(tabla, pozitii, cordx, cordy, size);
        pozitii = verifica(tabla, pozitii, cordx, cordy, size);
        return pozitii;
    }

    public List<Pozitie> verifica(Map<Pozitie, Observer> tabla, List<Pozitie> pozitii, int cordx, int cordy, int size) {
        for (int i = 0; i < pozitii.size(); i++) {
            if (pozitii.get(i).getX() > -1 && pozitii.get(i).getY() > -1 && pozitii.get(i).getX() < 8 && pozitii.get(i).getY() < 8) {
                // le pastram pe alea bune
            } else {
                // stergem alea care nu incap pe tabla
                Pozitie pozTemp = pozitii.get(i);
                pozitii.remove(pozTemp);
            }
        }

        int n = pozitii.size();
        int ok = 0;
        for (int i = 0; i < n; i++) {
            for (Map.Entry<Pozitie, Observer> entry : tabla.entrySet()) {
                if (pozitii.size() != i) {
                    if (pozitii.get(i).getX() == entry.getKey().getX() && pozitii.get(i).getY() == entry.getKey().getY()) {
                        if (entry.getValue().getValue() == 0) {
                            if (pozitii.get(i).getY() == cordy + 1 || pozitii.get(i).getY() == cordy - 1) {
                                Pozitie pozTemp = pozitii.get(i);
                                pozitii.remove(pozTemp);
                                ok = 1;
                                break;
                            }
                        } else if(entry.getValue().getValue() != 0){
                            if(pozitii.get(i).getY() == cordy || pozitii.get(i).getY() == cordy){
                                Pozitie pozTemp = pozitii.get(i);
                                pozitii.remove(pozTemp);
                                ok = 1;
                                break;
                            }
                        }
                    }
                    if (ok == 1) {
                        ok = 2;
                        break;
                    }
                }
            }
            if (ok == 2) {
                break;
            }
        }
        return pozitii;
    }
}

