package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Plazownie {
    public void plazuj() throws FileNotFoundException {
       Scanner in = null;
       try{
           in = new Scanner(new File("plaza.txt"));
       }
       catch(FileNotFoundException ex)
       {
           System.out.println("Blad pliku: "+ex.getMessage());
           System.exit(1);
       }

        while (in.hasNext())
        {
            String linia = in.nextLine();
            System.out.println(linia);
        }
        in.close();
    }
}
