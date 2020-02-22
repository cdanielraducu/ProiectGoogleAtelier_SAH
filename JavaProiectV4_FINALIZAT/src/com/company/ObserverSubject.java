package com.company;

public interface ObserverSubject {
    public void register(Observer2 o);
    public void unregister(Observer2 o);
    public void notify(String msg);
}
