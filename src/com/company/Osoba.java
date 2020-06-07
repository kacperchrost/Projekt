package com.company;

import java.util.LinkedList;
import java.util.List;

public class Osoba {
    private int id;
    private String imie;
    private String nazwisko;

    public Osoba(){

    }

    public String getImie(){
        return imie;
    }
    public String getNazwisko(){
        return nazwisko;
    }
    public int getId(){
        return id;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int generuj() {

        return id;
    }

}
