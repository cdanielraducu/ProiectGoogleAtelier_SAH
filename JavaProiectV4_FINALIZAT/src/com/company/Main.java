package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Tabla tabla = Tabla.getInstance();
        Player player1 = new Player(1);
        Player player2 = new Player(2);

//        Player player3 = new Player(3);
//        tabla.register(player3);
//        tabla.unregister(player3);

        tabla.register(player1);
        tabla.register(player2);
        tabla.play();
        tabla.notify("castigat");

    }
}
