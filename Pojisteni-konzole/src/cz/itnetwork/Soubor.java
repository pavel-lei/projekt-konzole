package cz.itnetwork;

import java.io.*;
import java.util.ArrayList;
// třída pro filestream, pro souborové čtení a zápis
public class Soubor {
    private File file;
    public Soubor() {
        file = new File("data.txt");
        try {  file.createNewFile();  }
        catch (Exception e){}
    }
    public ArrayList<Pojisteny> nactiPojistene(){
        ArrayList<Pojisteny> p = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            Pojisteny pojisteny;
            while ((pojisteny = (Pojisteny) ois.readObject())!=null) p.add(pojisteny);
        }
        catch (Exception e){}
        return p;
    }
    public void ulozPojistene(ArrayList<Pojisteny> p){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            for (Pojisteny pojisteny: p) oos.writeObject(pojisteny);
        }
        catch (Exception e){}
    }
}
