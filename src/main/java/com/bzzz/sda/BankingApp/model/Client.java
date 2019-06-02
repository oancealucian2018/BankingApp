package com.bzzz.sda.BankingApp.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  @Length(max = 50)
  private String nume;

  @Column
  @Length(max = 50)
  private String prenume;

  @Column
  @Length(max = 50)
  private String username;

  @Column
  @Length(max = 50)
  private String parola;

  @ManyToOne
  @JoinColumn(name = "sucursala_id")
  private Sucursala sucursala;

  public Set<Cont> getConturi() {
    return conturi;
  }

  public void setConturi(Set<Cont> conturi) {
    this.conturi = conturi;
  }

  @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
  private Set<Cont> conturi;

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

  public String getPrenume() {
    return prenume;
  }

  public void setPrenume(String prenume) {
    this.prenume = prenume;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getParola() {
    return parola;
  }

  public void setParola(String parola) {
    this.parola = parola;
  }

  public Sucursala getSucursala() {
    return sucursala;
  }

  public void setSucursala(Sucursala sucursala) {
    this.sucursala = sucursala;
  }
}
