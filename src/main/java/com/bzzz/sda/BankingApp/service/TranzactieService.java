package com.bzzz.sda.BankingApp.service;

import com.bzzz.sda.BankingApp.contants.AppConstants;
import com.bzzz.sda.BankingApp.model.Cont;
import com.bzzz.sda.BankingApp.model.Tranzactie;
import com.bzzz.sda.BankingApp.repository.TranzactieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TranzactieService {

    @Autowired
    private TranzactieRepository repository;

    @Autowired
    private ContService contService;

    public Tranzactie proceedTransaction(Cont cont, Tranzactie tranzactie) {
        Cont dbCont = contService.getById(cont.getId());
        Double balance = cont.getBalanta();
        String transantionType = tranzactie.getTip();
        if (transantionType.equals(AppConstants.TRANSACTION_TYPE_WITHDRAW)){
            balance = balance - tranzactie.getSuma();
        }  else {
            balance = balance + tranzactie.getSuma();
        }
        dbCont.setBalanta(balance);
        tranzactie.setCont(dbCont);
        return repository.save(tranzactie);
    }
}