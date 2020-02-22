package com.company;

import java.util.*;

public class Tabla implements ObserverSubject {
    Map<Pozitie, Observer> tabla;
    private static Tabla INSTANCE = null;
    private static int nrInstante =0;
    private int castigat =0;
    private List<Observer2> playeri = new ArrayList<>();
    private Tabla(){
        nrInstante++;
        this.tabla = new HashMap<>();
    }
    static Tabla getInstance(){
        if(nrInstante ==0){
            return INSTANCE = new Tabla();
        } else {
            return INSTANCE;
        }
    }

    @Override
    public void register(Observer2 o) {
        playeri.add(o);
    }

    @Override
    public void unregister(Observer2 o) {
        playeri.remove(o);
    }

    public void setUpTabla() {

        //pioni
        for (int i = 0; i < 8; i++) {
            Pozitie pozitieAux = new Pozitie(1, i);
            Pion pion = new Pion(1, i, 1);
            tabla.put(pozitieAux, pion);
        }
        for (int i = 0; i < 8; i++) {
            Pozitie pozitieAux = new Pozitie(6, i);
            Pion pion = new Pion(6, i, 2);
            tabla.put(pozitieAux, pion);
        }

        //spatii goale
        for (int i = 0; i < 8; i++) {
            Pozitie pozitieAux = new Pozitie(0, i);
            PiesaNull piesaNull = new PiesaNull(0, i);
            tabla.put(pozitieAux, piesaNull);
        }
        for (int i = 0; i < 8; i++) {
            Pozitie pozitieAux = new Pozitie(2, i);
            PiesaNull piesaNull = new PiesaNull(2, i);
            tabla.put(pozitieAux, piesaNull);
        }
        for (int i = 0; i < 8; i++) {
            Pozitie pozitieAux = new Pozitie(3, i);
            PiesaNull piesaNull = new PiesaNull(3, i);
            tabla.put(pozitieAux, piesaNull);
        }
        for (int i = 0; i < 8; i++) {
            Pozitie pozitieAux = new Pozitie(4, i);
            PiesaNull piesaNull = new PiesaNull(4, i);
            tabla.put(pozitieAux, piesaNull);
        }
        for (int i = 0; i < 8; i++) {
            Pozitie pozitieAux = new Pozitie(5, i);
            PiesaNull piesaNull = new PiesaNull(5, i);
            tabla.put(pozitieAux, piesaNull);
        }
        for (int i = 0; i < 8; i++) {
            Pozitie pozitieAux = new Pozitie(7, i);
            PiesaNull piesaNull = new PiesaNull(7, i);
            tabla.put(pozitieAux, piesaNull);
        }
    }

