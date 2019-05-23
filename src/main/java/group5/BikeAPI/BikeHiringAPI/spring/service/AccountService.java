package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.repository.AccountRepository;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepo;


   public List<Account> getAllAccount(){

        Iterable<Account> acclist= accountRepo.findAll();
       ArrayList<Account> xyz= (ArrayList<Account>) acclist;
        return xyz;
    }
}
