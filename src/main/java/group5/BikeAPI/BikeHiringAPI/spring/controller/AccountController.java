package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import group5.BikeAPI.BikeHiringAPI.spring.service.AccountService;

import java.awt.*;
import java.util.List;


@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/list")
    public List<Account> all() {
        return accountService.all();
    }

    @PutMapping(value = "/insert/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void insert(@PathVariable("id") int id) {
        accountService.deleteById(id);
    }


    @PostMapping(value = "/update/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void update(@PathVariable("id") int id, @RequestBody Account a) {
        accountService.updateById(id, a);
    }


}
