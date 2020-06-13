package com.company;

import java.util.Scanner;

public class PrzeciaganieLiny {
    private int wielkoscDruzyny;
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
}
