package com.company;

public interface ObserverSubject {
    public boolean register(Observer o);
    public boolean unregister(Observer o);
    public void showMoves(Observer o);
}
