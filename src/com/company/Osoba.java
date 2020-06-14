package com.company;

/**
 * @author Dawid Pieciul, Kacper Chrost, Bartłomiej Busłowski
 * Klasa odpowiedzialna za tworzenie obietków Osoby w których przechowywani są sędziowie
 */
public class Osoba {

    protected String imie;
    protected String nazwisko;
    protected int id;
    public Osoba()
    {

    }
    /**
     * metoda getImie() (getter)
     * @return zwraca imię osoby
     */
    public String getImie(){
        return imie;
    }

    /**
     * metoda getNazwisko() (getter)
     * @return zwraca nazwisko osoby
     */
    public String getNazwisko(){
        return nazwisko;
    }
    /**
     * metoda getId() (getter)
     * @return zwraca Id osoby
     */
    public int getId() {
        return id;
    }
    /**
     * Metoda setImie() (setter)
     * @param imie przypisanie imienia do obiektu osoby.
     */
    public void setImie(String imie) {
        this.imie = imie;
    }
    /**
     * Metoda setNazwisko() (setter)
     * @param nazwisko przypisanie nazwiska do obiektu osoby.
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    /**
     * Metoda setNazwisko() (setter)
     * @param id przypisanie Id do obiektu osoby.
     */
    public void setId(int id) {
        this.id = id;
    }
}
