package com.company;

import java.util.LinkedList;
import java.util.List;

public class Druzyna {
    private String nazwa;
    private int liczbaWygranych;
    private int id;
    private LinkedList<Zawodnik> zawodnicy = new LinkedList<Zawodnik>();
    private int miejsceWTabeli;

    public Druzyna(){

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
    public List<Zawodnik> dodajZawodnikow(int wielkoscDruzyny){

        return zawodnicy;
    }
}






















