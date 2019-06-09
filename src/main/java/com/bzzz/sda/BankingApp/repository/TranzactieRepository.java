package com.bzzz.sda.BankingApp.repository;

import com.bzzz.sda.BankingApp.model.Tranzactie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranzactieRepository extends JpaRepository<Tranzactie, Long> {
}
