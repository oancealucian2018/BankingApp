package com.bzzz.sda.BankingApp.service;

import com.bzzz.sda.BankingApp.model.Client;
import com.bzzz.sda.BankingApp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LoginService {

    @Autowired
    private ClientRepository repository;

    public Client getByUsername(String username){
        return repository.findOneByUsername(username);
    }
}
