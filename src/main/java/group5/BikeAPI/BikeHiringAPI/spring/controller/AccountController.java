package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import group5.BikeAPI.BikeHiringAPI.spring.service.AccountService;

import java.awt.*;
import java.util.List;


@RestController
public class AccountController {

    @Autowired
    AccountService accountService;
@GetMapping(value="/list", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Account> all(){
  return  accountService.getAllAccount();
    }
    @PostMapping(value="/add", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Account> insert(){
        return  accountService.a();
    }


}
