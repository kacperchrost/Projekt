package com.company;

/**
 * @author Dawid Pieciul
 * Klasa odpowiedzialna za tworzenie rozgrywek z siatkówki
 */
public class Siatkowka extends Rozgrywka {
    /**
     *Konstruktor bezparametrowy
     */
    public Siatkowka(){

    }
    /**
     *
     * @param sedzia Obiekt sedziego przekazywany do metody aby móc odczytywac sędziów z listy sędziów.
     * @param wynik Obiekt Wynik przekazywany do metody jest po to aby móc wpisać sędziów pomocniczych do pliku.
     * Metoda dodajSedziegoPomocniczego() odpowiada za dodanie do turnieju dwóch sędziów pomocniczych z puli sędziów wczytanych z pliku.
     * Ta metoda uruchamiana jest tylko dla rozgrywek siatkówki.
     */
    public void dodajSedziegoPomocniczego(Sedzia sedzia, WynikiSpotkan wynik)  {
        int id = 0;
        wynik.wyslijDoPliku("Przydzielono 2 sedzsiow pomocniczych: ");
        System.out.println("Do tego turnieju przydzielono 2 sedziow pomocniczych:");
        for(int i=0;i<2;i++)
        {
            id=sedzia.przeslijSedziego();
            wynik.wyslijDoPliku(sedzia.sedziowie.get(id).imie);
            wynik.wyslijDoPliku(sedzia.sedziowie.get(id).nazwisko);
            System.out.println(sedzia.sedziowie.get(id).imie+" "+sedzia.sedziowie.get(id).nazwisko+" ");
        }
    }
}