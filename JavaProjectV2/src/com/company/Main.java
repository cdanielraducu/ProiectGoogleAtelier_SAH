package com.company;

public class Main {

    public static void main(String[] args) {

//        Piesa X = new Piesa('X');
//        Piesa O = new Piesa('O');

        Tabela tabela = new Tabela();

       play(tabela);

    }
    static void play(Tabela tabela){
        Piesa X = new Piesa('X');
        Piesa O = new Piesa('O');
        int tura = 1;
        while(true){
            if(tura == 1){
                if(tabela.register(X)){
                    tura = 2;
                }
            } else if(tura == 2){
                if(tabela.register(O)){
                    tura = 1;
                }
            }
            tabela.afisare();

            if(tabela.verificareO())
                break;
            if(tabela.verificareV())
                break;
            if(tabela.verificareDiagPrincipala())
                break;
            if(tabela.verificareDiagSecundara())
                break;
            if(tabela.completata())
                break;

        }
    }
}
