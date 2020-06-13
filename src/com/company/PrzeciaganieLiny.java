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
    public void dodajRozgrywke()  {
        System.out.println("Wlasnie jest przygotowywany i rozgrywany turniej.");
        System.out.println("Podaj nazwe turnieju");
        String nazwa;
        nazwa= scan.nextLine();
        setNazwaTurnieju(nazwa);
        for (int i=0; i<8; i++)
        {
            Druzyna druzyna = new Druzyna();
            WynikiSpotkan wynik = new WynikiSpotkan();
            System.out.println("Podaj nazwe druzyny nr: "+(i+1));
            nazwa= scan.nextLine();
            druzyna.setNazwa(nazwa);
            dodajDoListy(druzyna);
            wynik.wyslijDoPliku(druzyna);
        }
    }
    public int getWielkoscDruzyny(){
        return  wielkoscDruzyny;
    }
}
