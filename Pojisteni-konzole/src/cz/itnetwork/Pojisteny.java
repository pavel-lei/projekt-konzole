package cz.itnetwork;

import java.io.Serializable;

//jednoduchá reprezentace pojištěné osoby
public class Pojisteny implements Serializable {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telefon;

    public Pojisteny(String jmeno, String prijmeni, int vek, String telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }

    @Override
    public boolean equals(Object obj) {return obj.equals(jmeno+prijmeni);}

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-4d%s",jmeno, prijmeni, vek, telefon);
    }
}
