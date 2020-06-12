package com.company;

import java.util.LinkedList;
import java.util.List;

public class Osoba {

    protected String imie;
    private String nazwisko;
    private int id;
    public Osoba()
    {

    }

    public String getImie(){
        return imie;
    }
    public String getNazwisko(){
        return nazwisko;
    }

    public int getId() {
        return id;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setId(int id) {
        this.id = id;
    }
}
