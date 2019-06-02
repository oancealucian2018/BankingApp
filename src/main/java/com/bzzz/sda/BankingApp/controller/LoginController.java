package com.bzzz.sda.BankingApp.controller;

import com.bzzz.sda.BankingApp.exception.NotAuthorizedException;
import com.bzzz.sda.BankingApp.model.Client;
import com.bzzz.sda.BankingApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@SessionAttributes("client")
public class LoginController {

  //	@Autowired
  //	private UserFormValidator userFormValidator;

  @Autowired private ClientService clientService;

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

  @PostMapping("/login")
  public ModelAndView authenticateClient(@ModelAttribute("client") Client client, ModelMap model) throws NotAuthorizedException {

    Client dbClient = clientService.getByUsername(client.getUsername());

    		if (null == dbClient || false == dbClient.getParola().equals(client.getParola())) {
    			throw new NotAuthorizedException("User not authorized!");
    		}

    		//model.put("user", userService.createQuiz(dbUser));
    		model.put("client", dbClient);

    return new ModelAndView("accountDetails", model);
  }
}
