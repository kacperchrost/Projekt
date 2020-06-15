package com.company;

import java.util.*;
/**
 * @author klasy Dawid Pieciul, Kacper Chrost, Bartłomiej Busłowski, implementacja wyjątku Kacper Chrost
 * Klasa odpowiedzialna za tworzenie obiektów zawody w której są listy drużyn
 */
public class Zawody {
    private String rodzajTurniaju;
    private String nazwaTurnieju;
    private static LinkedList<Druzyna> druzyny;              //list druzyn danego turnieju
    Scanner scan = new Scanner(System.in);
    private LinkedList<Druzyna> finaly = new LinkedList<Druzyna>();
    /**
     *Konstruktor bezparametrowy
     */
    public Zawody() {

    }
    /**
     * Konstruktor jednoparametrowy tworzący listę obiektów klasy druzyna oraz nadaje nazwę turniju przekazaną do konstruktora
     */
    public Zawody(String nazwa) {
        setRodzajTurnieju(nazwa);
        druzyny = new LinkedList<>();
    }
    /**
     * metoda getRodzajTurnieju (getter)
     * @return zwraca rodzaj turnieju
     */
    public String getRodzajTurnieju(){
        return rodzajTurniaju;
    }
    /**
     * metoda getDrużyny (getter)
     * @return zwraca listę drużyn
     */
    public LinkedList<Druzyna> getDruzyny(){
        return druzyny;
    }
    /**
     * metoda getNazwaTurnieju (getter)
     * @return zwraca nazwe turnieju
     */
    public String getNazwaTurnieju(){
        return nazwaTurnieju;
    }
    /**
     * metoda setRodzajTurnieju (setter)
     * @param rodzajTurniaju przekazanie rodzaju turnirju
     */
    public void setRodzajTurnieju(String rodzajTurniaju){
        this.rodzajTurniaju=rodzajTurniaju;
    }
    /**
     * metoda setNazwaTurnieju (setter)
     * @param nazwaTurnieju przekazanie nazwy turniju
     */
    public void setNazwaTurnieju(String nazwaTurnieju){
        this.nazwaTurnieju=nazwaTurnieju;
    }
    /**
     * Metoda dodaje drużyne do listy drużyn
     * @param druzyna przekazuje drużyne aby dodać ją do listy drużyn
     */
    public void dodajDoListy(Druzyna druzyna){
        druzyny.add(druzyna);
    }
    /**
     * @author Dawid Pieciul
     * Metoda sprawdza jakiego rodzaju turniej chcemy stworzyć i dodaje rozgrywkę tego rodzaju
     * @param turniej przekazuje Obiekt klasy zawody
     */
    public void dodajTurniej(Zawody turniej)  {
        if (rodzajTurniaju.equals("Siatkowka"))
        {
            Siatkowka siatkowka = new Siatkowka();
            siatkowka.dodajRozgrywke(turniej);
        }
        if (rodzajTurniaju.equals("Dwa ognie"))
        {
            DwaOgnie dwaOgnie = new DwaOgnie();
            dwaOgnie.dodajRozgrywke(turniej);
        }
        if (rodzajTurniaju.equals("Przeciaganie liny"))
        {
            PrzeciaganieLiny przeciaganieLiny = new PrzeciaganieLiny();
            przeciaganieLiny.dodajRozgrywke(turniej);
        }
    }
    /**
     * @author Bartłomiej Busłowski, Kacper Chrost
     * Metoda rozegrajTurniej symuluje rozgrywki każdy na każdego, półfinał oraz finał.
     * Losuje zwycięzce każdego spotkania.
     * Wpisuje do pliku wynik każdej dryżyny w kolejności malejącej oraz podium.
     */
    void rozegrajTurniej(){
        int wynik;
        Random r = new Random();
        for(int i=0;i<8;i++)
        {
            for(int j=(i+1);j<8;j++)
            {
                wynik=r.nextInt(2);
                if(wynik==1)
                {
                    druzyny.get(i).dodajLiczbaWygranych();
                }
                else
                {
                    druzyny.get(j).dodajLiczbaWygranych();
                }
            }
        }
        Collections.sort(druzyny, new Comparator<Druzyna>() {
            @Override
            public int compare(Druzyna o1, Druzyna o2) {
                return o2.getLiczbaWygranych() - o1.getLiczbaWygranych();
            }
        });
        wynik=r.nextInt(2);
        System.out.println("Pierwszy mecz polfinalu wygrala druzyna: "+druzyny.get(wynik).getNazwa());
        finaly.add(druzyny.get(wynik));
        wynik=r.nextInt(2)+2;
        System.out.println("Drugi mecz polfinalu wygrala druzyna: "+druzyny.get(wynik).getNazwa());
        finaly.add(druzyny.get(wynik));
        for(int i=0;i<4;i++)
        {
            if(!finaly.contains(druzyny.get(i)))
            {
                finaly.add(druzyny.get(i));
            }
        }
        wynik=r.nextInt(2);
        if( wynik==1)
        {
            Collections.swap(finaly, 2, 3);
        }
        wynik=r.nextInt(2);
        if(wynik==1)
        {
            Collections.swap(finaly, 0, 1);
        }
        System.out.println("Finaly wygrala druzyna: "+finaly.get(0).getNazwa());
        System.out.println("-----------------------------------------");
        for(int i=0;i<4;i++)
        {
            System.out.println("Miejsce #"+(i+1)+" zajela druzyna "+finaly.get(i).getNazwa());
        }
        System.out.println("-----------------------------------------");
    }
    /**
     * @author Dawid Pieciul
     * Metoda wypisuje na ekran drużyny i ich wygrane oraz przekazuje drużynę do wpisania do pliku
     * @param wyniki przekazuje obiekt wyniki aby móc wypisać na ekran nazwy drużyn i ich liczbę wygranych
     */
    public void przegladDruzyn (WynikiSpotkan wyniki){

        for(Object i : druzyny)
        {
            System.out.println("Druzyna "+((Druzyna)i).getNazwa()+" Wygranych: "+((Druzyna)i).getLiczbaWygranych());
        }
        for (int i=0; i<8; i++){
            wyniki.wyslijDoPliku(druzyny.get(i));
        }
    }
    /**
     * @author Dawid Pieciul
     * Metoda zamienDruzyne usuwa wybraną drużyne i dodaje nową podaną przez użytkownika
     * Wyjątek sprawdza czy użytkownik wpisał nazwę (czy zmienna typu String nie jest pusta)
     */
    public void zamienDruzyne(){
        int n=0, licz=0, k=0;
        System.out.println("Podaj nazwe druzyny do zamienienia");
        String nazwa;
        do {
            try {
                n++;
                nazwa=scan.nextLine();
                for (Object i : druzyny) {
                    if ((((Druzyna) i).getNazwa()).equals(nazwa)) {
                        druzyny.remove(i);
                        break;
                    }
                    else
                    {
                        licz++;
                    }
                }
                if(licz==druzyny.size() || nazwa.isEmpty())
                {
                    throw new Exception();
                }
            }
            catch(Exception ex)
            {
                System.out.println("Druzyna o podanej nazwie nie bierze udzialu w turnieju. Podaj ponownie: ");
                n=0;
                licz=0;
            }
        }while(n==0);
        System.out.println("Podaj nazwe nowej druzyny: ");
        do{
            nazwa= scan.nextLine();
            try{
                k++;
                if(nazwa.isEmpty())
                {
                    throw new Exception();
                }
            }
            catch(Exception ex)
            {
                System.out.println("Nie podano nazwy druzyny. Podaj ponownie: ");
                k=0;
            }
        }while(k==0);
        Druzyna druzyna = new Druzyna();
        druzyna.setNazwa(nazwa);
        dodajDoListy(druzyna);
    }
    /**
     * @author Dawid Pieciul
     * Metoda topTrzy wypisująca do pliku 4 najlpesze druzyny.
     * @param wyniki przekazuje obiekt wyniki aby wysłać do pliku dane najlpeszych drużyn
     */
    public void topTrzy(WynikiSpotkan wyniki){
        for(int i=0;i<4;i++)
        {
            wyniki.wyslijDoPliku("Miejsce #"+(i+1)+" zajela druzyna "+finaly.get(i).getNazwa(),1);
        }
    }
}