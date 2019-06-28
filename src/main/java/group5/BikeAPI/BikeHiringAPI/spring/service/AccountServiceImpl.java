package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import group5.BikeAPI.BikeHiringAPI.spring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepo;


    public List<Account> all() {

        Iterable<Account> acclist = accountRepo.findAll();
        ArrayList<Account> xyz = (ArrayList<Account>) acclist;
        return xyz;
    }

    @Override
    public void insert(Account a) {
        accountRepo.save(a);

    }


    @Override
    public void deleteById(int id) {
        accountRepo.deleteById(id);

    }

    @Override
    public void updateById(int id, Account a) {

        a.setId(id);
        accountRepo.save(a);

    }

    @Override
    public Optional<Account> findById(int id) {
    return  accountRepo.findById(id);
    }
}
