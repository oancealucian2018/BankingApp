package com.bzzz.sda.BankingApp.repository;

import com.bzzz.sda.BankingApp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findOneByUsername(String username);
}
