package com.bzzz.sda.BankingApp.service;

import com.bzzz.sda.BankingApp.model.Cont;
import com.bzzz.sda.BankingApp.model.Sucursala;
import com.bzzz.sda.BankingApp.repository.ContRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContService {

  @Autowired
  private ContRepository repository;

  public Cont getByClientId(Long clientId) {
    return repository.getOneByClientId(clientId);
  }

  public List<Cont> findAll(){
    return repository.findAll();
  }
}
