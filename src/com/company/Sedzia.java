package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;

public class Sedzia extends Osoba{
    private LinkedList<Osoba> sedziowie = new LinkedList<>();

    public Sedzia(){

    }
    public void dodaj(){

    }
    public void usun(){

    }
    public void przeglad(){


    }
    public void wczytajZPlikuS() throws FileNotFoundException {
        Scanner plik = new Scanner(new File("sedziowie.txt"));
        String imie, nazwisko, zdanie;
        while(plik.hasNext())
        {
            Osoba sedzia = new Osoba();
            zdanie=plik.nextLine();
            String[] ZdaniePom=zdanie.split(" ");
            imie=ZdaniePom[0];
            nazwisko=ZdaniePom[1];
            setImie(imie);
            setNazwisko(nazwisko);
            generuj();
            sedziowie.add(sedzia);
        }
    }
}
