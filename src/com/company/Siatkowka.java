package com.company;

import java.io.FileNotFoundException;

public class Siatkowka extends Rozgrywka {

    public Siatkowka(){

    }
    public void dodajSedziegoPomocniczego(Sedzia sedzia, WynikiSpotkan wynik) throws FileNotFoundException {
        int id = 0;
        wynik.wyslijDoPliku("Przydzielono 2 sedzsiow pomocniczych: ");
        System.out.println("Do tego turnieju przydzielono 2 sedziow pomocniczych:");
        for(int i=0;i<2;i++)
        {
            id=sedzia.przeslijSedziego();
            wynik.wyslijDoPliku(sedzia.sedziowie.get(id).imie);
            wynik.wyslijDoPliku(sedzia.sedziowie.get(id).nazwisko);
            System.out.println(sedzia.sedziowie.get(id).imie+" "+sedzia.sedziowie.get(id).nazwisko+" ");
        }
    }

}






