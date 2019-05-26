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
    @PutMapping(value = "/insert/{id}")
    public void insert(@PathVariable("id") int id, Account a) {
        accountService.insert(a);
    }


    @PostMapping(value = "/update/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Account a) {
        accountService.updateById(id, a);
    }



    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") int id){
        accountService.deleteById(id);
    }
}
