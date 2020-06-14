package com.company;

import java.util.Scanner;

public class DwaOgnie extends Rozgrywka{
    private int wielkoscDruzyny=10;
    private int ilePilek;

    public DwaOgnie(){

    }
    public void iloscPilek(WynikiSpotkan wynik){
        int n=0;
        Scanner podaj=new Scanner(System.in);
        System.out.println("Podaj ile pilek zostanie uzytych w rozgrywkach: ");
        do {
            try {
                n++;
                ilePilek = podaj.nextInt();
                if (ilePilek <= 0)
                {
                    throw new Exception();
                }
            }
            catch (Exception ex) {
                System.out.println("Podano nieprawidlowa wartosc pilek. Podaj ponownie: ");
                n=0;
            }
        }while(n==0);
        wynik.wyslijDoPliku("Użyto "+getIlePilek()+" pilek.");
    }
    public int getWielkoscDruzyny(){
        return  wielkoscDruzyny;
    }

    public int getIlePilek() {
        return ilePilek;
    }
}
