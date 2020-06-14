package com.company;

import java.util.Scanner;

public class DwaOgnie extends Rozgrywka{
    private int wielkoscDruzyny=10;
    private int ilePilek;

    public DwaOgnie(){

    }
    public void iloscPilek(WynikiSpotkan wynik){
        Scanner podaj=new Scanner(System.in);
        System.out.println("Podaj ile pilek zostanie uzytych w rozgrywkach: ");
        ilePilek = podaj.nextInt();
        wynik.wyslijDoPliku("Użyto "+getIlePilek()+" pilek.");
    }
    public int getWielkoscDruzyny(){
        return  wielkoscDruzyny;
    }

    public int getIlePilek() {
        return ilePilek;
    }
}
