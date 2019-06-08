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

  @Autowired private ClientService clientService;
  @Autowired private ContService contService;

  //	@InitBinder
  //	protected void initBinder(WebDataBinder binder) {
  //		binder.setValidator(userFormValidator);
  //	}

  @ModelAttribute("client")
  public Client setUpClientForm() {
    return new Client();
  }

  @GetMapping("/")
  public String index() {
    return "login";
  }

  //  	@RequestMapping(value = "/",  method = GET)
  //  	//@ModelAttribute("client")
  //  	public ModelAndView goToLoginPage(HttpSession httpSession) {
  //  		Map<String, Client> model = new HashMap<String, Client>();
  //  		model.put("client", new Client());
  //  		httpSession.setAttribute("client", new Client());
  //  		return new ModelAndView("login", model);
  //  	}

  @PostMapping("/accountDetails")
  public ModelAndView authenticateClient(@ModelAttribute("client") Client client, ModelMap model)
      throws NotAuthorizedException {

    Client dbClient = clientService.getByUsername(client.getUsername());

    if (null == dbClient || false == dbClient.getParola().equals(client.getParola())) {
      throw new NotAuthorizedException("User not authorized!");
    }

    Cont cont = contService.getByClientId(dbClient.getId());
    model.put("cont", cont);
    model.put("client", dbClient);

    return new ModelAndView("accountDetails", model);
  }
}
