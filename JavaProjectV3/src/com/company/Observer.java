package com.company;
import java.util.HashMap;
import java.util.List;

public interface Observer {

    char getValue();
    void setCoords(int x, int y);
    int getX();
    int getY();
    int getPlayer();

    List<Pozitie> showMoves();
}
