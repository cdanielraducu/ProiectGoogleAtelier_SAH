package com.company;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	int[][] tabel = new int[3][3];

    play(tabel);

    }
    static boolean register(Scanner scan,int valoare, int[][] matrice){
        System.out.println("Pe ce pozitie: ");
        int col = scan.nextInt();
        int row = scan.nextInt();
        if(matrice[col][row] != 0){
            System.out.println("Acolo e deja pusa o valoare!");
            return false;
        } else {
        matrice[col][row] = valoare;
        return true;
        }
    }

    static void afisare(int[][] matrice){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(matrice[i][j] == 1){
                    System.out.print("O ");
                } else if(matrice[i][j] == 2){
                    System.out.print("X ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    static void play(int[][] matrice){
        int tura = 1, ok = 1; int c1= 0, c2 = 0;
        while(true){
            ok = 0;
            if(register(scanner,tura,matrice)){
                if(tura == 1){
                    tura = 2;
                } else if(tura == 2){
                    tura = 1;
                }
            }
            afisare(matrice);

            if(verificareOrizontala(matrice))
                break;
            if(verificareVerticala(matrice))
                break;
            if(verificareDiagonalaPrincipala(matrice))
                break;
            if(verificareDiagonalaSecundara(matrice))
                break;
            if(verificaComplet(matrice))
                break;
        }
    }

    static boolean verificareOrizontala(int [][] matrice){
        //verificare daca cineva a castigat pe orizontala
        int c1 = 0,c2 =0;
        for(int k = 0;k < 3 ;k++){
            c1 = 0; c2 = 0;
            for(int i = 0; i < 3; i++){
                if(matrice[k][i] == 1){
                    c1++;
                } else if(matrice[k][i] == 2){
                    c2++;
                }
            }
            if(c1 == 3){
                System.out.println("1 a castigat");
                return true;
            } else if(c2 == 3){
                System.out.println("2 a castigat");
                return true;
            }
        }
        return false;
    }

    static boolean verificareVerticala(int [][] matrice){
        //verificare daca cineva a castigat pe verticala
        int c1 = 0,c2 =0;
        for(int k = 0;k < 3 ;k++){
            c1 = 0; c2 = 0;
            for(int i = 0; i < 3; i++){
                if(matrice[i][k] == 1){
                    c1++;
                } else if(matrice[i][k] == 2){
                    c2++;
                }
            }
            if(c1 == 3){
                System.out.println("1 a castigat");
                return true;
            } else if(c2 == 3){
                System.out.println("2 a castigat");
                return true;
            }
        }
        return false;
    }

    static boolean verificareDiagonalaPrincipala(int [][] matrice) {
        int c1 = 0, c2 =0;

        for(int i = 0;i<3; i++){
            if(matrice[i][i] == 1){
                c1++;
            } else if(matrice[i][i] == 2){
                c2++;
            }
        }
        if(c1 == 3){
            System.out.println("1 a castigat");
            return true;
        }else if(c2 ==3){
            System.out.println("2 a castigat");
            return true;
        }
        return false;
    }

    static boolean verificareDiagonalaSecundara(int [][] matrice) {
        int c1 = 0, c2 =0;

        int j = 0;
        for(int i = 3 - 1;i>=0; i--){
            if(matrice[i][j] == 1){
                c1++;
            } else if(matrice[i][j] == 2){
                c2++;
            }
            j++;
        }
        if(c1 == 3){
            System.out.println("1 a castigat");
            return true;
        }else if(c2 ==3){
            System.out.println("2 a castigat");
            return true;
        }
        return false;
    }

    static boolean verificaComplet(int [][] matrice){
        int ok =0;
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3 ;j++){
                if(matrice[i][j] != 0){
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
