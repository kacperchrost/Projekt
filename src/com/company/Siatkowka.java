package com.company;


import java.util.LinkedList;
import java.util.Random;

public class Siatkowka extends Rozgrywka {
    private int wielkoscDruzyny=6;
    private int idsedziapom;

    public Siatkowka(){

    }
    public void dodajSedziegoPomocniczego(Zawody turniej, Sedzia sedzia){
        int id = 0;
        System.out.println("Do tego turnieju przydzielono 2 sedziow pomocniczych:");
        for(int i=0;i<2;i++)
        {
            Random r = new Random();
            id = r.nextInt(sedzia.sedziowie.size());
            WynikiSpotkan wynik = new WynikiSpotkan();
            wynik.wyslijDoPliku("Imie: ", sedzia.sedziowie.get(id).imie);
            wynik.wyslijDoPliku("Nazwisko: ", sedzia.sedziowie.get(id).nazwisko);
            System.out.println(sedzia.sedziowie.get(id).imie+" "+sedzia.sedziowie.get(id).nazwisko+" ");
        }
    }
    public int getWielkoscDruzyny(){
        return  wielkoscDruzyny;
    }

}






