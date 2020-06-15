package com.company;

import java.util.Scanner;

/**
 * @author klasy Dawid Pieciul, implementacja wyjątku Kacper Chrost
 * Klasa odpowiedzialna za tworzenie rozgrywek z dwóch ogni
 */
public class DwaOgnie extends Rozgrywka{
    private int ilePilek;

    public DwaOgnie(){

    }
    /**
     *
     * @param wynik Obiekt Wynik przekazywany do metody jest po to aby móc wpisać ilość piłek do pliku.
     * Metoda iloscPilek() odpowiada za dodanie do turnieju iloślic piłek do grania w dwa ognie.
     * Ta metoda uruchamiana jest tylko dla rozgrywek dwa ognie.
     * Wyjątek odpowada za sprawdenie czy użytkownik podaje dodatnią wartość ilości piłek.
     */
    public void iloscPilek(WynikiSpotkan wynik){
        int n=0;
        System.out.println("Podaj ile pilek zostanie uzytych w rozgrywkach: ");
        do {
            try {
                n++;
                Scanner podaj=new Scanner(System.in);
                ilePilek = podaj.nextInt();
                if (ilePilek <= 0)
                {
                    throw new Exception();
                }
            }
            catch (Exception ex) {
                System.out.println("Podano nieprawidlowa wartosc pilek. Podaj ponownie: ");
                n=0;
            }
        }while(n==0);
        wynik.wyslijDoPliku("Użyto "+getIlePilek()+" pilek.");
    }

    /**
     * metoda getIlePlek() (getter)
     * @return zwraca ilość piłek
     */
    public int getIlePilek() {
        return ilePilek;
    }
}