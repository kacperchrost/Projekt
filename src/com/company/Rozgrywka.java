package com.company;

public class Rozgrywka extends Zawody {
    public void dodajRozgrywke()  {
        System.out.println("Wlasnie jest przygotowywany i rozgrywany turniej.");
        System.out.println("Podaj nazwe turnieju");
        String nazwa;
        nazwa= scan.nextLine();
        setNazwaTurnieju(nazwa);
        for (int i=0; i<8; i++)
        {
            Druzyna druzyna = new Druzyna();
            WynikiSpotkan wynik = new WynikiSpotkan();
            System.out.println("Podaj nazwe druzyny nr: "+(i+1));
            nazwa= scan.nextLine();
            druzyna.setNazwa(nazwa);
            dodajDoListy(druzyna);
            wynik.wyslijDoPliku(druzyna);
        }
    }
}
