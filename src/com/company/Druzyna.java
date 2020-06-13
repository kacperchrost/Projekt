package com.company;

import java.util.LinkedList;

public class Druzyna {
    private String nazwa;
    private int liczbaWygranych;
    private int id;
    private LinkedList<Zawodnik> zawodnicy;
    private int miejsceWTabeli;

    public Druzyna(){
        zawodnicy = new LinkedList<Zawodnik>();
    }

    public String getNazwa(){
        return nazwa;
    }
    public int getId(){
        return id;
    }

    public int getLiczbaWygranych() {
        return liczbaWygranych;
    }

    public int getMiejsceWTabeli() {
        return miejsceWTabeli;
    }
    public void setMiejsceWTabeli (int miejsceWTabeli){
        this.miejsceWTabeli=miejsceWTabeli;
    }
    public int generujId (){

        return id;
    }
    public int zmienLiczbeWygranych(int liczbaWygranych){

        return liczbaWygranych;
    }
    public LinkedList dodajZawodnikow(int wielkoscDruzyny, Zawodnik zawodnik){

        for (int i=0; i<wielkoscDruzyny; i++)
        {
            zawodnicy.add((Zawodnik) zawodnik.przeslijZawodnika());
        }
        return zawodnicy;
    }
}






















