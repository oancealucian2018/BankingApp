package com.bzzz.sda.BankingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.bzzz.sda.BankingApp.repository")
public class BankingAppApplication {

  public static void main(String[] args) {

    SpringApplication.run(BankingAppApplication.class, args);
  }

}
