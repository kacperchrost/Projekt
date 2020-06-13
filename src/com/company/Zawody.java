package com.company;

import javax.swing.text.SimpleAttributeSet;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Zawody {
    private String data;
    private String rodzajTurniaju;
    private Druzyna druzyny;
    private String nazwaTurnieju;
    protected LinkedList<Osoba> baza;
    Scanner scan = new Scanner(System.in);

    public Zawody() {
        baza = new LinkedList<Osoba>();
    }
    public Zawody(String nazwa) {
        setRodzajTurnieju(nazwa);
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
    public String getNazwaTurnieju(){
        return nazwaTurnieju;
    }
    public void setRodzajTurnieju(String rodzajTurniaju){
        this.rodzajTurniaju=rodzajTurniaju;
    }
    public void setNazwaTurnieju(String nazwaTurnieju){
        this.nazwaTurnieju=nazwaTurnieju;
    }
    void dodajTurniej(Zawodnik zawodnik)  {
        if (rodzajTurniaju.equals("Siatkowka"))              //metoda w siatkowka
        {
            Siatkowka siatkowka = new Siatkowka();
            siatkowka.dodajRozgrywke(zawodnik);
        }
        if (rodzajTurniaju.equals("Dwa ognie"))
        {
            DwaOgnie dwaOgnie = new DwaOgnie();
            //dwaOgnie.dodajRozgrywke();
        }
        if (rodzajTurniaju.equals("Przeciaganie liny"))
        {
            PrzeciaganieLiny przeciaganieLiny = new PrzeciaganieLiny();
            //przeciaganieLiny.dodajRozgrywke();
        }
    }
    void rozegrajTurniej(){

    }
    /*
    void dodajSedziego(Sedzia sedzia){
        baza.add(sedzia);
    }
     */
}















