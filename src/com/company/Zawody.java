package com.company;

import javax.swing.text.SimpleAttributeSet;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Zawody {
    private String data;
    private String rodzajTurniaju;
    private String nazwaTurnieju;
    private static LinkedList<Druzyna> druzyny;              //list druzyn danego turnieju
    Scanner scan = new Scanner(System.in);

    public Zawody() {

    }
    public Zawody(String nazwa) {
        setRodzajTurnieju(nazwa);
        druzyny = new LinkedList<>();
    }
    public String getData(){
        return data;
    }
    public String getRodzajTurnieju(){
        return rodzajTurniaju;
    }
    public LinkedList<Druzyna> getDruzyny(){
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

    public void dodajDoListy(Druzyna druzyna){
        druzyny.add(druzyna);
    }

    public void dodajTurniej()  {
        if (rodzajTurniaju.equals("Siatkowka"))              //metoda w Rozgrywka
        {
            Siatkowka siatkowka = new Siatkowka();
            siatkowka.dodajRozgrywke();
        }
        if (rodzajTurniaju.equals("Dwa ognie"))
        {
            DwaOgnie dwaOgnie = new DwaOgnie();
            dwaOgnie.dodajRozgrywke();
            dwaOgnie.iloscPilek();
        }
        if (rodzajTurniaju.equals("Przeciaganie liny"))
        {
            PrzeciaganieLiny przeciaganieLiny = new PrzeciaganieLiny();
            przeciaganieLiny. dlugoscLiny();
            przeciaganieLiny.dodajRozgrywke();
        }
    }
    void rozegrajTurniej(){

    }
    public void przegladDruzyn (){

        for(Object i : druzyny)
        {
            System.out.println("Druzyna "+((Druzyna)i).getNazwa()+" Wygranych: "+((Druzyna)i).getLiczbaWygranych()+" co daje "+((Druzyna)i).getMiejsceWTabeli()+" miejsce w tabeli.");
        }
    }
}















