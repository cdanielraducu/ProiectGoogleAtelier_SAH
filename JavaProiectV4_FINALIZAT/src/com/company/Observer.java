package com.company;

import java.util.List;
import java.util.Map;

public interface Observer {
    char getValue();
    void setCoords(int x, int y);
    int getX();
    int getY();
    int getPlayer();

    List<Pozitie> showMoves();
    List<Pozitie> verifMoves(Map<Pozitie, Observer> tabla,List<Pozitie> pozitii, int cordx, int cordy, int size);
}
