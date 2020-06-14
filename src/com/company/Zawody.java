package com.company;

import java.util.*;

public class Zawody {
    private String rodzajTurniaju;
    private String nazwaTurnieju;
    private static LinkedList<Druzyna> druzyny;              //list druzyn danego turnieju
    Scanner scan = new Scanner(System.in);
    private LinkedList<Druzyna> finaly = new LinkedList<Druzyna>();

    public Zawody() {

    }
    public Zawody(String nazwa) {
        setRodzajTurnieju(nazwa);
        druzyny = new LinkedList<>();
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
    public void dodajTurniej(Zawody turniej) throws Exception {
        if (rodzajTurniaju.equals("Siatkowka"))              //metoda w Rozgrywka
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
    public void przegladDruzyn (WynikiSpotkan wyniki){

        for(Object i : druzyny)
        {
            System.out.println("Druzyna "+((Druzyna)i).getNazwa()+" Wygranych: "+((Druzyna)i).getLiczbaWygranych());
        }
        for (int i=0; i<8; i++){
            wyniki.wyslijDoPliku(druzyny.get(i));
        }
    }
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
    public void topTrzy(WynikiSpotkan wyniki){
        for(int i=0;i<4;i++)
        {
            wyniki.wyslijDoPliku("Miejsce #"+(i+1)+" zajela druzyna "+finaly.get(i).getNazwa(),1);
        }
    }
}