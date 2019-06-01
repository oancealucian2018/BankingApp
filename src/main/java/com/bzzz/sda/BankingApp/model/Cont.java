package com.bzzz.sda.BankingApp.model;

import javax.persistence.*;

@Entity
public class Cont
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "iban", unique = true)
    private String iban;

    @Column (name="balanta")
    private Double balanta;

    @ManyToOne
    @JoinColumn(name = "sucursala_id")
    private Sucursala sucursala;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getIban()
    {
        return iban;
    }

    public void setIban(String iban)
    {
        this.iban = iban;
    }

    public Double getBalanta()
    {
        return balanta;
    }

    public void setBalanta(Double balanta)
    {
        this.balanta = balanta;
    }

    public Sucursala getSucursala()
    {
        return sucursala;
    }

    public void setSucursala(Sucursala sucursala)
    {
        this.sucursala = sucursala;
    }
}
