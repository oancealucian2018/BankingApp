package com.bzzz.sda.BankingApp.model;

import javax.persistence.*;

@Entity
public class Tranzactie {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private int suma;

  @Column
  private String tip;

  @ManyToOne
  @JoinColumn(name = "cont_id")
  private Cont cont;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getSuma() {
    return suma;
  }

  public void setSuma(int suma) {
    this.suma = suma;
  }

  public String getTip() {
    return tip;
  }

  public void setTip(String tip) {
    this.tip = tip;
  }

  public Cont getCont() {
    return cont;
  }

  public void setCont(Cont cont) {
    this.cont = cont;
  }
}
