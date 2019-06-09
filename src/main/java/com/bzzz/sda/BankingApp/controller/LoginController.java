package com.bzzz.sda.BankingApp.controller;

import com.bzzz.sda.BankingApp.exception.NotAuthorizedException;
import com.bzzz.sda.BankingApp.model.Client;
import com.bzzz.sda.BankingApp.model.Cont;
import com.bzzz.sda.BankingApp.service.ClientService;
import com.bzzz.sda.BankingApp.service.ContService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("client")
public class LoginController {


  @ModelAttribute("client")
  public Client setUpClientForm() {
    return new Client();
  }

  @GetMapping("/")
  public String index() {
    return "login";
  }
}
