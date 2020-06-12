package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Zawodnik extends Osoba{
    protected LinkedList<Osoba> zawodnicy = new LinkedList<>();
    private int id=0;
    public Zawodnik(){

    }
    public void dodaj(){

    }
    public void usun(){

    }
    public void przeglad(){
        for (Object i : zawodnicy)
        {
            System.out.println(((Osoba)i).getImie()+" "+((Osoba)i).getNazwisko()+" Id:"+((Osoba)i).getId());
        }
    }
    public void wczytajZPlikuZ() throws FileNotFoundException {
        Scanner plik = new Scanner(new File("zawodnicy.txt"));
        String imie, nazwisko, zdanie;
        while(plik.hasNext())
        {
            Osoba sedzia = new Osoba();
            zdanie=plik.nextLine();
            String[] ZdaniePom=zdanie.split(" ");
            imie=ZdaniePom[0];
            nazwisko=ZdaniePom[1];
            sedzia.setImie(imie);
            sedzia.setNazwisko(nazwisko);
            sedzia.setId(++id);
            zawodnicy.add(sedzia);
        }

    }
}
