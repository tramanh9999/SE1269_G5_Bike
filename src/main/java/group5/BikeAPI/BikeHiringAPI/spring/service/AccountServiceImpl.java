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




    @Override
    public Optional<Account> findByEmail(String email) {
        return Optional.empty();
    }

    public List<Account> all() {

        Iterable<Account> acclist = accountRepo.findAll();
        ArrayList<Account> xyz = (ArrayList<Account>) acclist;
        return xyz;
    }


    @Override
    public int getLastIndex() {
        return accountRepo.getLastIndex();
    }

    @Override
    public boolean insert(Account a) {
        accountRepo.save(a);
        return true;
    }


    @Override
    public boolean deleteById(int id) {
        accountRepo.deleteById(id);
        return true;

    }

    @Override
    public boolean updateById(int id, Account a) {

        a.setId(id);
        accountRepo.save(a);
        return true;

    }

    @Override
    public Optional<Account> findById(int id) {
    return  accountRepo.findById(id);
    }
}
