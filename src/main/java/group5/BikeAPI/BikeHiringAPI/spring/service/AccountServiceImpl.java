package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import group5.BikeAPI.BikeHiringAPI.spring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository accountRepo;


    public List<Account> all(){

        Iterable<Account> acclist= accountRepo.findAll();
        ArrayList<Account> xyz= (ArrayList<Account>) acclist;
        return xyz;
    }
}
