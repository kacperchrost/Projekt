package com.company;


import java.util.LinkedList;
import java.util.Random;

public class Siatkowka extends Zawody {
    private int wielkoscDruzyny=6;
    private int idsedziapom;

    public Siatkowka(){

    }
    public void dodajSedziegoPomocniczego(Zawody turniej, Sedzia sedzia){
        int id = 0;

        for(int i=0;i<2;i++)
        {
            Random r = new Random();
            id = r.nextInt(sedzia.sedziowie.size());
            WynikiSpotkan wynik = new WynikiSpotkan();
            wynik.wyslijDoPliku("Imie: ", sedzia.sedziowie.get(id).imie);
            wynik.wyslijDoPliku("Nazwisko: ", sedzia.sedziowie.get(id).nazwisko);
        }
    }
    public int getWielkoscDruzyny(){
        return  wielkoscDruzyny;
    }

    public void dodajRozgrywke(LinkedList<Druzyna> druzyny)  {
        System.out.println("Wlasnie jest przygotowywany i rozgrywany turniej.");
        System.out.println("Podaj nazwe turnieju");
        String nazwa;
        nazwa= scan.nextLine();
        setNazwaTurnieju(nazwa);
        for (int i=0; i<2; i++)
        {
            Druzyna druzyna = new Druzyna();
            WynikiSpotkan wynik = new WynikiSpotkan();
            System.out.println("Podaj nazwe druzyny nr: "+(i+1));
            nazwa= scan.nextLine();
            druzyna.setNazwa(nazwa);
            wynik.wyslijDoPliku(druzyna);
            dodajDoListy(druzyna);
        }
    }
}






