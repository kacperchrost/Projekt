package com.company;

/**
 * @author Dawid Pieciul, Kacper Chrost, Bartłomiej Busłowski
 * Klasa obsługująca drużyny - klasa matka
 */

public class Druzyna {
    private String nazwa;
    protected int liczbaWygranych;

    /**
     * Konstruktor bezparametrowy
     */
    public Druzyna(){

    }
    /**
     *
     * @return zwraca nazwę drużyny
     * Metoda getNazwa (getter)
     */
    public String getNazwa(){
        return nazwa;
    }
    /**
     *
     * @return zwraca liczbę wygranych meczy
     * Metoda getLiczbaWygranych (getter)
     */
    public int getLiczbaWygranych() {
        return liczbaWygranych;
    }
    /**
     * Metoda zwiększająca liczbę wygranych dla konkretnej drużyny
     */
    public void dodajLiczbaWygranych()
    {
        liczbaWygranych++;
    }
    /**
     *
     * @param nazwa przekazywanie nazwy drużyny
     * Metoda setNazwa (setter)
     */
    public void setNazwa(String nazwa){
        this.nazwa=nazwa;
    }

}