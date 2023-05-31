package com.example.tpjavafx;

public class Users {

    private int id;
    private String login;
    private String motDePasse;
    private Character droit;

    public Users(int unId, String unLogin, String unMotDePasse, Character unDroit)
    {
        this.id = unId;
        this.login = unLogin;
        this.motDePasse = unMotDePasse;
        this.droit = unDroit;
    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int unId)
    {
        this.id = unId;
    }

    public String getLogin()
    {
        return this.login;
    }

    public void setLogin(String unLogin)
    {
        this.login = unLogin;
    }

    public String getMotDePasse()
    {
        return this.motDePasse;
    }

    public void setMotDePasse(String unMotDePasse)
    {
        this.motDePasse = unMotDePasse;
    }

    public Character getDroit()
    {
        return this.droit;
    }

    public void setDroit(Character unDroit)
    {
        this.droit = unDroit;
    }
}