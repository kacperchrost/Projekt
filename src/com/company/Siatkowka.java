package com.company;

import java.io.FileNotFoundException;
import java.util.Random;

public class Siatkowka extends Zawody {
    private int wielkoscDruzyny=6;
    private int idsedziapom;

    public Siatkowka(){

    }
    public void dodajSedziegoPomocniczego(Zawody turniej, Sedzia sedzia){
        int id = 0;
        sedzia.przeglad();
        for(int i=0;i<2;i++)
        {
            Random r = new Random();
            id = r.nextInt(sedzia.sedziowie.size());
            turniej.baza.add( sedzia.sedziowie.get(id));
        }
        System.out.println(turniej.baza.get(0).imie);
        System.out.println(turniej.baza.get(0).nazwisko);
        System.out.println(turniej.baza.get(1).imie);
        System.out.println(turniej.baza.get(1).nazwisko);
        System.out.println("Pomyslnie dodano sedziego pomocniczego ");
    }
    public int getWielkoscDruzyny(){
        return  wielkoscDruzyny;
    }

    void dodajRozgrywke(Zawodnik zawodnik)  {
        System.out.println("Wlasnie jest przygotowywany i rozgrywany turniej.");
        System.out.println("Podaj nazwe turnieju");
        String nazwa;
        nazwa= scan.nextLine();
        setNazwaTurnieju(nazwa);
        for (int i=0; i<8; i++)
        {
            Druzyna druzyna = new Druzyna();
            WynikiSpotkan wynik = new WynikiSpotkan();
            wynik.wyslijDoPliku(druzyna.dodajZawodnikow(wielkoscDruzyny, zawodnik));

        }
    }
}






