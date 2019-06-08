package com.bzzz.sda.BankingApp.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
// @Table(name = "Sucursala") //Trebuie sa facem si asta?
public class Sucursala {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "nume", length = 50)
  @Length(max = 50)
  private String nume;

  @Column(name = "adresa", unique = true, columnDefinition = "VARCHAR(40)")
  private String adresa;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "cod", unique = true)
  private int cod;

  @OneToMany(mappedBy = "sucursala", fetch = LAZY)
  private List<Cont> conturi;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNume() {
    return nume;
  }

  public void setNume(String nume) {
    this.nume = nume;
  }

  public String getAdresa() {
    return adresa;
  }

  public void setAdresa(String adresa) {
    this.adresa = adresa;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getCod() {
    return cod;
  }

  public void setCod(int cod) {
    this.cod = cod;
  }

  public List<Cont> getConturi() {
    return conturi;
  }

  public void setConturi(List<Cont> conturi) {
    this.conturi = conturi;
  }
}
