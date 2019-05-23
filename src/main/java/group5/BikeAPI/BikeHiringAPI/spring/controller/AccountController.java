package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import group5.BikeAPI.BikeHiringAPI.spring.service.AccountService;

import java.util.List;


@RestController
public class AccountController {

    @Autowired
    AccountService accountService;
@GetMapping(value="/list")
    public List<Account> all(){
  return  accountService.getAllAccount();


    }
}
