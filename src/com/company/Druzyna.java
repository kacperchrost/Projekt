package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Druzyna {
    private String nazwa;
    private int liczbaWygranych;
    private int id;
    private LinkedList<Zawodnik> druzyna = new LinkedList<Zawodnik>();
    private int miejsceWTabeli;
    Scanner podaj=new Scanner(System.in);
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
    public int generujId (int id){

        return id;
    }
    public int zmienLiczbeWygranych(int liczbaWygranych){

        return liczbaWygranych;
    }
    public List dodajZawodnikow(int wielkoscDruzyny, List zawodnicy){
        for (int i=0; i<wielkoscDruzyny; i++)
        {
            druzyna.add((Zawodnik) zawodnicy.get(i));
        }
        System.out.println("Podaj nazwe druzyny: ");
        nazwa= podaj.nextLine();
        generujId(++id);
        return druzyna;
    }
}






















