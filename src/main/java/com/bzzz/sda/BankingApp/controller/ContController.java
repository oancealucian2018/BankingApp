package com.bzzz.sda.BankingApp.controller;

import com.bzzz.sda.BankingApp.model.Cont;
import com.bzzz.sda.BankingApp.model.Sucursala;
import com.bzzz.sda.BankingApp.service.ContService;
import com.bzzz.sda.BankingApp.service.SucursalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ContController {
    @Autowired
    private ContService contService;

    @RequestMapping(value = "/all", method = GET)
    public ModelAndView getCont() {
        ModelMap model = new ModelMap();
        List<Cont> conturi = contService.findAll();
        model.put("listaConturi", conturi);
        return new ModelAndView("listaConturi", model);
    }
}