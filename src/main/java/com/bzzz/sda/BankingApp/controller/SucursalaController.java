package com.bzzz.sda.BankingApp.controller;

import com.bzzz.sda.BankingApp.model.Sucursala;
import com.bzzz.sda.BankingApp.service.SucursalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/sucursale")
public class SucursalaController {
  @Autowired
  private SucursalaService sucursalaService;

  @RequestMapping(value = "/all", method = GET)
  public ResponseEntity<List<Sucursala>> getSucursale() {
    List<Sucursala> sucursale = sucursalaService.findAll();
    if (sucursale.isEmpty()) {
      return new ResponseEntity<List<Sucursala>>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<List<Sucursala>>(sucursale, HttpStatus.OK);
    }
  }
}
