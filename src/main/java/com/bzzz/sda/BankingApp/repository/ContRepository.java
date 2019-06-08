package com.bzzz.sda.BankingApp.repository;

import com.bzzz.sda.BankingApp.model.Cont;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContRepository extends JpaRepository<Cont, Long> {

    Cont getOneByClientId(Long clientId);
}
