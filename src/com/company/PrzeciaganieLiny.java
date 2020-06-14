package com.company;

import java.util.Scanner;

public class PrzeciaganieLiny extends Rozgrywka{
    private int wielkoscDruzyny=4;
    private int dlugosc=8;
    public PrzeciaganieLiny(){

    }
    public void dlugoscLiny(){
        Scanner podaj=new Scanner(System.in);
        System.out.println("Podaj dlugosc przeciaganej liny: ");
        dlugosc = podaj.nextInt();
    }
    public int getWielkoscDruzyny(){
        return  wielkoscDruzyny;
    }

    public int getDlugosc() {
        return dlugosc;
    }
}
