package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Plazownie {
    public void plazuj() throws FileNotFoundException {
        File plik = new File("plaza.txt");
        Scanner in = new Scanner(plik);

        while (in.hasNext())
        {
            String linia = in.nextLine();
            System.out.println(linia);
        }
        in.close();

    }
}
