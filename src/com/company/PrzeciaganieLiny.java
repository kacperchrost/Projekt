package com.company;

import java.util.Scanner;

public class PrzeciaganieLiny extends Rozgrywka{
    private int dlugosc=8;
    public PrzeciaganieLiny(){

    }
    public void dlugoscLiny(WynikiSpotkan wynik){
        int n=0;
        Scanner podaj=new Scanner(System.in);
        System.out.println("Podaj dlugosc przeciaganej liny: ");
        do {
            try {
                n++;
                dlugosc = podaj.nextInt();
                if (dlugosc <= 0)
                {
                    throw new Exception();
                }
            }
            catch (Exception ex) {
                System.out.println("Podano nieprawidlowa dlugosc liny. Podaj ponownie: ");
                n=0;
            }
        }while(n==0);
        wynik.wyslijDoPliku("Przeciagana lina miala dlugosc "+getDlugosc()+" m.");
    }

    public int getDlugosc() {
        return dlugosc;
    }
}