    public void afisare() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (Map.Entry<Pozitie, Observer> entry : tabla.entrySet()) {
                    if (entry.getKey().getX() == i && entry.getKey().getY() == j) {
                        if (entry.getValue().getValue() != 0) {
                            System.out.print(entry.getValue().getValue() + "-" + entry.getValue().getPlayer() + " ");//  + ": " + entry.getValue().getX() + " " +entry.getValue().getY()
                        } else {
                            System.out.print("0   ");
                        }
                    }
                }
            }
            System.out.println();
        }

    }

    public void play() {

        if(playeri.size() == 2) {

            setUpTabla();
            afisare();

            while (true) {
                int cordx, cordy;
                System.out.println("Ce piesa vreti sa mutati? - coord(x,y) - ( 0 - 7 )");
                Scanner scanner = new Scanner(System.in);
                cordx = scanner.nextInt();
                cordy = scanner.nextInt();
                List<Pozitie> pozitii = new LinkedList<>();

                int playerPiesa = 0; // al cui player
                char playerVal = 0; // ce tip de piesa
                // pt aflarea pozitiei piesei
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        for (Map.Entry<Pozitie, Observer> entry : tabla.entrySet()) {
                            if (entry.getKey().getX() == i && entry.getKey().getY() == j) {
                                if (entry.getKey().getX() == cordx && entry.getKey().getY() == cordy) {
                                    if (entry.getValue().getValue() != 0) {
                                        playerPiesa = entry.getValue().getPlayer();
                                        playerVal = entry.getValue().getValue();
                                        pozitii = entry.getValue().showMoves();
                                        int size = pozitii.size();
                                        pozitii = entry.getValue().verifMoves(tabla, pozitii, cordx, cordy, size);
                                        //elimin pozitiile care nu sunt posibile ( conform principilor din sah )
                                    }
                                }
                            }
                        }
                    }
                }
                // AFISARE POZITIILORE LA CARE POTI MUTA ACEASTA PIESA
                for (int i = 0; i < pozitii.size(); i++) {
                    System.out.println(pozitii.get(i).getX() + " " + pozitii.get(i).getY());
                }
                if (pozitii.size() != 0) {
                    System.out.println("Unde vrei sa muti?");
                    int newcordx = scanner.nextInt();
                    int newcordy = scanner.nextInt();
                    int ok2 = 0;
                    for (int i = 0; i < pozitii.size(); i++) {
                        if (pozitii.get(i).getX() == newcordx && pozitii.get(i).getY() == newcordy) {
                            ok2 = 1;
                        }
                    }
                    if (ok2 == 1) {
                        System.out.println("Piesa de pe " + cordx + "-" + cordy + " se va muta pe " + newcordx + "-" + newcordy);
                        Pozitie oldPozitii = new Pozitie(cordx, cordy);
                        Pozitie newPozitii = new Pozitie(newcordx, newcordy);
                        PiesaNull piesaNull = new PiesaNull(cordx, cordy);
                        Pion pionVechi = new Pion(6, 0, 2);
                        Observer piesa = null;
                        if (playerVal == 'P') {
                            piesa = new Pion(newcordx, newcordy, playerPiesa);
                        }

                        for (Map.Entry<Pozitie, Observer> entry : tabla.entrySet()) {
                            if (entry.getKey().getX() == oldPozitii.getX() && entry.getKey().getY() == oldPozitii.getY()) {
                                tabla.replace(entry.getKey(), piesaNull);
                                break;
                            }
                        }
                        for (Map.Entry<Pozitie, Observer> entry : tabla.entrySet()) {
                            if (entry.getKey().getX() == newPozitii.getX() && entry.getKey().getY() == newPozitii.getY()) {
                                tabla.replace(entry.getKey(), piesa);
                                break;
                            }
                        }
                        afisare();

                        //verificare castigat?

                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                for (Map.Entry<Pozitie, Observer> entry : tabla.entrySet()) {
                                    if ((entry.getKey().getX() == 0 && entry.getValue().getValue() != 0 ) || (entry.getKey().getX() == 7 && entry.getValue().getValue() != 0)) {
                                        if (entry.getValue().getPlayer() == 1) {
                                            for (int k = 0; k < playeri.size(); k++) {
                                                if (playeri.get(k).getId() == 1) {
                                                    playeri.get(k).setCastigat(true);
                                                }
                                            }
                                        } else if (entry.getValue().getPlayer() == 2) {
                                            for (int k = 0; k < playeri.size(); k++) {
                                                if (playeri.get(k).getId() == 2) {
                                                    playeri.get(k).setCastigat(true);
                                                }
                                            }
                                        }
                                        castigat = 1;
                                        break;
                                    }
                                }
                                if (castigat == 1) {
                                    castigat = 2;
                                    break;
                                }
                            }
                            if (castigat == 2) {
                                castigat = 3;
                                break;
                            }
                        }
                        if (castigat == 3) {
                            break;
                        }
                        //afisarePozitiiFiecare();
                    } else if (ok2 == 0) {
                        System.out.println("Nu ati introdus coordonate corespunzatoare!");
                    }
                } else {
                    System.out.println("Nu ati introdus coordonatele unei piese de pe tabla");
                }
            }
        } else if(playeri.size() < 2){
            System.out.println("Sunt prea putin playeri");
        } else if(playeri.size() > 2){
            System.out.println("Sunt prea multi playeri");
        }
    }

    public void sterge(Pozitie p) {
        tabla.remove(p);
    }

    public void add(Pozitie p, Observer o) {
        tabla.put(p, o);
    }

    public void afisarePozitiiFiecare() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (Map.Entry<Pozitie, Observer> entry : tabla.entrySet()) {
                    if (entry.getKey().getX() == i && entry.getKey().getY() == j) {
                        if (entry.getValue().getValue() != 0) {
                            System.out.print(entry.getValue().getValue() + ": " + entry.getValue().getX() + "-" + entry.getValue().getY() + "   ");//  + ": " + entry.getValue().getX() + " " +entry.getValue().getY()
                        } else {

                        }
                    }
                }
            }
            System.out.println();
        }

    }

    @Override
    public void notify(String msg) {
        for(Observer2 player : playeri){
            player.update(msg);
        }
    }
}

