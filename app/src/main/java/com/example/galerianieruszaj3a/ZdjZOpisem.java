package com.example.galerianieruszaj3a;

import java.util.ArrayList;

public class ZdjZOpisem {
    private int zdjPsa;
    private String opis;
    private int liczbaPolubien;

    public ZdjZOpisem(int zdjPsa, String opis) {
        this.zdjPsa = zdjPsa;
        this.opis = opis;
    }

    public int getZdjPsa() {
        return zdjPsa;
    }

    public String getOpis() {
        return opis;
    }

    public int getLiczbaPolubien() {
        return liczbaPolubien;
    }

    public void polub(){
        liczbaPolubien++;
    }
}
