package com.example.tpjavafx;

public class Cle {

    private int numero;
    private String couleur;
    private String ouverture;

    public Cle(int leNumero, String laCouleur, String uneOuverture)
    {
        this.numero = leNumero;
        this.couleur = laCouleur;
        this.ouverture = uneOuverture;
    }

    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int unNumero)
    {
        this.numero = unNumero;
    }

    public String getCouleur()
    {
        return couleur;
    }

    public void setCouleur(String laCouleur)
    {
        this.couleur = laCouleur;
    }

    public String getOuverture()
    {
        return ouverture;
    }

    public void setOuverture(String uneOuverture)
    {
        this.ouverture = uneOuverture;
    }

    public String toString()
    {
        return this.numero + " " + this.couleur + " " + this.ouverture;
    }
}