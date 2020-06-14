package com.company;

public class Druzyna {
    private String nazwa;
    protected int liczbaWygranych;

    public Druzyna(){

    }

    public String getNazwa(){
        return nazwa;
    }

    public int getLiczbaWygranych() {
        return liczbaWygranych;
    }

    public void dodajLiczbaWygranych()
    {
        liczbaWygranych++;
    }

    public void setNazwa(String nazwa){
        this.nazwa=nazwa;
    }

}






















