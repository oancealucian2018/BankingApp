package com.bzzz.sda.BankingApp.service;

import com.bzzz.sda.BankingApp.model.Sucursala;
import com.bzzz.sda.BankingApp.repository.SucursalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalaService
{
    @Autowired
    private SucursalaRepository repository;

    public List<Sucursala> findAll(){
        return repository.findAll();
    }

    //create
    // 1. void daca vreau creez entitatea si nu ma mai intereseaza
    //   'Nu ma mai intereseaza' == vad din alt modul/ vad din alta pagina
    // 2. long == entity id (REST) => ii dau UI-ului id-ul resursei nou create
    // 3. entity nou creata => dupa creare sunt redirectat pe detalii

    public void create(Sucursala sucursala){
        repository.save(sucursala);//// se aloca id din baza de date
    }

    public Sucursala update(Sucursala sucursala){
        return null;
    }

    public void delete(Sucursala sucursala){

    }
}
