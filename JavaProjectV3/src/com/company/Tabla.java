package com.company;

import java.util.*;

public class Tabla implements ObserverSubject {


    Map<Pozitie, Observer> tabla;

    public Tabla() {
        this.tabla = new HashMap<>();
    }

    public void setUpTabla() {

        //pioni
        for(int i = 0; i<8 ; i++){
            Pozitie pozitieAux = new Pozitie(1,i);
            Pion pion = new Pion(1,i,1);
            tabla.put(pozitieAux,pion);
        }
        for(int i = 0; i<8 ; i++){
            Pozitie pozitieAux = new Pozitie(6,i);
            Pion pion = new Pion(6,i,2);
            tabla.put(pozitieAux,pion);
        }

        //spatii goale
        for(int i = 0; i<8 ; i++){
            Pozitie pozitieAux = new Pozitie(0,i);
            PiesaNull piesaNull = new PiesaNull(0,i);
            tabla.put(pozitieAux,piesaNull);
        }
        for(int i = 0; i<8 ; i++){
            Pozitie pozitieAux = new Pozitie(2,i);
            PiesaNull piesaNull = new PiesaNull(2,i);
            tabla.put(pozitieAux,piesaNull);
        }
        for(int i = 0; i<8 ; i++){
            Pozitie pozitieAux = new Pozitie(3,i);
            PiesaNull piesaNull = new PiesaNull(3,i);
            tabla.put(pozitieAux,piesaNull);
        }        for(int i = 0; i<8 ; i++){
            Pozitie pozitieAux = new Pozitie(4,i);
            PiesaNull piesaNull = new PiesaNull(4,i);
            tabla.put(pozitieAux,piesaNull);
        }        for(int i = 0; i<8 ; i++){
            Pozitie pozitieAux = new Pozitie(5,i);
            PiesaNull piesaNull = new PiesaNull(5,i);
            tabla.put(pozitieAux,piesaNull);
        }        for(int i = 0; i<8 ; i++){
            Pozitie pozitieAux = new Pozitie(7,i);
            PiesaNull piesaNull = new PiesaNull(7,i);
            tabla.put(pozitieAux,piesaNull);
        }
    }

    public void afisare() {

        Pozitie pozitie = new Pozitie(5, 0);
        Pozitie oldPoz = new Pozitie(6, 0);
        Pion pion = new Pion(6,0,2);
        PiesaNull piesaNull =new PiesaNull(6,0);
        //tabla.entrySet().removeIf(entry -> oldPoz.getX() == entry.getKey().getX() && oldPoz.getY() == entry.getKey().getY());

        tabla.replace(oldPoz,piesaNull);

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                for(Map.Entry<Pozitie,Observer> entry : tabla.entrySet()){
                    if(entry.getKey().getX() == i && entry.getKey().getY() == j) {
                        if (entry.getValue().getValue() != 0) {
                            System.out.print(entry.getValue().getValue() +"-"+ entry.getValue().getPlayer()+" ");//  + ": " + entry.getValue().getX() + " " +entry.getValue().getY()
                        } else {
                            System.out.print("0   ");
                        }
                    }
                }
            }
            System.out.println();
        }

    }

    @Override
    public boolean register(Observer o) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ce coordonate: ");
