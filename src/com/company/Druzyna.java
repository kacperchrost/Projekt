package com.company;

public class Druzyna {
    private String nazwa;
    private int liczbaWygranych;
    private int id;

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
    public void setNazwa(String nazwa){
        this.nazwa=nazwa;
    }

    public int generujId (){

        return id;
    }
    public int zmienLiczbeWygranych(int liczbaWygranych){

        return liczbaWygranych;
    }
}






















