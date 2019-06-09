package com.bzzz.sda.BankingApp.controller;

import com.bzzz.sda.BankingApp.exception.NotAuthorizedException;
import com.bzzz.sda.BankingApp.model.Client;
import com.bzzz.sda.BankingApp.model.Cont;
import com.bzzz.sda.BankingApp.model.Sucursala;
import com.bzzz.sda.BankingApp.service.ClientService;
import com.bzzz.sda.BankingApp.service.ContService;
import com.bzzz.sda.BankingApp.service.SucursalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ContController {

    @Autowired private ClientService clientService;
    @Autowired private ContService contService;

    @RequestMapping(value = "/all", method = GET)
    public ModelAndView getCont() {
        ModelMap model = new ModelMap();
        List<Cont> conturi = contService.findAll();
        model.put("listaConturi", conturi);
        return new ModelAndView("listaConturi", model);
    }

    @PostMapping("/accountDetails")
    public ModelAndView authenticateClient(@ModelAttribute("client") Client client, ModelMap model, HttpServletRequest request)
            throws NotAuthorizedException {

        Client dbClient = clientService.getByUsername(client.getUsername());

        if (null == dbClient || false == dbClient.getParola().equals(client.getParola())) {
            throw new NotAuthorizedException("User not authorized!");
        }

        Cont cont = contService.getByClientId(dbClient.getId());
        request.getSession().setAttribute("cont", cont);
        model.put("cont", cont);
        model.put("client", dbClient);

        return new ModelAndView("accountDetails", model);
    }
}