//        int r = scanner.nextInt();
//        int c = scanner.nextInt();
//
//        if(tabel[r][c] != 0){
//            System.out.println("Acolo e deja pusa o valoare");
//            return false;
//            //aici de fapt o sa fie treaba cand e o batalie intre 2 piese
//        } else {
//            tabel[r][c] = o.getValue();
//            return true;
//        }
        return false;
    }

    @Override
    public boolean unregister(Observer o) {
        return false;
    }



    public void play() {

        setUpTabla();
        afisare();
//                int cordx, cordy;
//                System.out.println("Ce piesa vreti sa mutati? - coord(x,y) - ( 0 - 7 )");
//                Scanner scanner = new Scanner(System.in);
//                cordx = scanner.nextInt();
//                cordy = scanner.nextInt();
//                List<Pozitie> pozitii = new LinkedList<>();
//
//                int playerPiesa = 0;
//                char playerVal = 0;
//                // pt aflarea pozitiei piesei
//                for (int i = 0; i < 8; i++) {
//                    for (int j = 0; j < 8; j++) {
//                        for (Map.Entry<Pozitie, Observer> entry : tabla.entrySet()) {
//                            if (entry.getKey().getX() == i && entry.getKey().getY() == j) {
//                                if (entry.getKey().getX() == cordx && entry.getKey().getY() == cordy) {
//                                    playerPiesa = entry.getValue().getPlayer();
//                                    playerVal = entry.getValue().getValue();
//                                    pozitii = entry.getValue().showMoves();
//                                }
//                            }
//                        }
//                    }
//                }
//                for (int i = 0; i < pozitii.size(); i++) {
//                    if (pozitii.get(i).getX() > -1 && pozitii.get(i).getY() > -1 && pozitii.get(i).getX() < 8 && pozitii.get(i).getY() < 8) {
//                        // le pastram pe alea bune
//                    } else {
//                        // stergem alea care nu incap pe tabla
//                        Pozitie pozTemp = pozitii.get(i);
//                        pozitii.remove(pozTemp);
//                    }
//                }
//
//                // AFISARE POZITIILORE LA CARE POTI MUTA ACEASTA PIESA
//                for (int i = 0; i < pozitii.size(); i++) {
//                    System.out.println(pozitii.get(i).getX() + " " + pozitii.get(i).getY());
//                }
//                System.out.println("Unde vrei sa muti?");
//                int newcordx = scanner.nextInt();
//                int newcordy = scanner.nextInt();
//                int ok2 = 0;
//                for (int i = 0; i < pozitii.size(); i++) {
//                    if (pozitii.get(i).getX() == newcordx && pozitii.get(i).getY() == newcordy) {
//                        ok2 = 1;
//                    }
//                }
//                if (ok2 == 1) {
//                    System.out.println("Piesa de pe " + cordx + "-" + cordy + " se va muta pe " + newcordx + "-" + newcordy);
//                    Pozitie oldPozitii = new Pozitie(cordx,cordy);
//                    Pozitie newPozitii = new Pozitie(newcordx,newcordy);
//                    PiesaNull piesaNull = new PiesaNull(cordx, cordy);
//                    Pion pionVechi = new Pion(6,0,2);
//                    if(tabla.remove(oldPozitii,pionVechi)){
//                        System.out.println("s-a sters");
//                    } else {
//                        System.out.println("Nu s-a sters");
//                    }
//
//                    afisare();
//                } else if (ok2 == 0) {
//                    System.out.println("Nu ati introdus coordonate corespunzatoare!");
//                }
//
//
//
//                // verificat daca se poate acolo sau nu
//                // inregistrat acolo
//                // unregistrat unde era
//        //afisarePozitiiFiecare();

    }

    public void sterge(Pozitie p){
        tabla.remove(p);
    }
    public void add(Pozitie p, Observer o){
        tabla.put(p,o);
    }

    public void afisarePozitiiFiecare(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                for(Map.Entry<Pozitie,Observer> entry : tabla.entrySet()){
                    if(entry.getKey().getX() == i && entry.getKey().getY() == j) {
                        if (entry.getValue().getValue() != 0) {
                            System.out.print(entry.getValue().getValue() + ": " + entry.getValue().getX() +"-"+ entry.getValue().getY()+"   ");//  + ": " + entry.getValue().getX() + " " +entry.getValue().getY()
                        } else {

                        }
                    }
                }
            }
            System.out.println();
        }

    }

    @Override
    public void showMoves(Observer o) {

//    HashMap<Integer, Integer> varianteDeMutat= o.showMoves();
//
//    for(Map.Entry<Integer,Integer> entry : varianteDeMutat.entrySet()){
//        int ok = 1;
//        if(entry.getKey() > - 1 && entry.getKey() < 8){ } else {
//            ok = 0;
//        }
//        if(entry.getValue() > - 1 && entry.getValue() < 8) {} else {
//            ok = 0;
//        }
//        if(ok == 0){
//            varianteDeMutat.remove(entry.getKey(),entry.getValue());
//        }
//    }
//    for(Map.Entry<Integer,Integer> entry : varianteDeMutat.entrySet()){
//        System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//    }
    }
}
