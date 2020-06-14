package com.company;

import java.util.Scanner;

public class DwaOgnie extends Rozgrywka{
    private int wielkoscDruzyny=10;
    private int ilePilek;

    public DwaOgnie(){

    }
    public void iloscPilek(){
        Scanner podaj=new Scanner(System.in);
        System.out.println("Podaj ile pilek zostanie uzytych w rozgrywkach: ");
        ilePilek = podaj.nextInt();
    }
    public int getWielkoscDruzyny(){
        return  wielkoscDruzyny;
    }

    public int getIlePilek() {
        return ilePilek;
    }
}
