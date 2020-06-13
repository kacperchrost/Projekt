package com.company;

import java.util.LinkedList;

public class Zawody {
    private String data;
    private String rodzajTurniaju;
    private Druzyna druzyny;
    private String nazwaSpotkania;
    protected LinkedList<Osoba> baza;

    public Zawody() {
        baza = new LinkedList<Osoba>();
    }
    public String getData(){
        return data;
    }
    public String getRodzajTurnieju(){
        return rodzajTurniaju;
    }
    public Druzyna getDruzyny(){
        return druzyny;
    }
    public String getNazwaSpotkania(){
        return nazwaSpotkania;
    }
    public void setRodzajTurnieju(String rodzajTurniaju){
        this.rodzajTurniaju=rodzajTurniaju;
    }
    public void setNazwaSpotkania(String nazwaSpotkania){
        this.nazwaSpotkania=nazwaSpotkania;
    }
    void dodajTurniej(){

    }
    void rozegrajTurniej(){

    }

}















