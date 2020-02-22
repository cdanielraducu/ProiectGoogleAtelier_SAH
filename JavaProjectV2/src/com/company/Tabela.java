package com.company;

import java.util.Scanner;

public class Tabela implements ObserverSubject {

    private char[][] tabel;
    public Tabela(){
      this.tabel = new char[3][3];
    }

    @Override
    public boolean register(Observer o) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ce coordonate: ");
        int r = scanner.nextInt();
        int c = scanner.nextInt();

        if(tabel[r][c] != 0){
            System.out.println("Acolo e deja pusa o valoare");
            return false;
        } else {
            tabel[r][c] = o.getValue();
            return true;
        }
    }

    void afisare(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(tabel[i][j] != 0){
                    System.out.print(tabel[i][j] + " ");
                } else {
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean verificareO(){
        int c1 =0, c2 = 0;
        for(int i =0; i<3; i++){
            c1 = 0; c2 = 0;
            for(int j = 0; j< 3; j++){
                if(tabel[i][j] == 'O'){
                    c1++;
                } else if (tabel[i][j] == 'X') {
                    c2++;
                }
            }
            if(c1 == 3){
                System.out.println("O a castigat");
                return true;
            } else if(c2 == 3){
                System.out.println("X a castigat");
                return true;
            }
        }
        return false;
    }
    public boolean verificareV(){
        int c1 =0, c2 = 0;
        for(int i =0; i<3; i++){
            c1 = 0; c2 = 0;
            for(int j = 0; j< 3; j++){
                if(tabel[j][i] == 'O'){
                    c1++;
                } else if (tabel[j][i] == 'X') {
                    c2++;
                }
            }
            if(c1 == 3){
                System.out.println("O a castigat");
                return true;
            } else if(c2 == 3){
                System.out.println("X a castigat");
                return true;
            }
        }
        return false;
    }
    public boolean verificareDiagPrincipala(){
        int c1 =0, c2 = 0;
        for(int i = 0; i<3 ;i++){
            if(tabel[i][i] == 'O'){
                c1++;
            } else if(tabel[i][i] == 'X'){
                c2++;
            }
        }
        if(c1 == 3){
            System.out.println("O a castigat");
            return true;
        } else if(c2 == 3){
            System.out.println("X a castigat");
            return true;
        }
        return false;
    }
    public boolean verificareDiagSecundara(){
        int c1 = 0, c2 = 0;

        int j = 0;
        for(int i = 3-1; i >= 0; i--){
            if(tabel[i][j] == 'O'){
                c1++;
            } else if(tabel[i][j] == 'X'){
                c2++;
            }
            j++;
        }
        if(c1 == 3){
            System.out.println("O a castigat");
            return true;
        } else if(c2 == 3){
            System.out.println("X a castigat");
            return true;
        }
         return false;
    }
    public boolean completata(){
        int ok = 0;
        for(int i = 0;i<3; i++){
            for(int j = 0; j<3; j++){
                if(tabel[i][j] != 0){
                    ok++;
                }
            }
        }
        if(ok == 9){
            System.out.println("Nimeni nu a castigat!");
            return true;
        } else {
            return false;
        }
    }
}
