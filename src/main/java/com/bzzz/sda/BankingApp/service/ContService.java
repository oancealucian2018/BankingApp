package com.bzzz.sda.BankingApp.service;

import com.bzzz.sda.BankingApp.model.Cont;
import com.bzzz.sda.BankingApp.model.Sucursala;
import com.bzzz.sda.BankingApp.repository.ContRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContService {

  @Autowired
  private ContRepository repository;

  @Transactional(readOnly = true)
  public Cont getByClientId(Long clientId) {
    return repository.getOneByClientId(clientId);
  }

  @Transactional(readOnly = true)
  public List<Cont> findAll(){
    return repository.findAll();
  }

  public Cont getById(Long id) {
    return repository.getOne(id);
  }
}
