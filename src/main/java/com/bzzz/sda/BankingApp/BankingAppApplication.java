package com.bzzz.sda.BankingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableTransactionManagement
@EnableWebMvc
public class BankingAppApplication {

  public static void main(String[] args) {

    SpringApplication.run(BankingAppApplication.class, args);
  }

}
