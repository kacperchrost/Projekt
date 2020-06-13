package com.company;

import com.company.Sedzia;
import java.util.Scanner;

public class Siatkowka extends Zawody {
    private int wielkoscDruzyny;
    private int idsedziapom;

    public Siatkowka(){

    }
    public void dodajSedziegoPomocniczego(Zawody turniej){

        idsedziapom=Sedzia.getRandomId();
        turniej.baza.add(Sedzia.getSedzia(idsedziapom));
        System.out.println("Pomyslnie dodano sedziego pomocniczego ");

    }
    public int getWielkoscDruzyny(){
        return  wielkoscDruzyny;
    }
}
