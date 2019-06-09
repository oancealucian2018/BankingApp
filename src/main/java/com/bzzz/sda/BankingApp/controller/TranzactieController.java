package com.bzzz.sda.BankingApp.controller;

import com.bzzz.sda.BankingApp.contants.AppConstants;
import com.bzzz.sda.BankingApp.model.Cont;
import com.bzzz.sda.BankingApp.model.Tranzactie;
import com.bzzz.sda.BankingApp.service.TranzactieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TranzactieController {

    @Autowired
    private TranzactieService service;

    @PostMapping("/initTransaction")
    public ModelAndView withdraw() {
        ModelMap model = new ModelMap();
        Tranzactie tranzactie = new Tranzactie();
        List<String> transactionTypes = new ArrayList<>();
        transactionTypes.add("Retragere");
        transactionTypes.add("Depunere");
        model.put("transactionTypes", transactionTypes);
        model.put("transaction", tranzactie);
        return new ModelAndView("transaction", model);
    }

    @PostMapping("/transaction")
    public ModelAndView deposit(@SessionAttribute("cont") Cont cont, @ModelAttribute("tranzactie") Tranzactie tranzactie, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        Tranzactie newTransaction = service.proceedTransaction(cont, tranzactie);

        request.getSession().removeAttribute("cont");
        request.getSession().setAttribute("cont", newTransaction.getCont());
        model.put("transaction", newTransaction);
        return new ModelAndView("accountDetails", model);
    }
}
