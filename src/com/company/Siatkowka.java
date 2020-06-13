package com.company;

import java.util.Random;

public class Siatkowka extends Zawody {
    private int wielkoscDruzyny;
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

            if (baza.indexOf(sedzia.sedziowie.get(id))== -1) {
                turniej.baza.add(sedzia.sedziowie.get(id));
            }
            else {
                i--;
            }
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
}
